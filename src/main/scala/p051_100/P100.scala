package project_euler

/**
 * Problem 100:
 * If a box contains twenty-one coloured discs, composed of fifteen blue discs and six red discs,
 * and two discs were taken at random, it can be seen that the probability of taking two blue discs,
 * P(BB) = (15/21)×(14/20) = 1/2.
 *
 * The next such arrangement, for which there is exactly 50% chance of taking two blue discs at random,
 * is a box containing eighty-five blue discs and thirty-five red discs.
 *
 * By finding the first arrangement to contain over 1012 = 1,000,000,000,000 discs in total,
 * determine the number of blue discs that the box would contain.
 *
 * 問題 100:
 * 箱の中に15個の青い円盤と6個の赤い円盤からなる21個の色のついた円盤が入っていて, 無作為に2つ取り出すとき, 青い円盤2つを取り出す確率P(BB)は
 *
 * P(BB) = (15/21) × (14/20) = 1/2
 *
 * であることがわかる.
 *
 * 無作為に2つ取り出すとき, 青い円盤2つを取り出す確率がちょうど1/2となるような次の組み合わせは, 箱が85個の青い円盤と35個の赤い円盤からなるときである.
 *
 * 箱の中の円盤の合計が10^12 = 1,000,000,000,000を超えるような最初の組み合わせを考える. 箱の中の青い円盤の数を求めよ.
 */
object P100 {
  import commons._

  val pell = from(1).scanLeft((BigInt(1), BigInt(1))) { case ((x, y), _) => (x + 2 * y, x + y) }.filter { case (x, y) => x % 2 == 1 && y % 2 == 1 }

  /**
   * 二次方程式で解こうとしたら大きすぎて無理だった。別の方針で解く。
   *
   * 箱の中の青い円盤の個数をb、赤い円盤の個数をrとする。箱の中の円盤の総数をNとすれば N = b + r である。
   * このとき P(BB) は
   *   P(BB) = (b/N) * ((b - 1)/(N - 1))
   *         = (b(b - 1))/(N(N - 1))
   * P(BB) = 1/2 となればよいので、
   *   2b(b - 1) = N(N - 1)
   *   2(b^2 - b) = N^2 - N
   *   2{(b - 1/2)^2 - 1/4} = (N - 1/2)^2 - 1/4
   *   2(b - 1/2)^2 - 1/2 = (N - 1/2)^2 - 1/4
   *   8(b - 1/2)^2 - 2 = 4(N - 1/2)^2 - 1
   *   2{2(b - 1/2) * 2(b - 1/2)} - 2 = {2(N - 1/2) * 2(N - 1/2)} - 1
   *   2(2b - 1)^2 - 2 = (2N - 1)^2 - 1
   *   (2N - 1)^2 - 2(2b - 1)^2 = -1
   * x = 2N - 1, y = 2b - 1 とおくと、
   *   x^2 - 2y^2 = -1
   * となる。これはペル方程式であるので、解く。ただし、bもNも自然数であるため、x,yはともに奇数である
   * ことに注意する。
   *
   * 最小解を(x0, y0)とすれば、すぐに
   *   (x0, y0) = (1, 1)
   * と分かる。
   * 2は平方数ではないため、一般解(x, y)は
   *   (x + √2 y) = (x0 + √2 y0)^k = (1 + √2)^k
   * で求めることができる。
   */
  def solve(n: Long): Long =
    pell
      .find { case (x, _) => (x + 1) / 2 > n }
      .map { case (_, y) => ((y + 1) / 2).toLong }
      .get
}
