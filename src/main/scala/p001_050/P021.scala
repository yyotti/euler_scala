package project_euler

/**
 * Problem 21:
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * 問題 21:
 * d(n) を n の真の約数の和と定義する. (真の約数とは n 以外の約数のことである. )
 * もし, d(a) = b かつ d(b) = a (a ≠ b のとき) を満たすとき, a と b は友愛数(親和数)であるという.
 *
 * 例えば, 220 の約数は 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 なので d(220) = 284 である.
 * また, 284 の約数は 1, 2, 4, 71, 142 なので d(284) = 220 である.
 *
 * それでは10000未満の友愛数の和を求めよ.
 */
object P021 {
  import commons._

  def solve(n: Int): Long =
    (2 until n).filter { k => val d1 = sumProperDivisors(k); d1 != k && sumProperDivisors(d1) == k }.sum

}
