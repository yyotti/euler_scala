package project_euler

/**
 * Problem 49:
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
 * but there is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 *
 * 問題 49:
 * 項差3330の等差数列1487, 4817, 8147は次の2つの変わった性質を持つ.
 *
 * (i)3つの項はそれぞれ素数である.
 * (ii)各項は他の項の置換で表される.
 *
 * 1, 2, 3桁の素数にはこのような性質を持った数列は存在しないが, 4桁の増加列にはもう1つ存在する.
 *
 * それではこの数列の3つの項を連結した12桁の数を求めよ.
 */
object P049 {
  import commons._

  def solve: Long =
    from(1000)
      .takeWhile { _ < 10000 - 3330 * 2 }
      .map { n => List(n, n + 3330, n + 2 * 3330) }
      .find { ls =>
        ls.forall { n => isPrime(n) } &&
        ls.map { _.toString.toSet }.distinct.size == 1 &&
        ls != List(1487, 4817, 8147)
      }
      .get
      .mkString
      .toLong
}
