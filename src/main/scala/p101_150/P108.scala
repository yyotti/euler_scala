package project_euler

/**
 * Problem 108:
 * In the following equation x, y, and n are positive integers.
 *
 * 1/x + 1/y = 1/n
 *
 * For n = 4 there are exactly three distinct solutions:
 *
 * 1/5 + 1/20 = 1/4
 * 1/6 + 1/12 = 1/4
 * 1/8 + 1/8 = 1/4
 *
 * What is the least value of n for which the number of distinct solutions exceeds one-thousand?
 *
 * NOTE: This problem is an easier version of Problem 110; it is strongly advised that you solve this one first.
 *
 * 問題 108:
 * 次の等式で x, y, n は正の整数である.
 *
 * 1/x + 1/y = 1/n
 *
 * n = 4 では 3 つの異なる解がある.
 *
 * 1/5 + 1/20 = 1/4
 * 1/6 + 1/12 = 1/4
 * 1/8 + 1/8 = 1/4
 *
 * 解の数が 1000 を超える最小の n を求めよ.
 *
 * 注: この問題は Problem 110 の易しいケースである. こちらを先に解く事を強く勧める.
 */
object P108 {

  def countAnswers(n: Int): Int =
    ((n + 1).toLong to 2 * n)
      .withFilter { x => (x * n) % (x - n) == 0 }
      .map { x => (x, (x * n) / (x - n)) }
      .count { case (x, y) => (x * y) % (x + y) == 0 }

  /**
   * 対称性から x &le; y としてよい。
   * x = y の場合、
   *   1/x + 1/x = 2/x = 1/n
   * であるから
   *   x = 2n
   * で、これがxのとりうる最大値である。
   *
   * x &lt; y の場合、
   *   1/x + 1/y = (x + y)/xy = 1/n
   *   xy/(x + y) = n
   * であるから、xyは(x + y)で割り切れなければならない。
   *
   * また、yについて解くと
   *   xy = (x + y)n
   *   (x - n)y = xn
   *   y = xn/(x - n)
   * より、x &gt; n でなければならない。
   *
   * 以上のことから、n &lt; x &le; 2n かつ xy % (x + y) = 0 となる
   * (x, y)の組の数を数えればよい。
   */
  def solve(n: Int): Long = {
    def loop(k: Int): Int =
      if (countAnswers(k) > n) k
      else loop(k + 1)

    loop(1)
  }
}
