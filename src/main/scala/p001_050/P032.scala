package project_euler

/**
 * Problem 32:
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 * 問題 32:
 * すべての桁に 1 から n が一度だけ使われている数をn桁の数がパンデジタル (pandigital) であるということにしよう:
 * 例えば5桁の数 15234 は1から5のパンデジタルである.
 *
 * 7254 は面白い性質を持っている. 39 × 186 = 7254 と書け, 掛けられる数, 掛ける数, 積が1から9のパンデジタルとなる.
 *
 * 掛けられる数/掛ける数/積が1から9のパンデジタルとなるような積の総和を求めよ.
 *
 * HINT: いくつかの積は, 1通り以上の掛けられる数/掛ける数/積の組み合わせを持つが1回だけ数え上げよ.
 */
object P032 {
  /**
   * 掛けられる数、掛ける数、積の桁数をそれぞれ d1, d2, d3 とすると、
   *   d1 + d2 + d3 = 9 (d1 <= d2 <= d3)
   * でなければならない。
   * よって、考えられる組み合わせは
   * (d1, d2, d3) = (1, 1, 7), (1, 2, 6), (1, 3, 5), (1, 4, 4),
   *                (2, 2, 5), (2, 3, 4), (3, 3, 3)
   *
   * また掛け算の性質上、
   *   d3 - 1 <= d1 + d2 <= d3
   * となるはずなので、上記の組み合わせのうち
   * (d1, d2, d3) = (1, 4, 4), (2, 2, 5), (2, 3, 4)
   * 以上が対象となる組み合わせである。
   */
  def solve: Long =
    List((1, 4, 4), (2, 2, 5), (2, 3, 4)).flatMap {
      case (d1, d2, d3) =>
        val min1 = math.pow(10, d1 - 1).toLong
        val max1 = math.pow(10, d1).toLong - 1
        (min1 to max1).flatMap { a =>
          val min2 = math.pow(10, d2 - 1).toLong
          val max2 = math.pow(10, d2).toLong - 1
          (min2 to max2).map { b =>
            (a, b, a * b)
          }
        }.withFilter {
          case (a, b, c) => isPandigital(a, b, c)
        }.map {
          _._3
        }.toSet
    }.sum

  def isPandigital(a: Long, b: Long, c: Long) = (a.toString + b + c).sorted == "123456789"
}
