package project_euler

/**
 * Problem 77:
 * It is possible to write ten as the sum of primes in exactly five different ways:
 *
 * 7 + 3
 * 5 + 5
 * 5 + 3 + 2
 * 3 + 3 + 2 + 2
 * 2 + 2 + 2 + 2 + 2
 *
 * What is the first value which can be written as the sum of primes in over five thousand different ways?
 *
 * 問題 77:
 * 10は素数の和として5通りに表すことができる:
 *
 * 7 + 3
 * 5 + 5
 * 5 + 3 + 2
 * 3 + 3 + 2 + 2
 * 2 + 2 + 2 + 2 + 2
 *
 * 素数の和としての表し方が5000通り以上になる最初の数を求めよ.
 */
object P077 {
  import commons._

  def pi(n: Long, nums: List[Long]): Long = (n, nums) match {
    case (0, _) => 1
    case (_, Nil) => 0
    case (_, x :: xs) if (n < x) => pi(n, xs)
    case (_, x :: xs) => pi(n - x, nums) + pi(n, xs)
  }

  /**
   * 基本的にはP076と同じで、表し方を順に計算していって最初に5000を超える数を返せばよい。
   */
  def solve(n: Int): Long =
    from(2).find { i => pi(i, primes.takeWhile { _ < i }.toList.reverse) >= n }.get
}
