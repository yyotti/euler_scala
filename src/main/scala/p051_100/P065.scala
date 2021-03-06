package project_euler

/**
 * Problem 65:
 * The square root of 2 can be written as an infinite continued fraction.
 *
 * √2 = 1 + (1/2 + (1/2 + (1/2 + (1/2 + ...
 *
 * The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates that 2 repeats ad infinitum.
 * In a similar way, √23 = [4;(1,3,1,8)].
 *
 * It turns out that the sequence of partial values of continued fractions for square roots provide the best rational approximations.
 * Let us consider the convergents for √2.
 *
 * 1 + 1/2 = 3/2
 *
 * 1 + 1/(2 + 1/2) = 7/5
 *
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12
 *
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29
 *
 * Hence the sequence of the first ten convergents for √2 are:
 *
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 *
 * What is most surprising is that the important mathematical constant,
 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
 *
 * The first ten terms in the sequence of convergents for e are:
 *
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 *
 * The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
 *
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 *
 * 問題 65:
 * 2の平方根は無限連分数として書くことができる.
 *
 * √2 = 1 + (1/2 + (1/2 + (1/2 + (1/2 + ...
 *
 * 無限連分数である √2 = [1;(2)] と書くことができるが, (2) は2が無限に繰り返されることを示す. 同様に, √23 = [4;(1,3,1,8)].
 *
 * 平方根の部分的な連分数の数列から良い有理近似が得られることが分かる.√2の近似分数について考えよう.
 *
 * 1 + 1/2 = 3/2
 *
 * 1 + 1/(2 + 1/2) = 7/5
 *
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12
 *
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29
 *
 * 従って, √2の近似分数からなる数列の最初の10項は：
 *
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 *
 * もっとも驚くべきことに, 数学的に重要な定数,
 *
 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
 *
 * e の近似分数からなる数列の最初の10項は：
 *
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 *
 * 10項目の近似分数の分子の桁を合計すると1+4+5+7=17である.
 *
 * e についての連分数である近似分数の100項目の分子の桁の合計を求めよ.
 */
object P065 {
  import commons._
  import scala.language.implicitConversions

  implicit def Int2Fraction(i: Int) = Fraction(i, 1)
  implicit def BigInt2Fraction(i: BigInt) = Fraction(i, 1)

  case class Fraction(n: BigInt, d: BigInt) {
    lazy val lowestTerm = {
      val k = gcd(n, d)
      Fraction(n / k, d / k)
    }

    def +(that: Fraction): Fraction = {
      val k = lcm(d, that.d)
      val m = n * k / d + that.n * k / that.d

      Fraction(m, k).lowestTerm
    }

    def *(that: Fraction): Fraction = {
      Fraction(n * that.n, d * that.d).lowestTerm
    }

    def ~ : Fraction = Fraction(d, n)
  }
  object Fraction {
    def apply(n: Fraction, f: Fraction): Fraction = n * f.~
  }

  val seq = from(1).flatMap { i => Seq(1, 2 * i, 1) }

  def efrac(n: Int): Fraction = {
    def e(n: Int, i: BigInt, seq: Stream[Long]): Fraction = n match {
      case 1 => i
      case _ => i + e(n - 1, seq.head, seq.tail).~
    }

    n match {
      case 1 => 2
      case _ => 2 + e(n - 1, seq.head, seq.tail).~
    }
  }

  def solve(n: Int): Long = digits(efrac(n).n).sum.toLong
}
