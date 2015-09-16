package project_euler

/**
 * Problem 58:
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.
 *
 * 37 36 35 34 33 32 31
 * 38 17 16 15 14 13 30
 * 39 18  5  4  3 12 29
 * 40 19  6  1  2 11 28
 * 41 20  7  8  9 10 27
 * 42 21 22 23 24 25 26
 * 43 44 45 46 47 48 49
 *
 * It is interesting to note that the odd squares lie along the bottom right diagonal,
 * but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.
 *
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
 * If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 *
 * 問題 58:
 * 1から始めて, 以下のように反時計回りに数字を並べていくと, 辺の長さが7の渦巻きが形成される.
 *
 * 37 36 35 34 33 32 31
 * 38 17 16 15 14 13 30
 * 39 18  5  4  3 12 29
 * 40 19  6  1  2 11 28
 * 41 20  7  8  9 10 27
 * 42 21 22 23 24 25 26
 * 43 44 45 46 47 48 49
 *
 * 面白いことに, 奇平方数が右下の対角線上に出現する. もっと面白いことには, 対角線上の13個の数字のうち, 8個が素数である. ここで割合は8/13 ≈ 62%である.
 *
 * 渦巻きに新しい層を付け加えよう. すると辺の長さが9の渦巻きが出来る. 以下, この操作を繰り返していく. 対角線上の素数の割合が10%未満に落ちる最初の辺の長さを求めよ.
 */
object P058 {
  import commons._

  /*
   * nを1以上の奇数とする。
   * 問題に沿って n x n の螺旋を生成すると、中心には必ず1が配置される。
   *
   * 対角線上の素数の数をP(n)とすると、
   *   P(1) = 0
   * は自明である。
   * n &ge; 3 の場合は、P(n - 1) に最も外側の四角形の頂点の素数の数を
   * 加えればよい。
   *
   * また、対角線上の数字の数をT(n)とすると、
   *   T(1) = 1
   *   T(n) = T(n - 1) + 4
   * である。
   *
   * 最も外側の頂点の右下は n^2 、左下は n^2 - (n - 1)、左上は n^2 - 2(n - 1)、
   * 右上は n^2 - 3(n - 1) であるから、その中の素数の数をカウントすればよい。
   */
  def solve: Long = {
    from(3, 2)
      .scanLeft((1L, 1, 0)) { case ((_, t, p), k) => (k, t + 4, p + Seq(k * k, k * k - (k - 1), k * k - 2 * (k - 1), k * k - 3 * (k - 1)).count { k => isPrime(k) }) }
      .tail
      .dropWhile { case (_, t, p) => p.toDouble * 100 / t >= 10 }
      .head
      ._1
  }
}
