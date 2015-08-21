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
  import commons._

  def primeFactors(n: Long): List[Long] =
    if (n == 1) Nil
    else primes.takeWhile { _ <= math.sqrt(n) }.find { n % _ == 0 } match {
      case Some(k) => k :: primeFactors(n / k)
      case _ => List(n)
    }

  def countNumbers(list: List[Long]) =
    list.groupBy { k => k }.map { case (k, ks) => (k, ks.size) }.toMap

  def merge(map1: Map[Long, Int], map2: Map[Long, Int]) =
    map2.foldLeft(map1) { case (map1, (k, c)) =>
      map1 + (k -> c.max(map1.getOrElse(k, 0)))
    }

  def solve(n: Int): Long =
    (1 until n).map { k =>
      countNumbers(primeFactors(k))
    }.reduceLeft { (map1, map2) =>
      merge(map1, map2)
    }.map { case (k, c) =>
      BigInt(k).pow(c).toLong
    }.product
}
