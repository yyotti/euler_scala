package project_euler

/**
 * Problem 50:
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 *
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 *
 * 問題 50:
 * 素数41は6つの連続する素数の和として表せる:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13.
 * 100未満の素数を連続する素数の和で表したときにこれが最長になる.
 *
 * 同様に, 連続する素数の和で1000未満の素数を表したときに最長になるのは953で21項を持つ.
 *
 * 100万未満の素数を連続する素数の和で表したときに最長になるのはどの素数か?
 */
object P050 {
  import commons._

  def findMaxPrime(ps: Stream[Long], p: Long, max: Int, n: Int): (Long, Int) =
    if (ps.isEmpty) (p, max)
    else {
      val (maxP, m) =
        ps
          .scanLeft((0L, 0)) { case ((s, c), q) => (s + q, c + 1) }
          .takeWhile { _._1 < n }
          .filter { case (s, c) => c > max && isPrime(s) } match {
            case Stream.Empty => (p, max)
            case ls => ls.maxBy { _._2 }
          }
      findMaxPrime(ps.tail, maxP, m, n)
    }

  def solve(n: Int): Long = findMaxPrime(primes.takeWhile { _ < n }, 0, 0, n)._1
}
