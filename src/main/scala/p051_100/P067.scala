package project_euler

/**
 * Problem 67:
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.
 *
 * NOTE: This is a much more difficult version of Problem 18.
 * It is not possible to try every route to solve this problem, as there are 2^99 altogether!
 * If you could check one trillion (10^12) routes every second it would take over twenty billion years to check them all.
 * There is an efficient algorithm to solve it. ;o)
 *
 * 問題 67:
 * 以下の三角形の頂点から下まで移動するとき, その数値の合計の最大値は23になる.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * この例では 3 + 7 + 4 + 9 = 23
 *
 * 100列の三角形を含んでいる15Kのテキストファイル triangle.txt (右クリックして, 『名前をつけてリンク先を保存』)の上から下まで最大合計を見つけてください.
 *
 * 注：これは, Problem 18のずっと難しいバージョンです.
 * 全部で2^99 通りの組み合わせがあるので, この問題を解決するためにすべてのルートをためすことは可能でありません！
 * あなたが毎秒1兆本の(10^12)ルートをチェックすることができたとしても, 全てをチェックするために200億年以上かかるでしょう.
 * 解決するための効率的なアルゴリズムがあります. ;o)
 */
object P067 {
  import commons._

  def findMaxRoute(lines: List[List[Int]]): Long =
    lines.reverse.reduceLeft { (sums, line) =>
      sums
        .zip(sums.tail)
        .map { case (a, b) => a.max(b) }
        .zip(line)
        .map { case (a, b) => a + b }
    }.head

  /**
   * P018で作ったものがそのまま使えた。
   *
   * 頂点からではなく下から攻めるようにした。
   * まず最も下の行の隣り合う数字のうち、大きい方を残した数列を新たに作る。
   *   例) 8 5 9 3 → max(8, 5) max(5, 9) max(9 3) → 8 9 9
   * 生成された数列と、下から2番目の行の数字との和をとる。
   *   例)
   *     2 4 6
   *     8 9 9 → 2+8 4+9 6+9 → 10 13 15
   * この結果を最下行として、最も上の行まで続けていく。残った1項が和の最大値である。
   */
  def solve: Long =
    withSource(io.Source.fromFile(new java.io.File("src/main/resources/p067_triangle.txt"))) { src =>
      findMaxRoute(src.getLines.toList.map { line => line.split(" ").map { _.toInt }.toList })
    }
}
