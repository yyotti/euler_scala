package project_euler

/**
 * Problem 102:
 * Three distinct points are plotted at random on a Cartesian plane, for which -1000 ≤ x, y ≤ 1000, such that a triangle is formed.
 *
 * Consider the following two triangles:
 *
 * A(-340,495), B(-153,-910), C(835,-947)
 * X(-175,41), Y(-421,-714), Z(574,-645)
 *
 * It can be verified that triangle ABC contains the origin, whereas triangle XYZ does not.
 *
 * Using triangles.txt (right click and 'Save Link/Target As...'), a 27K text file containing the co-ordinates of one thousand "random" triangles,
 * find the number of triangles for which the interior contains the origin.
 *
 * NOTE: The first two examples in the file represent the triangles in the example given above.
 *
 * 問題 102:
 * 3つの異なる点が -1000 ≤ x, y ≤ 1000 かつ三角形となるように, デカルト平面上にランダムに与えられる.
 *
 * 以下の2つの三角形を考える.
 *
 * A(-340,495), B(-153,-910), C(835,-947)
 * X(-175,41), Y(-421,-714), Z(574,-645)
 *
 * 三角形ABCが原点を内部に含み, XYZは原点を内部に含まないことが確かめられる.
 *
 * 27Kのテキストファイルtriangles.txt(右クリックしリンク先を保存して欲しい) にランダムな1000個の三角形が適当なフォーマットのもと含まれている.
 * 内部に原点を含む三角形の数を答えよ.
 *
 * 注: ファイル中の最初の二つは三角形ABC, XYZである.
 */
object P102 {
  import commons._

  def isAroundO(a: (Int, Int), b: (Int, Int), c: (Int, Int)) = {
    val ((xa, ya), (xb, yb), (xc, yc)) = (a, b, c)

    val detA = xa * (yb - yc) + xb * (yc - ya) + xc * (ya - yb)
    val s = (xa * (ya - yc) + ya * (xc - xa)).toDouble / detA
    val t = (xa * (yb - ya) + ya * (xa - xb)).toDouble / detA

    s >= 0 && t >= 0 && s + t <= 1
  }

  /**
   * 与えられる3点をA,B,Cとする。また、ベクトルABを :AB: と表記する。
   * 問題にある条件から、:AB:と:AC:は1次独立である。
   *
   * s,tを実数として、:AP: = s:AB: + t:AC: で定まる点Pについて、下記の関係が成立する。
   *   1) s + t = 1 であれば、点Pは直線AB上の点である。
   *   2) s + t = 1 かつ s &ge; 0 かつ t &ge; 0 であれば、点Pは線分AB上の点(両端を含む)である。
   *   3) s + t &le; 1 かつ s &ge; 0 かつ t &ge; 0 であれば、点Pは△ABCの周上または内部の点である。
   *
   * いま、三角形の内部に原点を含むか否かを判定する必要があるため、3)の関係を用いる。
   * A,B,Cの各座標を
   *   A(xa, ya), B(xb, yb), C(xc, yc)
   * とし、原点をOとすれば、
   *   :AO: = (-xa, -ya)
   *   :AB: = (xb - xa, yb - ya)
   *   :AC: = (xc - xa, yc - ya)
   * であるから、
   *   (-xa, -ya) = s(xb - xa, yb - ya) + t(xc - xa, yc - ya)
   *              = (s(xb - xa) + t(xc - xa), s(yb - ya) + t(yc - ya))  (s + t &le; 1 かつ s,t &ge; 0)
   * を満たすs,tが存在すれば、原点Oは△ABCの内部に存在することになる。
   * よって、
   *   -xa = s(xb - xa) + t(xc - xa)
   *   -ya = s(yb - ya) + t(yc - ya)
   * を満たすs,tを探せばよい。
   *
   * 辺々に-1をかけ、右辺と左辺を入れ替えると
   *   s(xa - xb) + t(xa - xc) = xa
   *   s(ya - yb) + t(ya - yc) = ya
   * 係数行列を生成すると
   *   [xa - xb    xa - xc][s] = [xa]
   *   [ya - yb    ya - yc][t]   [ya]
   * これを解くと
   *   [s] = [xa - xb   xa - xc]^-1 [xa]
   *   [t]   [ya - yb   ya - yc]    [ya]
   *       = ((xa - xb)(ya - yc) - (xa - xc)(ya - yb))^(-1)[ya - yc    xc - xa][xa]
   *                                                       [yb - ya    xa - xb][ya]   (※)
   * (※) 表記が非常に分かりづらいが、要するに行列式の逆数をかけつつ左上と右下の要素を逆転し、
   *      右上と左下の要素に-1をかけている
   *
   * |A| = (xa - xb)(ya - yc) - (xa - xc)(ya - yb) とすると、
   *   s = (xa(ya - yc) + ya(xc - xa))/|A|
   *   t = (xa(yb - ya) + ya(xa - xb))/|A|
   *   |A| = (xa*ya - xa*yc - xb*ya + xb*yc) - (xa*ya - xa*yb - xc*ya + xc*yb)
   *       = - xa*yc - xb*ya + xb*yc + xa*yb + xc*ya - xc*yb
   *       = xa(yb - yc) + xb(yc - ya) + xc(ya - yb)
   * である。
   */
  def solve: Long =
    withSource(io.Source.fromFile(new java.io.File("src/main/resources/p102_triangles.txt"))) { src =>
      src
        .getLines
        .count { line =>
          val (a :: b :: c :: _) = line.split(",").map { _.toInt }.grouped(2).map { ls => (ls(0), ls(1)) }.toList
          isAroundO(a, b, c)
        }
    }
}
