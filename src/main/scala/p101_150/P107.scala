package project_euler

/**
 * Problem 107:
 * The following undirected network consists of seven vertices and twelve edges with a total weight of 243.
 *
 * (図は省略)
 *
 * The same network can be represented by the matrix below.
 *
 *    A  B  C  D  E  F  G
 * A  - 16 12 21  -  -  -
 * B 16  -  - 17 20  -  -
 * C 12  -  - 28  - 31  -
 * D 21 17 28  - 18 19 23
 * E  - 20  - 18  -  - 11
 * F  -  - 31 19  -  - 27
 * G  -  -  - 23 11 27  -
 *
 * However, it is possible to optimise the network by removing some edges and still ensure that all points on the network remain connected.
 * The network which achieves the maximum saving is shown below. It has a weight of 93, representing a saving of 243 − 93 = 150 from the original network.
 *
 * (図は省略)
 *
 * Using network.txt (right click and 'Save Link/Target As...'), a 6K text file containing a network with forty vertices,
 * and given in matrix form, find the maximum saving which can be achieved by removing redundant edges whilst ensuring that the network remains connected.
 *
 * 問題 107:
 * 以下の無向ネットワークは7つの頂点と重み付きの12個の辺からなり, 重みの総和は243である.
 *
 * (図は省略)
 *
 * このネットワークを以下の行列で表現することができる.
 *
 *    A  B  C  D  E  F  G
 * A  - 16 12 21  -  -  -
 * B 16  -  - 17 20  -  -
 * C 12  -  - 28  - 31  -
 * D 21 17 28  - 18 19 23
 * E  - 20  - 18  -  - 11
 * F  -  - 31 19  -  - 27
 * G  -  -  - 23 11 27  -
 *
 * しかし, このネットワークを, 全ての頂点が連結であるように適当な辺を除いた上で最適化することが出来る.
 * 節約される量が最大化されるように取り除いたネットワークが以下の画像である.
 * この場合, 辺の重みの総和は93であり, 元のネットワークからの節約量は 243 - 93 = 150 である.
 *
 * (図は省略)
 *
 * 6Kバイトのテキストファイル network.txt (右クリックして保存すること) には40頂点のネットワークを行列表示したものが記されている.
 * ネットワーク全体が連結であるが冗長な辺を取り除いたときの節約量を最大にするようにした場合の節約量を答えよ.
 */
object P107 {
  import commons._
  import collection.mutable.PriorityQueue

  case class Edge(from: Int, to: Int, weight: Int) extends Ordered[Edge] {
    def compare(that: Edge): Int = that.weight - weight
  }

  def prim(graph: Map[Int, List[Edge]]): List[Edge] = {
    val q = PriorityQueue(Edge(-1, 1, 0))

    def loop(r: List[Edge], vd: Set[Int]): List[Edge] =
      if (q.isEmpty) r
      else {
        val e = q.dequeue
        if (vd.contains(e.to)) loop(r, vd)
        else {
          graph.get(e.to).map {
            _.foreach {
              case ne if ne.to != e.from => q.enqueue(ne)
              case _ =>
            }
          }
          loop(e :: r, vd + e.to)
        }
      }

    loop(Nil, Set.empty).init
  }

  def toGraph(matrix: Array[Array[Int]]): Map[Int, List[Edge]] =
    (0 until matrix.length).flatMap { i =>
      (0 until matrix(i).length).flatMap { j =>
        if (matrix(i)(j) == 0) None
        else Some(Edge(i, j, matrix(i)(j)))
      }
    }.foldLeft(Map[Int, List[Edge]]()) { (map, e) => map + (e.from -> (e :: map.getOrElse(e.from, Nil))) }

  /**
   * ちょっとググってみたら、こういう問題は「重み付き連結グラフの最小全域木を求める最適化問題」なので
   * 「プリム法」もしくは「クラスカル法」というアルゴリズムで解けるらしい。
   * 今回はプリム法でやってみる。
   *
   * 入力：重み付きグラフ(頂点集合V、辺集合E)
   * 出力：VnewとEnewが最小全域木を表している。
   *   Vnew = {x}、ここでxはVの元であり、任意のノード(出発点)
   *   Enew = {}
   *   while (Vnew ≠ V)
   *     Vnewに含まれる頂点uと含まれない頂点vを結ぶ重みが最小の辺(u,v)をEから選択
   *     vをVnewに加える
   *     (u,v)をEnewに加える
   *
   * 今回対象とするグラフは無向グラフなので、行列表現は対角要素を軸に対称性がある。
   * しかし有向グラフと見たほうが実装が楽らしいので、半分ではなく全体を見る。
   *
   * 問題にある最適化後のネットワークを行列で表現すると下記のようになる。
   *
   *    A  B  C  D  E  F  G
   * A  - 16 12  -  -  -  -
   * B 16  -  - 17  -  -  -
   * C 12  -  -  -  -  -  -
   * D  - 17  -  - 18 19  -
   * E  -  -  - 18  -  - 11
   * F  -  -  - 19  -  -  -
   * G  -  -  -  - 11  -  -
   */
  def solve: Long = {
    val matrix = withSource(io.Source.fromFile(new java.io.File("src/main/resources/p107_network.txt"))) { src =>
      src
        .getLines
        .map { line => line.split(",").map { s => if (s == "-") 0 else s.toInt }.toArray }
        .toArray
    }

    matrix.map { _.sum }.sum / 2 - prim(toGraph(matrix)).map { _.weight }.sum
  }
}
