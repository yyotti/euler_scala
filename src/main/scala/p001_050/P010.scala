package project_euler

/**
 * Problem 10:
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * 問題 10:
 * 10以下の素数の和は 2 + 3 + 5 + 7 = 17 である.
 *
 * 200万以下の全ての素数の和を求めよ.
 */
object P010 {
  def sieve(nums: List[Int]): List[Int] = {
    def loop(ls: List[Int], max: Int, result: List[Int]): List[Int] = ls match {
      case Nil => result
      case x :: _ if x > max => result.reverse ::: ls
      case x :: xs => loop(xs.filter { _ % x != 0 }, max, x :: result)
    }

    nums match {
      case Nil => Nil
      case _ => loop(nums, math.sqrt(nums.last).toInt, Nil)
    }
  }

  /**
   * 素数の上限が明確なので、列挙するよりエラトステネスの篩にかける方が速い。
   */
  def solve(max: Int): Long =
    (2 :: sieve(List.range(3, max + 1, 2))).map { _.toLong }.sum
}
