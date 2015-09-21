package project_euler

/**
 * Problem 64:
 * All square roots are periodic when written as continued fractions and can be written in the form:
 *
 * √N = a0 + (1/a1 + (1/a2 + (1/a3 + ...)
 *
 * For example, let us consider √23:
 *
 * √23 = 4 + √23 - 4 = 4 + (1/1/(√23 - 4)) = 4 + (1/(1 + (√23 - 3)/7))
 *
 * If we continue we would get the following expansion:
 *
 * √23 = 4 + (1/(1 + (1/(3 + (1/(1 + (1/(8 + ... )
 *
 * The process can be summarised as follows:
 *
 * a0 = 4, 1/(√23 - 4) = (√23 + 4)/7 = 1 + (√23 - 3)/7
 * a1 = 1, 7/(√23 - 3) = 7(√23 + 3)/14 = 3 + (√23 - 3)/2
 * a2 = 3, 2/(√23 - 3) = 2(√23 + 3)/14 = 1 + (√23 - 4)/7
 * a3 = 1, 7/(√23 - 4) = 7(√23 + 4)/7 = 8 + √23 - 4
 * a4 = 8, 1/(√23 - 4) = (√23 + 4)/7 = 1 + (√23 - 3)/7
 * a5 = 1, 7/(√23 - 3) = 7(√23 + 3)/14 = 3 + (√23 - 3)/2
 * a6 = 3, 2/(√23 - 3) = 2(√23 + 3)/14 = 1 + (√23 - 4)/7
 * a7 = 1, 7/(√23 - 4) = 7(√23 + 4)/7 = 8 + √23 - 4
 *
 * It can be seen that the sequence is repeating. For conciseness, we use the notation √23 = [4;(1,3,1,8)], to indicate that the block (1,3,1,8) repeats indefinitely.
 *
 * The first ten continued fraction representations of (irrational) square roots are:
 *
 * √2=[1;(2)], period=1
 * √3=[1;(1,2)], period=2
 * √5=[2;(4)], period=1
 * √6=[2;(2,4)], period=2
 * √7=[2;(1,1,1,4)], period=4
 * √8=[2;(1,4)], period=2
 * √10=[3;(6)], period=1
 * √11=[3;(3,6)], period=2
 * √12= [3;(2,6)], period=2
 * √13=[3;(1,1,1,1,6)], period=5
 *
 * Exactly four continued fractions, for N ≤ 13, have an odd period.
 *
 * How many continued fractions for N ≤ 10000 have an odd period?
 *
 * 問題 64:
 * 平方根は連分数の形で表したときに周期的であり, 以下の形で書ける:
 *
 * √N = a0 + 1 / (a1 + 1 / (a2 + 1 / (a3 + ...)))
 *
 * 例えば, √23を考えよう.
 *
 * √23 = 4 + √23 - 4 = 4 + 1 / (1 / (√23 - 4)) = 4 + 1 / (1 + (√23 - 3) / 7)
 *
 * となる.
 *
 * この操作を続けていくと,
 *
 * √23 = 4 + 1 / (1 + 1 / (3 + 1 / (1 + 1 / (8 + ...))))
 *
 * を得る.
 *
 * 操作を纏めると以下になる:
 *
 * a0 = 4, 1/(√23-4) = (√23+4)/7 = 1 + (√23-3)/7
 * a1 = 1, 7/(√23-3) = 7(√23+3)/14 = 3 + (√23-3)/2
 * a2 = 3, 2/(√23-3) = 2(√23+3)/14 = 1 + (√23-4)/7
 * a3 = 1, 7/(√23-4) = 7(√23+4)/7 = 8 + (√23-4)
 * a4 = 8, 1/(√23-4) = (√23+4)/7 = 1 + (√23-3)/7
 * a5 = 1, 7/(√23-3) = 7(√23+3)/14 = 3 + (√23-3)/2
 * a6 = 3, 2/(√23-3) = 2(√23+3)/14 = 1 + (√23-4)/7
 * a7 = 1, 7/(√23-4) = 7(√23+4)/7 = 8 + (√23-4)
*
 * よって, この操作は繰り返しになることが分かる. 表記を簡潔にするために, √23 = [4;(1,3,1,8)]と表す. (1,3,1,8)のブロックは無限に繰り返される項を表している.
 *
 * 最初の10個の無理数である平方根を連分数で表すと以下になる.
 *
 * √2=[1;(2)], period=1
 * √3=[1;(1,2)], period=2
 * √5=[2;(4)], period=1
 * √6=[2;(2,4)], period=2
 * √7=[2;(1,1,1,4)], period=4
 * √8=[2;(1,4)], period=2
 * √10=[3;(6)], period=1
 * √11=[3;(3,6)], period=2
 * √12= [3;(2,6)], period=2
 * √13=[3;(1,1,1,1,6)], period=5
 * N ≤ 13で奇数の周期をもつ平方根は丁度4つある.
 *
 * N ≤ 10000 について奇数の周期をもつ平方根が何個あるか答えよ.
 */
