package project_euler

/**
 * Problem 35:
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 *
 * 問題 35:
 * 197は巡回素数と呼ばれる. 桁を回転させたときに得られる数 197, 971, 719 が全て素数だからである.
 *
 * 100未満には巡回素数が13個ある: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, および97である.
 *
 * 100万未満の巡回素数はいくつあるか?
 */
object P035 {
  import commons._

  /**
   * n が巡回素数であるためには、下記の全てを満たさなければならない。
   * 1. n が素数であること
   * 2. 桁を回転させたときに得られる数が素数であること
   *
   * 2の条件を満たすためには、全ての桁の数字が5以外の奇数でなければならない。
   * ※偶数を含むと桁を回転させたらいつか偶数になり、5を含むといつか5の倍数になる。
   */
  def solve(n: Int): Int =
    primes
      .takeWhile { _ < n }
      .filter { p =>
        (p < 10 || !digits(p).exists { k => k % 2 == 0 || k == 5 }) &&
        circulars(p).forall { isPrime }
      }
      .size

  def circulars(n: Long): List[Long] =
    (0 to (digitCount(n) - 1)).map { i => val ds = digits(n); ds.drop(i) ++: ds.take(i) }.map { _.mkString.toLong }.toList
}
