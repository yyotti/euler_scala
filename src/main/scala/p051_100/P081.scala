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
  import collection.mutable.PriorityQueue

  type Vertex = (Int, Int)

  def init(matrix: Array[Array[Int]]) =
    PriorityQueue.empty[(Int, Vertex)](Ordering.by[(Int, Vertex), Int] { _._1 }.reverse) ++=
      (0 to matrix.length - 1).flatMap { i =>
        (0 to matrix(i).length - 1).map { j =>
          val dv = if ((i, j) == (0, 0)) matrix(0)(0) else Int.MaxValue
          (dv, (i, j))
        }
      }

  def findMinRoute(matrix: Array[Array[Int]], queue: PriorityQueue[(Int, Vertex)], prev: Map[Vertex, Vertex]): Long = {
    val iMax = matrix.length - 1
    val jMax = matrix(0).length - 1

    def next(u: Vertex) = u match {
      case (i, j) if (i, j) == (iMax, jMax) => Nil
      case (i, j) if i == iMax => List((i, j + 1))
      case (i, j) if j == jMax => List((i + 1, j))
      case (i, j) => List((i, j + 1), (i + 1, j))
    }

    def replace(q: PriorityQueue[(Int, Vertex)], u: Vertex, newVal: Int) = q.filter { case (_, v) => v != u } += ((newVal, u))

    def sumRoute(prev: Map[Vertex, Vertex]) = {
      def toList(p: Vertex): List[Int] = p match {
        case (0, 0) => List(matrix(0)(0))
        case (i, j) => matrix(i)(j) :: toList(prev(p))
      }

      toList((iMax, jMax)).sum
    }

    queue match {
      case q if q.isEmpty => sumRoute(prev)
      case q => {
        val (du, u) = queue.dequeue
        val (r, route) =
          next(u)
            .foldLeft((q, prev)) { case ((q, prev), (x, y)) =>
              val alt = du + matrix(x)(y)
              q.find { case (_, p) => p == (x, y) } match {
                case Some((value, p)) if (value > alt) => (replace(q, p, alt), prev + (p -> u))
                case _ => (q, prev)
              }
            }
        findMinRoute(matrix, r, route)
      }
    }
  }

  /**
   * 最短経路問題なので、ダイクストラ法で解ける。
   * 優先度付きキューを使って、
   * ==================================================
   * for (v ← V)
   *   d(v) ← (v = sならば0、それ以外は∞)
   *   prev(v) ← 無し
   *   Q(v) ← d(v)
   *
   * while (Qが空集合でない)
   *   QからQ(u)が最小である頂点uを取り出す
   *   for each (uからの辺がある各 v ∈ V )
   *     alt ← d(u) + length(u, v)
   *     if (d(v) ＞ alt)
   *       d(v) ← alt
   *       prev(v) ← u
   *       Q(v) ← alt
   * ==================================================
   * で解けるらしい。
   */
  def solve: Long = {
    val matrix = withSource(io.Source.fromFile(new java.io.File("src/main/resources/p081_matrix.txt"))) { src =>
      src.getLines.map { _.split(",").map { _.toInt }.toArray }.toArray
    }

    findMinRoute(matrix, init(matrix), Map.empty)
  }
}
