package project_euler

/**
 * Problem 39:
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 *
 * 問題 39:
 * 辺の長さが {a,b,c} と整数の3つ組である直角三角形を考え, その周囲の長さを p とする. p = 120のときには3つの解が存在する:
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * p ≤ 1000 のとき解の数が最大になる p はいくつか?
 */
object P039 {
  import commons._

  /**
   * 原始ピタゴラス数を考える。
   *
   * 自然数 m,n が
   * ・mとnは互いに素
   * ・m > n
   * ・m - nは奇数
   * を満たすとき、原始ピタゴラス数は
   *   {m^2 - n^2, 2mn, m^2 + n^2} or {2mn, m^2 - n^2, m^2 + n^2}
   * と書ける。周囲の長さをSとすると
   *   S = m^2 - n^2 + 2mn + m^2 + n^2
   *     = 2m^2 + 2mn
   *     = 2m(m + n)
   * である。ピタゴラス数は原始ピタゴラス数を定数倍したものなので、
   * Sがpの約数か否かを調べていけばよい。
   *
   * また条件から最小の(m,n)は(2,1)であるから、Sの最小値 Sminは
   *   Smin = 2*2(2+1) = 12
   * なので、12 <= p <= 1000 の範囲で調べればよい。
   *
   * S <= p の範囲で調べればよいので、
   *   S = 2m(m + n) <= p
   * nの最小値は1なので、n = 1とした場合は
   *   2m^2 + 2m <= p
   *   2m^2 + 2m - p <= 0
   * である。
   *   2m^2 + 2m - p = 0
   * を解くと
   *   m = (-1 ± √(1 + 2p))/2
   * m > 0 から
   *   0 < m <= (-1 + √(1 + 2p))/2
   * の範囲であればよい。
   */
  def solve: Long =
    Stream.from(12).takeWhile { _ <= 1000 }.map { p =>
      (p,
      Stream
        .from(2)
        .takeWhile { _ <= (-1 + math.sqrt(1 + 2 * p)) / 2 }
        .flatMap { m => Stream.from(1).takeWhile { _ < m }.map { n => (m, n) } }
        .withFilter { case (m, n) => (m - n) % 2 == 1 && gcd(m, n) == 1 }
        .map { case (m, n) => 2 * m * (m + n) }
        .filter { s => p % s == 0 }
        .size
        )
    }.maxBy { _._2 }._1


  val cache = collection.mutable.Map[(Int, Int), Int]()
}
