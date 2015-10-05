package project_euler

/**
 * Problem 83:
 * In the 5 by 5 matrix below, the minimal path sum from the top left to the bottom right, by moving left, right, up, and down,
 * is indicated in bold red and is equal to 2297.
 *
 * 131  673  234  103   18
 * 201   96  342  965  150
 * 630  803  746  422  111
 * 537  699  497  121  956
 * 805  732  524   37  331
 *
 * Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."), a 31K text file containing a 80 by 80 matrix,
 * from the top left to the bottom right by moving left, right, up, and down.
 *
 * 問題 83:
 * 注: この問題はProblem 81よりも非常に挑戦しがいがあるだろう.
 *
 * 下記の5次の正方行列で, 上下左右に移動し左上のセルから開始し右下のセルで終了する道を探索する.
 * 一番小さな道は下で赤で示されており, このときの合計は2297になる.
 *
 * 131  673  234  103   18
 * 201   96  342  965  150
 * 630  803  746  422  111
 * 537  699  497  121  956
 * 805  732  524   37  331
 *
 * 今, 31Kのテキストファイルmatrix.txtには80×80の行列が書かれている. 上下左右に移動し左上のセルから開始し右下のセルで終了する道に沿った和の最小を求めよ.
 */
object P083 {
  import commons._
  import collection.mutable.PriorityQueue

  type Vertex = (Int, Int)

  def init(matrix: Array[Array[Int]]) =
    PriorityQueue.empty[(Int, Vertex)](Ordering.by[(Int, Vertex), Int] { _._1 }.reverse) ++=
      (0 to matrix.length - 1).flatMap { i =>
        (0 to matrix(i).length - 1).map { j =>
          val dv = if ((i, j) == (0, 0)) matrix(i)(j) else Int.MaxValue
          (dv, (i, j))
        }
      }

  def findMinRoute(matrix: Array[Array[Int]], queue: PriorityQueue[(Int, Vertex)]): Long = {
    val iMax = matrix.length - 1
    val jMax = matrix(0).length - 1

    def next(i: Int, j: Int) =
      Seq((-1, 0), (1, 0), (0, -1), (0, 1))
        .map { case (dy, dx) => (i + dy, j + dx) }
        .filter { case (i, j) => i >= 0 && i <= iMax && j >= 0 && j <= jMax }

    def replace(q: PriorityQueue[(Int, Vertex)], u: Vertex, newVal: Int) = q.filter { case (_, v) => v != u } += ((newVal, u))

    val (du, (i, j)) = queue.dequeue
    if ((i, j) == (iMax, jMax)) du
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
   * P082と同様、ダイクストラ法でやれる。
   */
  def solve: Long = {
    val matrix = withSource(io.Source.fromFile(new java.io.File("src/main/resources/p083_matrix.txt"))) { src =>
      src.getLines.map { _.split(",").map { _.toInt }.toArray }.toArray
    }

    findMinRoute(matrix, init(matrix))
  }
}
