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
    else if (r <= 0) 0
    else (fact(n) / (fact(n - r) * fact(r))).toLong


  def solve(n: Int): Long = combination(n * 2, n)
}
