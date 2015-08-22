package project_euler

/**
 * Problem 10:
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * 問題 10:
 * 10以下の素数の和は 2 + 3 + 5 + 7 = 17 である.
 *
 * 200万以下の全ての素数の和を求めよ.
 */
object P010 {
  import commons._

  def solve(max: Long): Long =
    primes.takeWhile { _ <= max }.sum
}
