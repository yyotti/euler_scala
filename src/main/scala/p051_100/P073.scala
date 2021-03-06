package project_euler

/**
 * Problem 73:
 * Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * It can be seen that there are 3 fractions between 1/3 and 1/2.
 *
 * How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
 *
 * 問題 73:
 * nとdを正の整数として, 分数 n/d を考えよう. n<d かつ HCF(n,d)=1 のとき, 真既約分数と呼ぶ.
 *
 * d ≤ 8 について既約分数を大きさ順に並べると, 以下を得る:
 *
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 *
 * 1/3と1/2の間には3つの分数が存在することが分かる.
 *
 * では, d ≤ 12,000 について真既約分数をソートした集合では, 1/3 と 1/2 の間に何個の分数があるか?
 */
object P073 {
  import commons._

  /**
   * 1 &lt; k &le; d, 1 &le; n &lt; k とする。
   *
   * すべてのkについて、1/3 &lt; n/k &lt; 1/2 を満たすnの個数をカウントしてその和をとればよい。
   * ただし、重複は除くので、nとkが互いに素なものをカウントする。
   *
   * あるkについて、チェックするnの範囲を考えると、1/3 &lt; n/k &lt; 1/2 の辺々にkをかけて
   *   k/3 &lt; n &lt; k/2
   * の範囲でチェックすればよい。
   */
  def solve(d: Int): Long = {
    val nums = (1 to (d / 2))
    (2 to d).foldLeft(0) { (z, k) =>
      val min = k.toDouble / 3
      val max = k.toDouble / 2
      z + nums.dropWhile { _ <= min }.takeWhile { _ < max }.count { n => gcd(n, k) == 1 }
    }
  }
}
