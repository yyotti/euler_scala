package project_euler

/**
 * Problem 34:
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 *
 * 問題 34:
 * 145は面白い数である. 1! + 4! + 5! = 1 + 24 + 120 = 145となる.
 *
 * 各桁の数の階乗の和が自分自身と一致するような数の和を求めよ.
 *
 * 注: 1! = 1 と 2! = 2 は総和に含めてはならない.
 */
object P034 {
  import commons._

  /**
   * 整数 n の桁数を k とする。
   *   n = a(k - 1)*10^(k - 1) + a(k - 2)*10^(k - 2) + ... + a1*10^1 + a0*10^0
   * とすると、n の各桁の数の階乗和Sは
   *   S = a(k - 1)! + a(k - 2)! + ... + a1! + a0!
   * である。
   * 0 <= ax <= 9 であるから、Sの最大値Smaxは
   *   Smax = 9! + 9! + ... + 9! + 9!
   *        = k*9!
   * であり、n = S となる n を探すのだから、n <= Smax を満たす範囲で探せばよい。
   *   9! = 362880
   * であるから、
   *   k*9! = 362880*k
   *
   * k = 7 のとき Smax = 2540160 であるから、n <= 2540160 の範囲で検索する。
   * ただし1と2は除くので、 3 <= n <= 2540160 である。
   */
  def solve: Long =
    Stream
      .from(3)
      .takeWhile { _ <= 2540160 }
      .filter { n => n == digits(n).map { k => (1 to k).product }.sum }
      .sum
}
