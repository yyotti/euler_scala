package project_euler

/**
 * Problem 4:
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * 問題 4:
 * 左右どちらから読んでも同じ値になる数を回文数という. 2桁の数の積で表される回文数のうち, 最大のものは 9009 = 91 × 99 である.
 *
 * では, 3桁の数の積で表される回文数の最大値を求めよ.
 */
object P004 {
  def isPalindromeNumber(n: Long): Boolean = {
    val s = n.toString
    s == s.reverse
  }

  def solve(n: Int): Long = ???
}
