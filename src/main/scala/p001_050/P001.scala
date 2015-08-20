package project_euler

/**
 * Problem 1:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * 問題 1:
 * 10未満の自然数のうち, 3 もしくは 5 の倍数になっているものは 3, 5, 6, 9 の4つがあり, これらの合計は 23 になる.
 *
 * 同じようにして, 1000 未満の 3 か 5 の倍数になっている数字の合計を求めよ.
 */
object P001 {
  def solve(n: Int): Long =
    (1 until n).filter { k => k % 3 == 0 || k % 5 == 0 }.sum
}
