package project_euler

/**
 * Problem 87:
 * The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28.
 * In fact, there are exactly four numbers below fifty that can be expressed in such a way:
 *
 * 28 = 2^2 + 2^3 + 2^4
 * 33 = 3^2 + 2^3 + 2^4
 * 49 = 5^2 + 2^3 + 2^4
 * 47 = 2^2 + 3^3 + 2^4
 *
 * How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime fourth power?
 *
 * 問題 87:
 * 素数の2乗と素数の3乗と素数の4乗の和で表される最小の数は28である. 50未満のこのような数は丁度4つある.
 *
 * 28 = 2^2 + 2^3 + 2^4
 * 33 = 3^2 + 2^3 + 2^4
 * 49 = 5^2 + 2^3 + 2^4
 * 47 = 2^2 + 3^3 + 2^4
 *
 * では, 50,000,000未満の数で, 素数の2乗と素数の3乗と素数の4乗の和で表される数は何個あるか?
 */
object P087 {
  import commons._

  val primes2 = primes.map { p => p * p }
  val primes3 = primes.map { p => p * p * p }
  val primes4 = primes.map { p => p * p * p * p }

  def solve(n: Int): Long =
    primes4
      .takeWhile { _ < n - primes2.head - primes3.head }
      .flatMap { p4 =>
        primes3
          .takeWhile { _ < n - p4 - primes2.head }
          .flatMap { p3 =>
            primes2
              .takeWhile { _ < n - p4 - p3 }
              .map { p2 => p2 + p3 + p4 }
          }
      }
      .toSet
      .size
}
