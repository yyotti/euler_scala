package project_euler

/**
 * Problem 57:
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 *
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 *
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion,
 * 1393/985, is the first example where the number of digits in the numerator exceeds the number of digits in the denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 *
 * 問題 57:
 * 2の平方根は無限に続く連分数で表すことができる.
 *
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * 最初の4回の繰り返しを展開すると以下が得られる.
 *
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * 次の3つの項は99/70, 239/169, 577/408である. 第8項は1393/985である. これは分子の桁数が分母の桁数を超える最初の例である.
 *
 * 最初の1000項を考えたとき, 分子の桁数が分母の桁数を超える項はいくつあるか?
 */
object P057 {
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

  val frac: Stream[Fraction] = 0 #:: Fraction(1, 2) #:: frac.tail.scanLeft(Fraction(2, 5)) { case (f1, _) => Fraction(1, 2 + f1) }

  def solve(n: Int): Long =
    (1 to n)
      .map { n => 1 + frac(n) }
      .count { case Fraction(n, d) => digitCount(n) > digitCount(d) }
}
