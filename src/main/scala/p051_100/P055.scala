package project_euler

/**
 * Problem 55:
 * If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
 *
 * Not all numbers produce palindromes so quickly. For example,
 *
 * 349 + 943 = 1292,
 * 1292 + 2921 = 4213
 * 4213 + 3124 = 7337
 *
 * That is, 349 took three iterations to arrive at a palindrome.
 *
 * Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
 * A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
 * Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number is Lychrel until proven otherwise.
 * In addition you are given that for every number below ten-thousand, it will either (i) become a palindrome in less than fifty iterations,
 * or, (ii) no one, with all the computing power that exists, has managed so far to map it to a palindrome.
 * In fact, 10677 is the first number to be shown to require over fifty iterations before producing a palindrome:
 * 4668731596684224866951378664 (53 iterations, 28-digits).
 *
 * Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
 *
 * How many Lychrel numbers are there below ten-thousand?
 *
 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
 *
 * 問題 55:
 * 47とその反転を足し合わせると, 47 + 74 = 121となり, 回文数になる.
 *
 * 全ての数が素早く回文数になるわけではない. 349を考えよう,
 *
 * 349 + 943 = 1292,
 * 1292 + 2921 = 4213
 * 4213 + 3124 = 7337
 *
 * 349は, 3回の操作を経て回文数になる.
 *
 * まだ証明はされていないが, 196のようないくつかの数字は回文数にならないと考えられている.
 * 反転したものを足すという操作を経ても回文数にならないものをLychrel数と呼ぶ.
 * 先のような数の理論的な性質により, またこの問題の目的のために, Lychrel数で無いと証明されていない数はLychrel数だと仮定する.
 *
 * 更に, 10000未満の数については，常に以下のどちらか一方が成り立つと仮定してよい.
 *
 * 1. 50回未満の操作で回文数になる
 * 2. まだ誰も回文数まで到達していない
 *
 * 実際, 10677が50回以上の操作を必要とする最初の数である: 4668731596684224866951378664 (53回の操作で28桁のこの回文数になる).
 *
 * 驚くべきことに, 回文数かつLychrel数であるものが存在する. 最初の数は4994である.
 *
 * 10000未満のLychrel数の個数を答えよ.
 *
 * 注: 2007/04/24にLychrel数の理論的な性質を強調するために文面が修正された.
 */
object P055 {
  import commons._

  def isLychrelNumber(n: BigInt): Boolean =
    !(1 to 50)
      .toStream
      .scanLeft(n) { case (k, _) => k + BigInt(k.toString.reverse) }
      .tail
      .exists { k => isPalindromeNumber(k) }

  def solve: Long = (1 until 10000).count { n => isLychrelNumber(n) }
}
