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
  def solve(n: Int): Long = ???
}
