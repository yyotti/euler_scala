package project_euler

/**
 * Problem 27:
 * Euler discovered the remarkable quadratic formula:
 *
 * n^2 + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n = 40, 40^2 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly divisible by 41.
 *
 * The incredible formula  n^2 − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n^2 + an + b, where |a| &lt; 1000 and |b| &lt; 1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n = 0.
 *
 * 問題 27:
 * オイラーは以下の二次式を考案している:
 *
 * n^2 + n + 41.
 * この式は, n を0から39までの連続する整数としたときに40個の素数を生成する. しかし, n = 40 のとき 40^2 + 40 + 41 = 40(40 + 1) + 41 となり41で割り切れる. また, n = 41 のときは 41^2 + 41 + 41 であり明らかに41で割り切れる.
 *
 * 計算機を用いて, 二次式 n^2 - 79n + 1601 という式が発見できた. これは n = 0 から 79 の連続する整数で80個の素数を生成する. 係数の積は, -79 × 1601 で -126479である.
 *
 * さて, |a| &lt; 1000, |b| &lt; 1000 として以下の二次式を考える (ここで |a| は絶対値): 例えば |11| = 11 |-4| = 4である.
 *
 * n^2 + an + b
 *
 * n = 0 から始めて連続する整数で素数を生成したときに最長の長さとなる上の二次式の, 係数 a, b の積を答えよ.
 */
object P027 {
  import commons._

  def func(a: Int, b: Int)(n: Long) = n * n + a * n + b

  /*
   * f(n) = n^2 + an + b とする。
   *
   * n = 0で素数にならなければ意味がないので、 f(0) = b は素数でなければならない。
   *
   * また、f(n) = n(n + a) + b であるから、
   *   n = b
   * もしくは
   *   n = b - a
   * のどちらかで、必ず f(n) は素数ではなくなる。
   *   a &ge; 0 の場合、 b &ge; b - a
   *   a &lt; 0 の場合、 b &lt; b - a
   * であるから、nの最大値をより大きくできる可能性があるのは a &lt; 0 の場合で
   * ある。
   */
  def solve(max: Int): Long =
    (-(max - 1) to 0).flatMap { a =>
        primes.takeWhile { _ < max}.map { b => (a, b.toInt, a * b) }
    }.maxBy { case (a, b, ab) =>
      val f = func(a, b)(_)
      from(0).takeWhile { n => isPrime(f(n)) }.size
    }._3
}
