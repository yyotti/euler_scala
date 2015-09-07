package project_euler

/**
 * Problem 36:
 * The decimal number, 585 = 1001001001[2] (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 *
 * 問題 36:
 * 585 = 1001001001[2] (2進) は10進でも2進でも回文数である.
 *
 * 100万未満で10進でも2進でも回文数になるような数の総和を求めよ.
 *
 * (注: 先頭に0を含めて回文にすることは許されない.)
 */
object P036 {
  import commons._

  /**
   * 先頭に0を含めて回文にしてはいけないので、先頭は必ず1である。(0[10]を除く)
   * それが回文数である場合、最下桁も必ず1になるので、奇数について調べればよい。
   * また、0は回文数であるが総和には影響を与えないので、無視してよい。
   */
  def solve(n: Int): Long =
    (1 to n by 2).filter { n => isPalindromeNumber(n) && isPalindromeNumber(BigInt(BigInt(n).toString(2))) }.sum
}
