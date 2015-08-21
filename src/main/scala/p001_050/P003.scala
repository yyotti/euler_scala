package project_euler

/**
 * Problem 3:
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * 問題 3:
 * 13195 の素因数は 5, 7, 13, 29 である.
 *
 * 600851475143 の素因数のうち最大のものを求めよ.
 */
object P003 {
  import commons._

  def primeFactors(n: Long): List[Long] =
    if (n == 1) Nil
    else primes.takeWhile { _ <= math.sqrt(n) }.find { n % _ == 0 } match {
      case Some(k) => k :: primeFactors(n / k)
      case _ => List(n)
    }

  def solve(n: Long): Long = primeFactors(n).last
}
