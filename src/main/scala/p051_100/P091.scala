package project_euler

/**
 * Problem 91:
 * The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and are joined to the origin, O(0,0), to form ΔOPQ.
 *
 * (図は省略)
 *
 * There are exactly fourteen triangles containing a right angle that can be formed when each co-ordinate lies between 0 and 2 inclusive; that is,
 * 0 ≤ x1, y1, x2, y2 ≤ 2.
 *
 * (図は省略)
 *
 * Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?
 *
 * 問題 91:
 * 点P(x1, y1)と点Q(x2, y2)はともに整数係数の点であり, 原点O(0,0)と合わせてΔOPQをなす.
 *
 * (図は省略)
 *
 * 各係数が0と2の間にあるとき, すなわち0 ≤ x1, y1, x2, y2 ≤ 2のとき, 直角三角形は14個できる:
 *
 * (図は省略)
 *
 * では, 0 ≤ x1, y1, x2, y2 ≤ 50のとき, 直角三角形は何個作れるか?
 */
object P091 {

  def isRightTriangle(p: (Int, Int), q: (Int, Int)) = {
    if (p == q) false
    else if (p == (0, 0) || q == (0, 0)) false
    else {
      val (x1, y1) = p
      val (x2, y2) = q
      val (x3, y3) = (x2 - x1, y2 - y1)
      (x1 * x2 + y1 * y2 == 0) || (x1 * x3 + y1 * y3 == 0) || (x2 * x3 + y2 * y3 == 0)
    }
  }

  /**
   * PとQの位置が入れ替わっても同じ三角形になるので、図のような位置関係を保つなら
   *   x1 &le; x2
   *   y1 &ge; y2
   * としてよい。
   * また、O,P,Qのいずれかが重なると三角形にならない。
   *
   * △OPQが直角三角形であるか否かは、OP, OQ, PQをそれぞれベクトルと捉えると、内積が0となる
   * 組み合わせが存在するか否かである。
   *   OP = (x1, y1)
   *   OQ = (x2, y2)
   *   PQ = OQ - OP = (x2 - x1, y2 - y1)
   * であるから、それぞれの内積は
   *   OP・OQ = x1*x2 + y1*y2
   *   OP・PQ = x1*(x2 - x1) + y1*(y2 - y1)
   *   OQ・PQ = x2*(x2 - x1) + y2*(y2 - y1)
   * で求められるので、このいずれかが0となるものをカウントすればよい。
   */
  def solve(n: Int): Long = {
    (0 to n).flatMap { x2 =>
      (0 to x2).flatMap { x1 =>
        (0 to n).flatMap { y1 =>
          (0 to y1).map { y2 =>
            isRightTriangle((x1, y1), (x2, y2))
          }
        }
      }
    }.count { _ == true }
  }
}
