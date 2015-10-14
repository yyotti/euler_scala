package project_euler

/**
 * Problem 94:
 * It is easily proved that no equilateral triangle exists with integral length sides and integral area.
 * However, the almost equilateral triangle 5-5-6 has an area of 12 square units.
 *
 * We shall define an almost equilateral triangle to be a triangle for which two sides are equal and the third differs by no more than one unit.
 *
 * Find the sum of the perimeters of all almost equilateral triangles with integral side lengths and area
 * and whose perimeters do not exceed one billion (1,000,000,000).
 *
 * 問題 94:
 * 一辺の長さが整数の正三角形は面積が整数にならないことを示すのは簡単である.
 * しかし, 5-5-6の辺を持つ殆ど正三角形に近い擬正三角形 (almost equilateral triangle) は面積が12で整数である.
 *
 * 以降, 二等辺三角形で, 3つめの辺の長さが他と1つしか違わないもの (5-5-6, 5-5-4等) を, 擬正三角形と呼ぶ.
 *
 * さて, 周囲の長さが1,000,000,000以下の面積が整数になる擬正三角形を考え, その周囲の長さの総和を求めよ.
 */
object P094 {

  val pell = Stream.from(1).scanLeft((2, 1)) { case ((m, n), _) => (2 * m + 3 * n, 2 * n + m) }

  /**
   * 擬正三角形の3頂点をそれぞれA,B,Cとし、辺ABを底辺とする。
   * 条件を満たす擬正三角形は、AC = BC かつ (AB = AC - 1 もしくは AB = AC + 1) である。
   * 頂点CからABに垂線をひき、ABとの交点をHとすると、△ACHは直角三角形となる。また、CHが△ABCの高さに相当する。
   * 擬正三角形の面積Sは
   *   S = AB * CH / 2
   * であり、これが整数になるには下記の2つの条件を満たす必要がある。
   *   1. CHが整数である
   *   2. ABもしくはCHが偶数である
   *
   * 2の条件について考える。
   * AH = AB/2 = x, CH = y, AC = zとすると、△ACHはACを斜辺とする直角三角形なので、
   *   x^2 + y^2 = z^2
   * が成立する。(x, y, z)は整数の組なので、ピタゴラス数であればよい。
   * よって、自然数m,nについて、m &gt; n、GCD(m, n) = 1, (m - n)が奇数とすると、
   *   (x, y, z) = (m^2 - n^2, 2mn, m^2 + n^2) or (2mn, m^2 - n^2, m^2 + n^2)
   * が成立する。
   * 擬正三角形の条件から
   *   z = 2x ± 1
   * であるから、これに上式を代入する。
   *   i) (x, y, z) = (m^2 - n^2, 2mn, m^2 + n^2) の場合
   *       m^2 + n^2 = 2(m^2 - n^2) ± 1
   *       m^2 - 3n^2 = ±1
   *     これはペル方程式である。
   *   ii) (x, y, z) = (2mn, m^2 - n^2, m^2 + n^2) の場合
   *       m^2 + n^2 = 2(2mn) ± 1
   *       m^2 - 4mn + n^2 = ±1
   *       (m - 2n)^2 - 4n^2 + n^2 = (m - 2n)^2 - 3n^2 = ±1
   *     これもペル方程式である。
   *
   * それぞれの場合において、自明な解以外の解を考える。
   *   i-1) m^2 - 3n^2 = 1
   *     最小解は (m0, n0) = (2, 1)
   *   i-2) m^2 - 3n^2 = -1
   *     移項して m^2 + 1 = 3n^2 であるから、平方剰余の定理から解は存在しない
   *   ii-1) (m - 2n)^2 - 3n^2 = 1
   *     t = m - 2n とすると、最小解は (t, n) = (2, 1)
   *   ii-2) (m - 2n)^2 - 3n^2 = -1
   *     i-2)と同様、解は存在しない
   * 3は平方数ではないため、
   *   i) の場合   (m + √3 n) = (m0 + √3 n0)^k = (2 + √3)^k
   *   ii) の場合  (t + √3 n) = (t0 + √3 n0)^k = (2 + √3)^k
   * となる。
   *
   * 擬正三角形の周囲の長さRは、
   *   i) の場合
   *     R = 2(AC + AB/2) = 2(z + x) = 2(m^2 + n^2 + m^2 - n^2) = 4m^2
   *   ii) の場合
   *     R = 2(AC + AB/2) = 2(z + x) = 2(m^2 + n^2 + 2mn) = 2(m + n)^2 = 2(t + 3n)^2
   * となる。
   *
   */
  def solve(n: Int): Long =
    pell.map { case (m, _) => 4L * m * m }.takeWhile { _ <= n }.sum +
    pell.map { case (m, n) => 2L * (m + 3 * n) * (m + 3 * n) }.takeWhile { _ <= n }.sum

}
