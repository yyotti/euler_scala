package project_euler

/**
 * Problem 82:
 * NOTE: This problem is a more challenging version of Problem 81.
 *
 * The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left column and finishing in any cell in the right column,
 * and only moving up, down, and right, is indicated in red and bold; the sum is equal to 994.
 *
 * 131  673  234  103   18
 * 201   96  342  965  150
 * 630  803  746  422  111
 * 537  699  497  121  956
 * 805  732  524   37  331
 *
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."), a 31K text file containing a 80 by 80 matrix,
 * from the left column to the right column.
 *
 * 問題 82:
 * 注: この問題はProblem 81よりも挑戦しがいがあるだろう.
 *
 * 下記の5次の正方行列で, 一番左の行の任意のセルから開始し一番右の行の任意のセルで終わる道を探索する. ただし上下右にのみ移動できるものとする.
 * 一番小さなパスは下で赤の太字で示されたものである. このときの合計は994になる.
 *
 * 131  673  234  103   18
 * 201   96  342  965  150
 * 630  803  746  422  111
 * 537  699  497  121  956
 * 805  732  524   37  331
 *
 * 今, 31Kのテキストファイルmatrix.txtには80×80の行列が書かれている. 一番左の行から一番右の行へ移動する際の一番小さなパスの和を求めよ.
 */
object P082 {
  import commons._
  import collection.mutable.PriorityQueue

  type Vertex = (Int, Int)

  def init(matrix: Array[Array[Int]]) =
    PriorityQueue.empty[(Int, Vertex)](Ordering.by[(Int, Vertex), Int] { _._1 }.reverse) ++=
      (0 to matrix.length - 1).flatMap { i =>
        (0 to matrix(i).length - 1).map { j =>
          val dv = if (j == 0) matrix(i)(0) else Int.MaxValue
          (dv, (i, j))
        }
      }

  def findMinRoute(matrix: Array[Array[Int]], queue: PriorityQueue[(Int, Vertex)]): Long = {
    val iMax = matrix.length - 1
    val jMax = matrix(0).length - 1

    def next(i: Int, j: Int) =
      if (j == jMax) Nil
      else if (i == 0) List((i, j + 1), (i + 1, j))
      else if (i == iMax) List((i - 1, j), (i, j + 1))
      else List((i - 1, j), (i, j + 1), (i + 1, j))

    def replace(q: PriorityQueue[(Int, Vertex)], u: Vertex, newVal: Int) = q.filter { case (_, v) => v != u } += ((newVal, u))

    val (du, (i, j)) = queue.dequeue
    if (j == jMax) du
    else {
      val r =
        next(i, j)
          .foldLeft(queue) { case (q, (x, y)) =>
            val alt = du + matrix(x)(y)
            q.find { case (_, p) => p == (x, y) } match {
              case Some((value, p)) if (value > alt) => replace(q, p, alt)
              case _ => q
            }
          }
      findMinRoute(matrix, r)
    }
  }

  /**
   * P081と同様、ダイクストラ法でやれる。
   */
  def solve: Long = {
    val matrix = withSource(io.Source.fromFile(new java.io.File("src/main/resources/p082_matrix.txt"))) { src =>
      src.getLines.map { _.split(",").map { _.toInt }.toArray }.toArray
    }

    findMinRoute(matrix, init(matrix))
  }
}
