package project_euler

/**
 * Problem 16:
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * 問題 16:
 * 2^15 = 32768 であり, これの数字和 ( 各桁の和 ) は 3 + 2 + 7 + 6 + 8 = 26 となる.
 *
 * 同様にして, 2^1000 の数字和を求めよ.
 */
object P016 {
  def pow(n: Int) =
    if (n <= 0) 1
    else BigInt("1".padTo(n + 1, '0'), 2)

  def solve(n: Int): Long = pow(n).toString.map { _.toString.toInt }.sum
}
