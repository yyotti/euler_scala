package project_euler

/**
 * Problem 76:
 * It is possible to write five as a sum in exactly six different ways:
 *
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 *
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 *
 * 問題 76:
 * 5は数の和として6通りに書くことができる:
 *
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 *
 * 2つ以上の正整数の和としての100の表し方は何通りか.
 */
object P076 {
  import commons._

  def pi(n: Int, nums: List[Int]): Long = (n, nums) match {
    case (0, _) => 1L
    case (_, Nil) => 0L
    case (_, x :: xs) if (n < x) => pi(n, xs)
    case (_, x :: xs) => pi(n - x, nums) + pi(n, xs)
  }

  /**
   * nを自然数として、「nを自然数の和で表す」というのを「1円玉、2円玉、...、
   * (n - 1)円玉を使ってn円を作る」と置き換えれば、過去の問題にあった「2£の作り方」と
   * 同じである。
   * 作り方の総数をπ(n)とすると、
   *   π(n) = [(n - 1)円を必ず使ってn円を作る作り方] + [(n - 2)円以下を使ってn円を作る作り方]
   * で計算できる。
   */
  def solve(n: Int): Long = pi(n, List.range(1, n).reverse)
}
