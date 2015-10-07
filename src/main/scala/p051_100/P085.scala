package project_euler

/**
 * Problem 85:
 * By counting carefully it can be seen that a rectangular grid measuring 3 by 2 contains eighteen rectangles:
 *
 * (図は省略)
 *
 * Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid with the nearest solution.
 *
 * 問題 85:
 * 注意深く数えると, 横が3, 縦が2の長方形の格子には, 18個の長方形が含まれている.
 *
 * (図は省略)
 *
 * ぴったり2,000,000個の長方形を含むような長方形の格子は存在しない. 一番近い解を持つような格子の面積を求めよ.
 */
object P085 {
  import commons._

  val phi = from(2).scanLeft(1L) { (z, i) => z + i }

  def findPhiPair(n: Int) =
    phi
      .takeWhile { _ <= math.sqrt(n) }
      .flatMap { phiX => phi.dropWhile { _ < math.sqrt(n) }.takeWhile { _ <= n }.map { phiY => (phiX, phiY) } }
      .find { case (phiX, phiY) => phiX * phiY == n }

  /**
   * 長方形の横の長さをx、縦の長さをyとする。
   * 対称性があるので、x &ge; y の場合のみで考えればよい。
   *
   * 面積がx*yの長方形に含まれる長方形の個数をπ(x, y)とする。
   * いま、x = 1 の場合のπ(x, y)を列挙すると
   *   π(1, 1) = 1
   *   π(1, 2) = 3 = π(1, 1) + 2 = 1 + 2
   *   π(1, 3) = 6 = π(1, 2) + 3 = π(1, 1) + 2 + 3 = 1 + 2 + 3
   *   π(1, 4) = 10 = π(1, 3) + 4 = π(1, 2) + 3 + 4 = π(1, 1) + 2 + 3 + 4 = 1 + 2 + 3 + 4
   *   π(1, 5) = 15 = π(1, 4) + 5 = 1 + 2 + 3 + 4 + 5
   *   ・・・
   *   π(1, y) = y(y + 1)/2
   * である。
   *
   * また、同じyの中でxを変化させて列挙すると、
   *   [y = 3の場合]
   *   π(1, 3) = 6 = π(1, 3) * 1
   *   π(2, 3) = 18 = π(1, 3) * 3 = π(1, 3) * (1 + 2)
   *   π(3, 3) = 36 = π(1, 3) * 6 = π(1, 3) * (1 + 2 + 3)
   *
   *   [y = 4の場合]
   *   π(1, 4) = 10 = π(1, 4) * 1
   *   π(2, 4) = 30 = π(1, 4) * (1 + 2)
   *   π(3, 4) = 60 = π(1, 4) * 6 = π(1, 4) * (1 + 2 + 3)
   *   π(4, 4) = 100 = π(1, 4) * 10 = π(1, 4) * (1 + 2 + 3 + 4)
   *
   *   ・・・
   *
   *   [y = kの場合]
   *   π(1, k) = a1 = π(1, k) * 1
   *   π(2, k) = a2 = π(1, k) * 3 = π(1, k) * (1 + 2)
   *   π(3, k) = a3 = π(1, k) * 6 = π(1, k) * (1 + 2 + 3)
   *   π(4, k) = a4 = π(1, k) * 10 = π(1, k) * (1 + 2 + 3 + 4)
   *   ・・・
   *   π(4, i) = ai = π(1, k) * (1 + 2 + ... + i)  (1 &le; i &le; k)
   *                 = π(1, k) * i(i + 1)/2
   *
   * 以上のことから、
   *   φ(n) = n(n + 1)/2
   * として、
   *   π(x, y) = π(1, y) * φ(y)
   *            = φ(x) * φ(y)
   * で求められる。
   *
   * いま、π(x, y)がnに最も近い(x, y)を探すので、
   *   1. φ(x) * φ(y) = n となるφ(x)、φ(y)を探す。
   *   2. 1で見つかればその(x, y)を解とする。
   *   3. nの値を
   *        n + 1, n - 1, n + 2, n - 2, ... , n + d, n - d
   *      と順に変化させつつ、1～2を繰り返す。
   * の手順で求められる。
   */
  def solve(n: Int): Long = {
    val (phiX, phiY) =
      Stream
        .from(0)
        .flatMap { d => Seq(n + d, n - d) }
        .flatMap { k => findPhiPair(k) }
        .head

    (phi.indexOf(phiX) + 1) * (phi.indexOf(phiY) + 1)
  }
}
