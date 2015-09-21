package project_euler

/**
 * Problem 66:
 * Consider quadratic Diophantine equations of the form:
 *
 * x^2 – Dy^2 = 1
 *
 * For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.
 *
 * It can be assumed that there are no solutions in positive integers when D is square.
 *
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
 *
 * 3^2 – 2×2^2 = 1
 * 2^2 – 3×1^2 = 1
 * 9^2 – 5×4^2 = 1
 * 5^2 – 6×2^2 = 1
 * 8^2 – 7×3^2 = 1
 *
 * Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
 *
 * Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
 *
 * 問題 66:
 * 次の形式の, 2次のディオファントス方程式を考えよう:
 *
 * x^2 - Dy^2 = 1
 *
 * たとえば D=13 のとき, x を最小にする解は 649^2 - 13×180^2 = 1 である.
 *
 * D が平方数(square)のとき, 正整数のなかに解は存在しないと考えられる.
 *
 * D = {2, 3, 5, 6, 7} に対して x を最小にする解は次のようになる:
 *
 * 3^2 - 2×2^2 = 1
 * 2^2 - 3×1^2 = 1
 * 9^2 - 5×4^2 = 1
 * 5^2 - 6×2^2 = 1
 * 8^2 - 7×3^2 = 1
 *
 * したがって, D ≤ 7 に対して x を最小にする解を考えると, D=5 のとき x は最大である.
 *
 * D ≤ 1000 に対する x を最小にする解で, x が最大になるような D の値を見つけよ.
 */
object P066 {
  def from(start: BigInt): Stream[BigInt] = start #:: from(start + 1)

  val nums = from(1)

  def findMinX(d: BigInt) =
    nums
      .dropWhile { _ < 2 }
      .find { x => nums.takeWhile { _ < x }.exists { y => x * x - d * y * y == 1 } }
      .get

  def isSquareNumber(n: BigInt) = nums.map { i => i * i }.dropWhile { k => k < n }.head == n

  def solve(n: Int): Long =
    nums
      .dropWhile { _ < 2 }
      .takeWhile { _ <= n }
      .withFilter { d => !isSquareNumber(d) }
      .map { d => (d, findMinX(d)) }
      .maxBy { _._2 }
      ._1
      .toLong

}