object P064 {
  import commons._

  def continuedFractions(n: Int): Option[(Int, List[Int])] = {
    def continuedPart(k: Int, l: Int, cache: Set[(Int, Int)]): List[Int] = {
      if (cache.contains((k, l))) Nil
      else {
        val g = gcd(n - k * k, l).toInt
        val d = (n - k * k) / g
        val x = from(d, d).map { i => (k - i).abs.toInt }.find { i => math.pow(i, 2) > n }.get - d
        val y = (x + k) / d

        y :: continuedPart(x, d, cache + ((k, l)))
      }
    }

    from(1).find { k => k * k >= n }.flatMap { k => if (k * k == n) None else Some(k.toInt - 1) } match {
      case Some(a0) => Some((a0, continuedPart(a0, 1, Set[(Int, Int)]())))
      case _ => None
    }
  }

  /**
   * nを2以上の自然数とする。
   *   √n = a0 + 1 / (a1 + 1 / (a2 + 1 / (a3 + ...)))
   * であり、省略形は
   *   √n = [a0; (a1, a2, ... , ai)]  (iは0以上の整数)
   * であるから、まずa0を考える。
   *
   * √n = a0 + √n - a0 の形に変形することが目的である。このとき、次のa1の計算を行う際に、
   * 1/(√n - a0) = (√n + a0)/(n - (a0)^2) の形の変形を行うので、
   *   (a0)^2がnを超えない最大のa0
   * を求める。
   *
   * 次にa1,a2,...,aiを求めるために、下記の漸化式を考える。
   *   li/(√n - ki) = aj + (√n - lj)/dj   (j = i + 1)
   * ただし、l0 = 1, k0 = a0 である。
   * まず左辺を
   *   li(√n + ki)/(n - (ki)^2)
   * と変形する。このとき、liと(n - (ki)^2)の最大公約数はliになるので、(n - (ki)^2)/li = d とおくと
   *   li/(√n - ki) = li(√n + ki)/(n - (ki)^2) = (√n + k)/d
   * となる。
   * さらにここから
   *   (√n + k)/d = aj + (√n - lj)/dj
   * の変形を行う。右辺を通分して整理すると
   *   (√n + k)/d = (√n + aj*dj - lj)/dj
   * となるので、
   *   dj = d、aj*dj - lj = k
   * となるように、aj と lj を求めてやればよい。ただし、ljは
   *   (lj)^2がnを超えない最大のlj
   * とする。
   *
   * dj, lj が求まったら、漸化式で di = dj, li = lj として次の ai を求める。
   * 処理過程で出現した(dj, lj)の組を記憶しておき、同じ組が出現したらそこまでを
   * 周期とする。
   */
  def solve(n: Int): Long =
    from(2)
      .takeWhile { _ <= n }
      .map { i => continuedFractions(i.toInt) }
      .count {
        case Some((_, ls)) => ls.size % 2 == 1
        case None => false
      }
}
