package project_euler

/**
 * Problem 15:
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * 問題 15:
 * 2×2 のマス目の左上からスタートした場合, 引き返しなしで右下にいくルートは 6 つある.
 *
 * では, 20×20 のマス目ではいくつのルートがあるか.
 */
object P015 {
  import commons._

  def combination(n: Int, r: Int): Long =
    if (n < r) 0
    else (1 to r).map { k => (n - k + 1, k) }.foldLeft((1L, 1L)) { case ((a, b), (k, m)) =>
      val newK = a * k
      val newM = b * m
      val g = gcd(newK, newM).toLong

      (newK / g, newM / g)
    }
    ._1

  /**
   * 正攻法で
   *   nCr = n!/((n-r)!*r!)
   * としてもいいし、BigIntを使えば高速に計算できるのだが、一工夫してBigIntを使わない方針でやる。
   *
   *   nCr = nPr/r!
   * であるから、書き下すと
   *   nCr = (n * (n - 1) * ... * (n - r + 1)) / (r * (r - 1) * ... * 1)
   *       = (n/r) * ((n - 1)/(r - 1)) * ... * ((n - r + 1)/1)
   * で、これが整数になるのでどこかで確実に約分できる部分があるはず。
   * よって、分数 a/b の分母・分子どうしを掛け算して約分する操作を繰り返す。
   * 最終的に分母は1になり、分子が計算結果になる。
   */
  def solve(n: Int): Long = combination(n * 2, n)
}
