package project_euler

/**
 * Problem 41:
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 *
 * 問題 41:
 * n桁パンデジタルであるとは, 1からnまでの数を各桁に1つずつ持つこととする.
 * 例えば2143は4桁パンデジタル数であり, かつ素数である.
 *
 * n桁パンデジタルな素数の中で最大の数を答えよ.
 */
object P041 {
  import commons._

  /**
   * 1 <= n <= 9 で考える。
   *
   * まず各nについて、条件を満たす数（n桁パンデジタルな素数）があるかを考える。
   * 1からnまでの総和をS(n)とすると、
   *   S(1) = 1
   *   S(2) = 3
   *   S(3) = 6
   *   S(4) = 10
   *   S(5) = 15
   *   S(6) = 21
   *   S(7) = 28
   *   S(8) = 36
   *   S(9) = 45
   * である。n桁パンデジタル数は1からnまでの数字が1度ずつ使われているn桁の
   * 数であるから、n桁パンデジタル数の各桁の数字の総和はS(n)である。
   * 各桁の数字の総和が3で割り切れる場合、その数自身も3で割り切れるという
   * 性質があるため、S(n)が3の倍数になっているnについては考えなくてよい。
   * よって、対象となるnは
   *   n = 1, 4, 7
   * のみである。
   */
  def solve: Long =
    primes
      .map { p => (p, digitCount(p)) }
      .takeWhile { case (_, d) => d <= 7 }
      .filter { case (p, d) => isNDigitsPandigital(p) && (d == 1 || d == 4 || d == 7) }
      .maxBy { _._1 }
      ._1

  def isNDigitsPandigital(n: Long): Boolean = n.toString.sorted == (1 to digitCount(n)).mkString
}
