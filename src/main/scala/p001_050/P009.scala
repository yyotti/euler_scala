package project_euler

/**
 * Problem 9:
 * A Pythagorean triplet is a set of three natural numbers, a &lt; b &lt; c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * 問題 9:
 * ピタゴラス数(ピタゴラスの定理を満たす自然数)とは a &lt; b &lt; c で以下の式を満たす数の組である.
 *
 * a^2 + b^2 = c^2
 * 例えば, 3^2 + 4^2 = 9 + 16 = 25 = 5^2 である.
 *
 * a + b + c = 1000 となるピタゴラスの三つ組が一つだけ存在する.
 * これらの積 abc を計算しなさい.
 */
object P009 {
  def isPytagoreanTriplet(a: Long, b: Long, c: Long) = a * a + b * b == c * c

  def solve: Long =
    (1L to (1000 / 3)).flatMap { a =>
      ((a + 1) to (1000 - a - 1) / 2).map { b =>
        (a, b, 1000 - a - b)
      }
    }.withFilter {
      case (a, b, c) => isPytagoreanTriplet(a, b, c)
    }.map {
      case (a, b, c) => a * b * c
    }.headOption.getOrElse(0)
}
