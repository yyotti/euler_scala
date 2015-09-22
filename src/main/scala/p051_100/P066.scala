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
  import commons._

  val nums = from(1)

  def findMinX(d: Long) = {
    val sCache = collection.mutable.Map[Long, BigInt]()
    val tCache = collection.mutable.Map[Long, BigInt]()
    val aCache = collection.mutable.Map[Long, BigInt]()
    val xCache = collection.mutable.Map[Long, BigInt]()

    def s(k: Long): BigInt = sCache.getOrElseUpdate(k, k match {
      case 0 => 0
      case _ => a(k - 1) * t(k - 1) - s(k - 1)
    })
    def t(k: Long): BigInt = tCache.getOrElseUpdate(k, k match {
      case 0 => 1
      case _ =>
        val i = s(k)
        (d - i * i) / t(k - 1)
    })
    def a(k: Long): BigInt = aCache.getOrElseUpdate(k, k match {
      case 0 => math.sqrt(d).toLong
      case _ => (a(0) + s(k)) / t(k)
    })
    def x(k: Long): BigInt = xCache.getOrElseUpdate(k, k match {
      case -1 => 1
      case 0 => a(0)
      case _ => a(k) * x(k - 1) + x(k - 2)
    })

    nums.find { k => t(k + 1) == 1 }.map { k => x(k) }.get
  }

  def isSquareNumber(n: BigInt) = nums.map { i => BigInt(i) * i }.dropWhile { k => k < n }.head == n

  /**
   * ペル方程式の最小解は下記の方法で高速に求められる。
   *
   * s(0) = 0, t(0) = 1, a(0) = √N とし、
   *   x(-1) = 1, y(-1) = 0, x(0) = a(0), y(0) = 1
   * とするとき、
   *   s(k + 1) = a(k)t(k) - s(k)
   *   t(k + 1) = (N - (s(k + 1))^2)/t(k)
   *   a(k + 1) = (a(0) + s(k + 1))/t(k + 1) の整数部
   *   x(k + 1) = a(k + 1)x(k) + x(k - 1)
   *   y(k + 1) = a(k + 1)y(k) + y(k - 1)
   * であり、t(k + 1)が1になったときの(x(k), y(k))が最小解である。
   */
  def solve(n: Int): Long =
    nums
      .takeWhile { _ <= n }
      .withFilter { d => !isSquareNumber(d) }
      .map { d => (d, findMinX(d)) }
      .maxBy { _._2 }
      ._1

}
