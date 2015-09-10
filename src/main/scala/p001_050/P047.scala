package project_euler

/**
 * Problem 47:
 * The first two consecutive numbers to have two distinct prime factors are:
 *
 * 14 = 2 × 7
 * 15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 *
 * 644 = 2^2 × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 *
 * 問題 47:
 * それぞれ2つの異なる素因数を持つ連続する2つの数が最初に現れるのは:
 *
 * 14 = 2 × 7
 * 15 = 3 × 5
 *
 * それぞれ3つの異なる素因数を持つ連続する3つの数が最初に現れるのは:
 *
 * 644 = 2^2 × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19
 *
 * 最初に現れるそれぞれ4つの異なる素因数を持つ連続する4つの数を求めよ. その最初の数はいくつか?
 */
object P047 {
  import commons._

  def primeFactorsCount(n: Long) =
    primeFactors(n).groupBy { p => p }.map { case (p, list) => (p, list.size) }.toSet

  def solve(n: Int): Long =
    from(2)
      .map { n => primeFactorsCount(n) }
      .sliding(n)
      .filter { ls =>
        ls.combinations(2).forall {
          case a #:: b #:: _ => a.size == n && b.size == n && a.intersect(b).isEmpty
        }
      }
      .next
      .map { _.map { case (p, c) => math.pow(p, c).toLong }.product }
      .head
}
