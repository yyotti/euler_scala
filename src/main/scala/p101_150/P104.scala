package project_euler

/**
 * Problem 104:
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * F(n) = F(n−1) + F(n−2), where F(1) = 1 and F(2) = 1.
 *
 * It turns out that F(541), which contains 113 digits, is the first Fibonacci number for which the last nine digits are 1-9 pandigital
 * (contain all the digits 1 to 9, but not necessarily in order).
 * And F(2749), which contains 575 digits, is the first Fibonacci number for which the first nine digits are 1-9 pandigital.
 *
 * Given that F(k) is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 pandigital, find k.
 *
 * 問題 104:
 * フィボナッチ数列は再帰的な関係によって定義される:
 *
 * F(n) = F(n−1) + F(n−2)
 *
 * F(541) (113桁)は, 下9桁に1から9までの数字をすべて含む初めてのフィボナッチ数である.
 * そして, F(2749) (575桁)は, 頭から9桁に1から9までの数字をすべて含む初めてのフィボナッチ数である.
 *
 * F(k)が, 頭から9桁と下9桁のどちらも1から9までの数字をすべて含む初めてのフィボナッチ数とするとき, kを求めよ.
 */
object P104 {
  def isPandigital(n: String) = n.sorted == "123456789"

  /**
   * 無限数列を作ってもいいが、1つの項しかいらないのでループでやる。
   */
  def solve: Long = {
    def loop(a: BigInt, b: BigInt, n: Int): Int = {
      val c = a + b
      if (isPandigital((c % 1000000000L).toString) && isPandigital(c.toString.take(9))) n
      else loop(b, c, n + 1)
    }

    loop(1, 1, 3)
  }
}
