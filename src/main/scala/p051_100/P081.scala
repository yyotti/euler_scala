package project_euler

/**
 * Problem 81:
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right,
 * by only moving to the right and down, is indicated in bold red and is equal to 2427.
 *
 * 131  673  234  103   18
 * 201   96  342  965  150
 * 630  803  746  422  111
 * 537  699  497  121  956
 * 805  732  524   37  331
 *
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."), a 31K text file containing a 80 by 80 matrix,
 * from the top left to the bottom right by only moving right and down.
 *
 * 問題 81:
 * 下記の5次の正方行列で, 左上のセルから開始し右下のセルで終わるパスを探索する. ただし下方向と右方向にのみ移動できるものとする.
 * 通過したセルの和が最小となるパスは赤の太字で示されたもので, その値は2427である.
 *
 * 131  673  234  103   18
 * 201   96  342  965  150
 * 630  803  746  422  111
 * 537  699  497  121  956
 * 805  732  524   37  331
 *
 * 今, 31Kのテキストファイルmatrix.txt (右クリックして, 『名前をつけてリンク先を保存』)には80×80の行列が書かれている.
 * 同様に左上のセルから開始し右下のセルで終わり, かつ右方向と下方向にのみ移動するときの最小のパスの和を求めよ.
 */
object P081 {
  import commons._

  def findMinRoute(matrix: Array[Array[Int]], i: Int, j: Int): Long = {
    val rMax = matrix.length - 1
    val dMax = matrix.length - 1

    if (j == rMax) matrix.drop(i).map { _(j) }.sum
    else if (i == dMax) matrix(i).drop(j).sum
    else matrix(i)(j) + findMinRoute(matrix, i + 1, j).min(findMinRoute(matrix, i, j + 1))
  }

  def solve: Long = {
    val matrix = withSource(io.Source.fromFile(new java.io.File("src/main/resources/p081_matrix.txt"))) { src =>
      src.getLines.map { _.split(",").map { _.toInt }.toArray }.toArray
    }

    findMinRoute(matrix, 0, 0)
  }
}
