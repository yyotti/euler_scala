package project_euler

/**
 * Problem 78:
 * Let p(n) represent the number of different ways in which n coins can be separated into piles.
 * For example, five coins can be separated into piles in exactly seven different ways, so p(5)=7.
 *
 * OOOOO
 * OOOO O
 * OOO OO
 * OOO O O
 * OO OO O
 * OO O O O
 * O O O O O
 *
 * Find the least value of n for which p(n) is divisible by one million.
 *
 * 問題 78:
 * n 枚のコインを異なった方法で山に分ける場合の数を p(n) と表わす.
 * 例えば, 5枚のコインを山に分ける異なったやり方は７通りなので p(5)=7 となる.
 *
 * OOOOO
 * OOOO O
 * OOO OO
 * OOO O O
 * OO OO O
 * OO O O O
 * O O O O O
 *
 * p(n) が100万で割り切れる場合に最小となる n を求めよ.
 */
object P078 {
  import commons._

  def pentagonal(n: Int) = n * (3 * n - 1) / 2

  val pentagonals = from(1).flatMap { i => Seq(pentagonal(i.toInt), pentagonal(-i.toInt)) }
  val signs = from(1).flatMap { _ => Seq(1, 1, -1, -1) }

  val cache = collection.mutable.Map[Int, Int]()

  def p(n: Int): Int = n match {
    case n if n < 0 => 0
    case 0 => 1
    case _ =>
      pentagonals
        .zip(signs)
        .takeWhile { _._1 <= n }
        .foldLeft(0) { case (z, (k, sign)) => (1000000 + sign * cache.getOrElseUpdate(n - k, p(n - k)) + z) % 1000000 }
  }

  /**
   * これもP076と同じだが、普通にやると膨大な時間がかかってしまうのでやり方を変える。
   *
   * 分割数の問題と見る。(以下、Wikipediaの「分割数」のページを参考に実装)
   * 整数nの分割数 p(n) を下記のように定義する。
   *   p(n) = 0   if n &lt; 0
   *          1   if n = 0
   *          p(n - 1) + p(n - 2) - p(n - 5) - p(n - 7) + p(n - 12) + ...     otherwise
   * ここで、otherwise の場合の右辺の各項の引数 n - 1, n - 2, ..., n - k において、
   *   k = m(3m-1)/2   (m = 1, -1, 2, -2, 3, -3, ...)
   * である。k &le; n の範囲で和をとる。各p(n - k)の符号は、++--++--...と変化する。
   *
   * 上記をそのまま実装すれば解けるには解けるのだが、やはり時間がかかりすぎる。
   * n &ge; 1 の場合の右辺で再帰するのをできる限り防ぐために、既に出現したp(n - k)の値は
   * キャッシュする。
   *
   * 最終的なp(n)の値はBigIntの範囲になる。
   * しかし、今回はp(n)を1,000,000で割った余りが分かればよいので、p(n)の定義を下記
   * のように変更する。
   *   p(n) = 0   if n &lt; 0
   *          1   if n = 0
   *          p(n - 1) + p(n - 2) - p(n - 5) - ... mod 1,000,000    otherwise
   * これでIntの範囲で計算できるので、ある程度は速くなる。
   */
  def solve: Long = {
    cache.clear
    from(1).find { i => p(i.toInt) == 0 }.get
  }
}
