package project_euler

/**
 * Problem 28:
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 *
 * 問題 28:
 * 1から初めて右方向に進み時計回りに数字を増やしていき, 5×5の螺旋が以下のように生成される:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * 両対角線上の数字の合計は101であることが確かめられる.
 *
 * 1001×1001の螺旋を同じ方法で生成したとき, 対角線上の数字の和はいくつか?
 */
object P028 {
  def t(n: Int) =
    if (n == 1) 0
    else 4 * n * n - 6 * n + 6

  /*
   * nを1以上の奇数とする。
   * 問題に沿って n x n の螺旋を生成すると、中心には必ず1が配置される。
   *
   * 対角線上の数字の合計をS(n)とすると、
   *   S(1) = 1
   * は自明である。
   *
   * n &ge; 3 の場合は、S(n - 1) に最も外側の四角形の頂点の数字の和を
   * 加えればよい。その和を T(n) とすると、
   *   S(n) = S(n - 2) + T(n)
   * である。
   *
   * 最も外側の頂点の右上は n^2 、左上は n^2 - (n - 1)、左下は n^2 - 2(n - 1)、
   * 右下は n^2 - 3(n - 1) であるから、
   *   T(n) = n^2 + n^2 - (n - 1) + n^2 - 2(n - 1) + n^2 - 3(n - 1)
   *        = 4n^2 - 6(n - 1)
   *        = 4n^2 - 6n + 6
   * である。ただし、T(1) = 0 とする。
   */
  def solve(n: Int): Long =
    if (n == 1) 1
    else solve(n - 2) + t(n)
}
