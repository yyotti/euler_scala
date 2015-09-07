package project_euler

/**
 * Problem 33:
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
 * which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 *
 * 問題 33:
 * 49/98は面白い分数である.
 * 「分子と分母からそれぞれ9を取り除くと, 49/98 = 4/8 となり, 簡単な形にすることができる」と経験の浅い数学者が誤って思い込んでしまうかもしれないからである.
 * (方法は正しくないが，49/98の場合にはたまたま正しい約分になってしまう．)
 *
 * 我々は 30/50 = 3/5 のようなタイプは自明な例だとする.
 *
 * このような分数のうち, 1より小さく分子・分母がともに2桁の数になるような自明でないものは, 4個ある.
 *
 * その4個の分数の積が約分された形で与えられたとき, 分母の値を答えよ.
 */
object P033 {
  def solve: Long = ???

  def splitDigits(n: Int): List[Int] = n.toString.map { _.toString.toInt }.toList
}
