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
  def solve: Long = ???
}
