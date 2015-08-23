package project_euler

/**
 * Problem 14:
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * 問題 14:
 * 正の整数に以下の式で繰り返し生成する数列を定義する.
 *
 * n → n/2 (n が偶数)
 *
 * n → 3n + 1 (n が奇数)
 *
 * 13からはじめるとこの数列は以下のようになる.
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * 13から1まで10個の項になる. この数列はどのような数字からはじめても最終的には 1 になると考えられているが, まだそのことは証明されていない(コラッツ問題)
 *
 * さて, 100万未満の数字の中でどの数字からはじめれば最長の数列を生成するか.
 *
 * 注意: 数列の途中で100万以上になってもよい
 */
object P014 {
  def solve(n: Int): Long = ???
}
