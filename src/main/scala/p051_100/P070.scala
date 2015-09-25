package project_euler

/**
 * Problem 70:
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive numbers
 * less than or equal to n which are relatively prime to n.
 * For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 * The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.
 *
 * Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
 *
 * Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
 *
 * 問題 70:
 * オイラーのトーティエント関数 φ(n) (ファイ関数とも呼ばれる) とは, n 未満の正の整数で n と互いに素なものの個数を表す.
 * 例えば, 1, 2, 4, 5, 7, 8 は9未満で9と互いに素であるので, φ(9) = 6 となる.
 * 1 は全ての正の整数と互いに素であるとみなされる. よって φ(1) = 1 である.
 *
 * 面白いことに, φ(87109)=79180 であり, 87109は79180を置換したものとなっている.
 *
 * 1 < n < 10^7 で φ(n) が n を置換したものになっているもののうち, n/φ(n) が最小となる n を求めよ.
 */
object P070 {
  import commons._

  /**
   * n/φ(n)を小さくしたいので、φ(n)をより大きくすればよい。
   * そのためにはnの素因数がより少なくなればよく、nが素数のときが理想だが、
   * nが素数のとき φ(n) = n - 1 なので、φ(n)がnを置換した値にならない。
   * よって、nの素因数が2つの時が理想となる。
   *
   * nの2つの素因数をp1,p2とすると、
   *   φ(p1*p2) = φ(p1)*φ(p2)
   *             = (p1 - 1) * (p2 - 1)
   * p1 * p2 = n であるから、
   *   φ(n) = (p1 - 1) * (p2 - 1)
   * となる。
   */
  def solve: Long = {
    val max = math.pow(10, 7)

    primes
      .takeWhile { _ < max / 2 }
      .flatMap { p1 =>
        primes
          .takeWhile { p2 => p2 < p1 && p1 * p2 < max }
          .reverse
          .find { p2 => (p1 * p2).toString.sorted == ((p1 - 1) * (p2 - 1)).toString.sorted }
          .map { p2 => (p1 * p2, (p1 - 1) * (p2 - 1)) } }
      .minBy { case (n, t) => n.toDouble / t }
      ._1
  }
}
