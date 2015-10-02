package project_euler

/**
 * Problem 80:
 * It is well known that if the square root of a natural number is not an integer, then it is irrational.
 * The decimal expansion of such square roots is infinite without any repeating pattern at all.
 *
 * The square root of two is 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.
 *
 * For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal digits for all the irrational square roots.
 *
 * 問題 80:
 * よく知られているように, 自然数の平方根が整数ではないならば, それは無理数である.
 *
 * そのような平方根の10進展開(decimal expansion)は繰り返しを持たない無限小数になる.
 *
 * 2の平方根は, 1.41421356237309504880...,であり, その頭から100桁の数字を合計すると475になる.
 *
 * 初めの100個の自然数の平方根のうち, 無理数について, それぞれの頭から100桁の数字を足した数の総和を求めよ.
 */
object P080 {
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

  def continuedFractions(n: Int): Option[(Int, List[Int])] = {
    def continuedPart(k: Int, l: Int, cache: Set[(Int, Int)]): List[Int] = {
      if (cache.contains((k, l))) Nil
      else {
        val g = gcd(n - k * k, l).toInt
        val d = (n - k * k) / g
        val x = from(d, d).map { i => (k - i).abs.toInt }.find { i => math.pow(i, 2) > n }.get - d
        val y = (x + k) / d

        y :: continuedPart(x, d, cache + ((k, l)))
      }
    }

    from(1).find { k => k * k >= n }.flatMap { k => if (k * k == n) None else Some(k.toInt - 1) } match {
      case Some(a0) => Some((a0, continuedPart(a0, 1, Set[(Int, Int)]())))
      case _ => None
    }
  }

  def div(n: BigInt, d: BigInt, count: Int): List[Int] = (n, d, count) match {
    case (_, _, 0) => Nil
    case (n, d, _) if n % d == 0 => (n / d).toInt :: Nil
    case _ => (n / d).toInt :: div((n % d) * 10, d, count - 1)
  }

  def appr(a0: Int, part: List[Int], count: Int): List[Int] = {
    val as = from(0).flatMap { _ => part }

    def toFraction(nums: List[Int]): Fraction = nums match {
      case Nil => 0
      case x :: xs => Fraction(1, x + toFraction(xs))
    }

    from(1)
      .map { k => val f = a0 + toFraction(as.take(k.toInt).toList); div(f.n, f.d, count) }
      .sliding(2)
      .find { ls => ls(0) == ls(1) }
      .map { _(0) }
      .get
  }

  /**
   * P064より、自然数Nの整数にならない平方根は、連分数で表現できる。
   *   √N = a0 + (1/a1 + (1/a2 + (1/a3 + ...)
   * a1,a2,... はいつか循環するので、簡易表記として
   *   √N = [a0;(a1,a2,...,ak)]
   * √2を簡易表記すると
   *   √2=[1;(2)]
   * のようになる。
   *
   * √Nを小数表記するためには、√N ≒ m/n となる自然数(m,n)の組を見つけ、
   * m/nを小数表記すればよい。ただし、今回は√Nの先頭から100桁までをとらなければ
   * ならないので、最低でも先頭100桁が√Nと一致する(m,n)の組を探す必要がある。
   *
   * そこで、√Nの連分数の簡易表記を取得し、循環部分を1桁ずつ増やしながら(m,n)の組
   * を見つけ、小数表記する。kを自然数として、この数列を
   *   r(k) = a0 + (1/a1 + (1/a2 + ... + 1/ak)
   * とすると、r(k) - r(k - 1) &le; 10^(-100) を満たすkを見つけられれば、
   * √Nと先頭100桁が一致する近似値を求められる。
   */
  def solve(n: Int): Long =
    (1 to n)
      .flatMap { i => continuedFractions(i) }
      .map { case (a0, part) => appr(a0, part, 100).sum }
      .sum
}
