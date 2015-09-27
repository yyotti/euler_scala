package project_euler

/**
 * Problem 71:
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 *
 * By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
 *
 * 問題 71:
 * nとdを正の整数として, 分数 n/d を考えよう. n<d かつ HCF(n,d)=1 のとき, 真既約分数と呼ぶ.
 *
 * d ≤ 8について既約分数を大きさ順に並べると, 以下を得る:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * 3/7のすぐ左の分数は2/5である.
 *
 * d ≤ 1,000,000について真既約分数を大きさ順に並べたとき, 3/7のすぐ左の分数の分子を求めよ.
 */
object P071 {
  import commons._

  def max(x: (Long, Long), y: (Long, Long)) = {
    val (n1, d1) = x
    val (n2, d2) = y
    val m = lcm(d1, d2)
    if (n1 * m / d1 > n2 * m / d2) (n1, d1)
    else (n2, d2)
  }

  /**
   * 2 &le; k &le; d、1 &le; x &le; k として、x/k &lt; 3/7を満たす x/k の最大値を求める。
   *
   * lcm(m, n)をmとnの最小公倍数、gcd(m, n)をmとnの最大公約数とする。
   *   m = lcm(k, 7)
   *   p = m/7
   *   q = m/k
   * とすると、x/k &lt; 3/7を通分すると
   *   (x*q)/(k*q) &lt; (3*p)/(7*p)
   * となる。これを満たす左辺の最大値は (x*q-1)/(k*q) であるが、これを約分して分母が k に
   * ならなければならない。
   * そこで、分子を
   *   x*q-i ≡ 0 (mod q)
   * となる自然数iを見つければよい。
   *
   * 条件を満たす全てのkについて上記の手順で最大値を計算し、その中の最大値が答えとなる。
   */
  def solve(d: Int): Long = {
    val nums = from(1)
    nums
      .tail
      .takeWhile { _ <= d }
      .flatMap { k =>
        val m = lcm(k, 7).toLong
        val p = m / 7
        val q = m / k
        nums.map { i => 3 * p - i }.find { _ % q == 0 }.map { n => val g = gcd(n, m).toInt; (n / g, m / g) }
      }
      .foldLeft ((1L, 7L)) { max(_, _) }
      ._1
  }
}
