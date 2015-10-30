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
  import commons._

  def countAnswers(n: Int): Int =
    primeFactorsCount(n.toLong * n).map { case (_, e) => e + 1 }.product / 2 + 1

  /**
   * 対称性から x &le; y としてよい。
   * x = y の場合、
   *   1/x + 1/x = 2/x = 1/n
   * であるから
   *   x = 2n
   * で、これがxのとりうる最大値である。
   * x &le; nの場合、1/x &gt; 1/n となるので、 x &gt; n でなければならない。
   * よってxの範囲は
   *   n &lt; x &le; 2n
   * である。
   * 同じことがyにも言えるので、
   *   n &lt; x &le; y &le; 2n
   * となる。
   *
   * x,y &gt; n であることから、s,tを自然数として
   *   x = n + s, y = n + t
   * と書ける。このとき
   *   1/x + 1/y = 1/n
   *   1/(n + s) + 1/(n + t) = 1/n
   *   (n + s + n + t)/((n + s)(n + t)) = 1/n
   *   n(2n + s + t) = (n + s)(n + t)
   *   2n^2 + (s + t)n = n^2 + (s + t)n + st
   *   n^2 = st
   * であるから、これを満たす(s, t)の組の数をカウントすればよい。
   * これは、n^2 の約数の個数に他ならない。
   * ただし、x &le; y であるから s &le; t なので、s &le; √(n^2) = n まで
   * をカウントする。
   */
  def solve(n: Int): Long = {
    def loop(k: Int): Int =
      if (countAnswers(k) > n) k
      else loop(k + 1)

    loop(1)
  }
}
