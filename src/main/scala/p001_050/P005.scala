package project_euler

/**
 * Problem 5:
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * 問題 5:
 * 2520 は 1 から 10 の数字の全ての整数で割り切れる数字であり, そのような数字の中では最小の値である.
 *
 * では, 1 から 20 までの整数全てで割り切れる数字の中で最小の正の数はいくらになるか.
 */
object P005 {
  def gcd(m: Long, n: Long): Long =
    if (m < n) gcd(n, m)
    else if (n == 0) m
    else gcd(n, m % n)

  def lcm(m: Long, n: Long): Long = m * n / gcd(m, n)

  def solve(n: Int): Long =
    (1 until n).foldLeft(1L) { (k, n) => lcm(k, n) }
}
