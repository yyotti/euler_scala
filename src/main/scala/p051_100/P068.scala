package project_euler

/**
 * Problem 68:
 * Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine.
 *
 * (図は省略)
 *
 * Working clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example), each solution can be described uniquely.
 * For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.
 *
 * It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.
 *
 * Total    Solution Set
 * 9    4,2,3; 5,3,1; 6,1,2
 * 9    4,3,2; 6,2,1; 5,1,3
 * 10   2,3,5; 4,5,1; 6,1,3
 * 10   2,5,3; 6,3,1; 4,1,5
 * 11   1,4,6; 3,6,2; 5,2,4
 * 11   1,6,4; 5,4,2; 3,2,6
 * 12   1,5,6; 2,6,4; 3,4,5
 * 12   1,6,5; 3,5,4; 2,4,6
 * By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.
 *
 * Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is the maximum 16-digit string for a "magic" 5-gon ring?
 *
 * (図は省略)
 *
 * 問題 68:
 * 下に示す図のようなものを"magic" 3-gon ringという. これは1～6の数字を当てはめて, 各列の数字の和が9となっている. これを例として説明する.
 *
 * (図は省略)
 *
 * 外側のノードのうち一番小さいものの付いた列(例では4,3,2)から時計回りに回ってそれぞれ列の数字を3つ連ねて説明する.
 * 例えば例のものは4,3,2; 6,2,1; 5,1,3という組で説明することができる.
 *
 * 1～6の数字を当てはめて, 各列の数字の和が等しくなるものは次の8通りある.
 *
 * 合計          組
 * 9    4,2,3; 5,3,1; 6,1,2
 * 9    4,3,2; 6,2,1; 5,1,3
 * 10   2,3,5; 4,5,1; 6,1,3
 * 10   2,5,3; 6,3,1; 4,1,5
 * 11   1,4,6; 3,6,2; 5,2,4
 * 11   1,6,4; 5,4,2; 3,2,6
 * 12   1,5,6; 2,6,4; 3,4,5
 * 12   1,6,5; 3,5,4; 2,4,6
 * この組の各数字を連結して, 9桁の数字で表すことができる. 例えば, 上の図のものは4,3,2; 6,2,1; 5,1,3であるので432621513である.
 *
 * さて, 下の図に1～10の数字を当てはめ, 各列の数字の和が等しくなる"magic" 5-gon ringを作って, それを表す16桁または17桁の数字のうち, 16桁のものの最大の数字を答えよ.
 *
 * (注, 3つの場合の例を見ても分かる通り, 列の始まりの数字を比べた時一番小さい数字で始まる列から時計回りに繋げるという条件のもとで文字列を生成する必要があります. この条件下で最大となる数字を答えてください. )
 *
 * (図は省略)
 */
object P068 {

  def findNgonRings(n: Int): List[List[(Int, Int, Int)]] = {
    def groupNodes(ls: Seq[Int]) =
      (0 until n).map { k => (ls(k), ls(n + k), ls(if (k + 1 == n) k + 1 else n + k + 1)) }

    def rolling(min: Int, ls: List[(Int, Int, Int)]): List[(Int, Int, Int)] = (min, ls) match {
      case (m, (x, _, _) :: _) if m == x => ls
      case (_, xs :: xss) => rolling(min, xss ::: List(xs))
    }

    val cache = collection.mutable.Set[String]()

    def isNgonRing(ls: Seq[(Int, Int, Int)]) = {
      val str = ls.foldLeft("") { case (s, (n1, n2, n3)) => s + n1 + n2 + n3 }
      if (cache.contains(str) || ls.map { case (n1, n2, n3) => n1 + n2 + n3 }.distinct.size != 1) false
      else {
        cache.add(str)
        true
      }
    }

    (1 to 2 * n)
      .permutations
      .map { groupNodes }
      .map { ls => rolling(ls.minBy { _._1 }._1, ls.toList) }
      .withFilter { isNgonRing }
      .toList
      .distinct
  }

  /**
   * 問題のサイズをnとする。問題の例ではn = 3である。
   *
   * 図の各ノードに対して番号を振っていく。番号kが振られたノードを「N(k)」と呼ぶことにする。
   * 番号を振る際のルールは
   * 1. 外側に突き出しているノードに対し、時計回りに1～nの番号を振る。
   * 2. N(1)が接続されている内側のノードの番号を(n + 1)とし、時計回りに2nまで番号を振る。
   * とする。
   *
   * 上記のルールに従って番号を振ると、N(k)(1 &le; k &le; n)が接続するのはN(n + k)となる。
   * N(k)とN(n + k)の延長にあるノードはN(n + k + 1)となるので、1 &le; k &le; n に対して
   *   N(1) + N(n + 1) + N(n + 2)
   *   N(2) + N(n + 2) + N(n + 3)
   *       ・・・
   *   N(n - 1) + N(2n - 1) + N(2n + 1)
   *   N(n) + N(2n) + N(2n + 1)
   * の値が全て同じになるよう配置すればよい。
   *
   * ただし、最後のみノードの番号が(2n + 1)となってしまうので、kが2nを超えたら(k - n)とみなすことにする。
   */
  def solve(n: Int, d: Int): Long =
    findNgonRings(n)
      .map { ls => ls.flatMap { case (n1, n2, n3) => List(n1, n2, n3) }.mkString }
      .filter { _.length == d }
      .sorted
      .reverse
      .head
      .toLong
}
