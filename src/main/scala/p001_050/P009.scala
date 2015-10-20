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
  import commons._

  val primitivePythagoreanTriprets =
    Stream
      .from(2)
      .flatMap { m => (1 until m).withFilter { n => gcd(m, n) == 1 && (m - n) % 2 == 1 }.map { n => (m * m - n * n, 2 * m * n, m * m + n * n) }  }

  /**
   * a &lt; b &lt; c であるが、もし a &ge; b であっても、aとbを入れ替えればよい。
   * よって、原始ピタゴラス数を(a0, b0, c0)とすると、
   *   k(a0 + b0 + c0) = 1000
   * を満たす(a0, b0, c0)およびkを探し、
   *   k*a0 * k*b0 * k*c0
   * の値を計算すればよい。
   */
  def solve: Long =
    primitivePythagoreanTriprets
      .find { case (a, b, c) => 1000 % (a + b + c) == 0 }
      .map { case (a, b, c) => a * b * c * math.pow(1000 / (a + b + c), 3).toLong }
      .get
}
