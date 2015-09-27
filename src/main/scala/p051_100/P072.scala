package project_euler

/**
 * Problem 72:
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * It can be seen that there are 21 elements in this set.
 *
 * How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
 *
 * 問題 72:
 * nとdを正の整数として, 分数 n/d を考えよう. n<d かつ HCF(n,d)=1 のとき, 真既約分数と呼ぶ.
 *
 * d ≤ 8について真既約分数を大きさ順に並べると, 以下を得る:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * この集合は21個の要素をもつことが分かる.
 *
 * d ≤ 1,000,000について, 真既約分数の集合は何個の要素を持つか?
 */
object P072 {
  import commons._

  /**
   * 1 &lt; k &le; d, 1 &le; n &lt; k とする。
   *
   * nとkが互いに素である場合、n/kは真既約分数である。
   * nとkの最大公約数をm(m &ge; 2)とし、
   *   p = n / m
   *   q = k / m
   * とすると、
   *   n/k = p/q
   * が既約分数となるが、これは k = q、n = qのとき個数1でカウントすればいいので、
   * k = dのときにはカウントしなくてよい。
   *
   * 以上のことから、1 &lt; k &le; d について、kと互いに素なk未満の自然数の数を
   * 求め、その和をとればよい。kと互いに素なk未満の自然数の数はオイラーの
   * トーシェント関数φ(k)であるから、求める値をS(d)とすると
   *   S(d) = Σ(k = 2 → d)φ(k)
   * である。
   */
  def solve(d: Int): Long =
    (2 to d).foldLeft(0L) { (z, k) => z + totient(k) }
}
