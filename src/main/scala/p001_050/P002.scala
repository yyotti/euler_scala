package project_euler

/**
 * Problem 2:
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 *
 * 問題 2:
 * フィボナッチ数列の項は前の2つの項の和である. 最初の2項を 1, 2 とすれば, 最初の10項は以下の通りである.
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * 数列の項の値が400万以下の, 偶数値の項の総和を求めよ.
 */
object P002 {
  def fib(a1: Int, a2: Int, max: Int): List[Int] =
    if (a1 > max) Nil
    else a1 :: fib(a2, a1 + a2, max)

  def solve(n: Int): Long = fib(1, 2, n).takeWhile { _ <= n }.filter { _ % 2 == 0 }.sum
}
