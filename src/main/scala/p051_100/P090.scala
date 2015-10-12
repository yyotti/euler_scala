package project_euler

/**
 * Problem 90:
 * Each of the six faces on a cube has a different digit (0 to 9) written on it;
 * the same is done to a second cube. By placing the two cubes side-by-side in different positions we can form a variety of 2-digit numbers.
 *
 * For example, the square number 64 could be formed:
 *
 * (図は省略)
 *
 * In fact, by carefully choosing the digits on both cubes it is possible to display all of the square numbers below one-hundred:
 * 01, 04, 09, 16, 25, 36, 49, 64, and 81.
 *
 * For example, one way this can be achieved is by placing {0, 5, 6, 7, 8, 9} on one cube and {1, 2, 3, 4, 8, 9} on the other cube.
 *
 * However, for this problem we shall allow the 6 or 9 to be turned upside-down so that an arrangement like {0, 5, 6, 7, 8, 9} and {1, 2, 3, 4, 6, 7}
 * allows for all nine square numbers to be displayed; otherwise it would be impossible to obtain 09.
 *
 * In determining a distinct arrangement we are interested in the digits on each cube, not the order.
 *
 * {1, 2, 3, 4, 5, 6} is equivalent to {3, 6, 4, 1, 2, 5}
 * {1, 2, 3, 4, 5, 6} is distinct from {1, 2, 3, 4, 5, 9}
 *
 * But because we are allowing 6 and 9 to be reversed, the two distinct sets in the last example both represent the extended set {1, 2, 3, 4, 5, 6, 9}
 * for the purpose of forming 2-digit numbers.
 *
 * How many distinct arrangements of the two cubes allow for all of the square numbers to be displayed?
 *
 * 問題 90:
 * 立方体の6面それぞれに異なる数字(0から9)が書かれている;2番目の立方体も同様になっている. 異なる位置に2つの立方体を隣り合わせることで様々な2桁の数を作ることができる.
 *
 * 例えば, 平方数である64も作ることができる:
 *
 * (図は省略)
 *
 * 事実, 両方の立方体の数字を注意深く選ぶと100以下のすべての平方数を示すことが可能である:01, 04, 09, 16, 25, 36, 49, 64, そして 81.
 *
 * 例えば, これを実現する一つの方法としては {0, 5, 6, 7, 8, 9} を一方の立方体に, そして {1, 2, 3, 4, 8, 9} を他方の立方体に配置すればよい.
 *
 * しかし, 6と9を逆さまに回転することを許すと {0, 5, 6, 7, 8, 9} と {1, 2, 3, 4, 6, 7} のような配列で9つすべての平方数を示す事ができる;
 * そうでなければ09を得ることができない.
 *
 * 順番ではなくそれぞれの立方体の数字に着目して配列を区別する.
 *
 * {1, 2, 3, 4, 5, 6} は {3, 6, 4, 1, 2, 5} と同じものとし
 * {1, 2, 3, 4, 5, 6} は {1, 2, 3, 4, 5, 9} と異なるものとする.
 *
 * しかし6と9を逆さにすることを許すために, 最後の例で区別された両方の配列のかわりに, {1, 2, 3, 4, 5, 6, 9} という(要素数が７つに)拡張された
 * 配列を使用して2桁の数をつくることにする.
 *
 * すべての平方数を表示し得る2つの立方体の異なる配列の組はいくつあるか.
 */
object P090 {

  val squares = List(
    (0, 1),
    (0, 4),
    (0, 9),
    (1, 6),
    (2, 5),
    (3, 6),
    (4, 9),
    (6, 4),
    (8, 1)
  )

  def createDices(nums: List[Int], c: Int) = nums.combinations(c)

  def checkSquares(dice1: Set[Int], dice2: Set[Int]) = {
    def add69(dice: Set[Int]) =
      if (dice.contains(6)) dice + 9
      else if (dice.contains(9)) dice + 6
      else dice

    val d1 = add69(dice1)
    val d2 = add69(dice2)
    squares.forall { case (n1, n2) =>
      d1.contains(n1) && d2.contains(n2) || d1.contains(n2) && d2.contains(n1)
    }
  }

  /**
   * 立方体に数字を配置するにあたり、以下の制約があることが分かる。
   *    i)0は1桁の平方数の10の位にしか使われないため、0と{1, 4, 9}は別々の立方体に含まれなければならない。
   *   ii)2と5は25にしか使われないので、2と5は別々の立方体に含まれなければならない。
   *  iii)3は36にしか使われないので、6とは反対側の立方体に3を含めなければならない。
   *   iv)8は81にしか使われないので、1とは反対側の立方体に8を含めなければならない。
   * これらの制約から確定できるのは
   *   立方体1：{0, 2}
   *   立方体2：{1, 4, 5, 9}
   * もしくは
   *   立方体1：{0, 5}
   *   立方体2：{1, 4, 2, 9}
   * である。
   *
   * あとは総当たりで解く。
   *
   * と思ったが、やってみると答えが違う。しょうがないので完全総当たりでやる。
   * 完全総当たりでも、
   *   1つの立方体に対する配列数：10C6 = 210通り
   *   →210個の立方体から2つを選ぶ：210C2 = 21945通り
   * なので、比較的短時間で解けるはず。
   */
  def solve: Long =
    createDices(List.range(0, 10), 6)
      .toSeq
      .combinations(2)
      .count { ls => checkSquares(ls(0).toSet, ls(1).toSet) }
}
