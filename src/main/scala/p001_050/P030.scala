package project_euler

/**
 * Problem 30:
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 *
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 * 問題 30:
 * 驚くべきことに, 各桁を4乗した数の和が元の数と一致する数は3つしかない.
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 *
 * ただし, 1=1^4は含まないものとする. この数たちの和は 1634 + 8208 + 9474 = 19316 である.
 *
 * 各桁を5乗した数の和が元の数と一致するような数の総和を求めよ.
 */
object P030 {
  import commons._

  def findMaxDigits(n: Int) =
    from(1).takeWhile { k => digitCount((BigInt(9).pow(n) * k)) >= k }.last.toInt

  /*
   * aをk桁の数とすると、
   *   a = a(k - 1)*10^(k - 1) + a(k - 2)*10^(k - 2) + ... + a1*10 + a0
   * と表せる。ただし a(i) は 0 &le; a(i) &le; 9 の整数とし、0 &le; i &lt; k である。
   *
   * aの各桁をn乗した数の和をS(a)とすると、
   *   S(a) = a(k - 1)^n + a(k - 2)^n + ... + a1^n + a0^n
   * となるが、 0 &le; a(i) &le; 9 であることから、S(a)の最大値は
   *   max(S(a)) = 9^n + 9^n + ... + 9^n + 9^n
   *             = k*9^n
   * である。max(S(a))の桁数をmとすれば、m &lt; n である場合は「各桁のn乗の和が元の
   * 数と一致する」ことは有り得ない。
   *
   * また、1桁の数の場合、2乗して元の数と一致するのは1しかないが、1は除外するので
   * 2桁以上の数でチェックすればよい。
   */
  def solve(n: Int): Long =
    (2L to (BigInt(10).pow(findMaxDigits(n)) - 1).toLong).filter { k =>
      digits(k).map { i => BigInt(i).pow(n) }.sum == k
    }.sum
}
