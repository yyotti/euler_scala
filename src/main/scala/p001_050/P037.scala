package project_euler

/**
 * Problem 37:
 * The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 *
 * 問題 37:
 * 3797は面白い性質を持っている.
 * まずそれ自身が素数であり, 左から右に桁を除いたときに全て素数になっている (3797, 797, 97, 7).
 * 同様に右から左に桁を除いたときも全て素数である (3797, 379, 37, 3).
 *
 * 右から切り詰めても左から切り詰めても素数になるような素数は11個しかない. 総和を求めよ.
 *
 * 注: 2, 3, 5, 7を切り詰め可能な素数とは考えない.
 */
object P037 {
  import commons._

  def solve: Long = {
    val basePrimes = primes.takeWhile { _ < 10 }
    createTruncatablePrimes(basePrimes, basePrimes).sum
  }

  def createTruncatablePrimes(lps: Seq[Long], rps: Seq[Long]): Seq[Long] = {
    val nextLps = lps.flatMap { p => (1 to 9).map { n => (n.toString + p).toLong } }.filter { n => isPrime(n) }
    val nextRps = rps.flatMap { p => (1 to 9).map { p * 10 + _ } }.filter { n => isPrime(n) }

    if (nextLps.isEmpty || nextRps.isEmpty) Seq.empty
    else nextLps.intersect(nextRps) ++ createTruncatablePrimes(nextLps, nextRps)
  }
}
