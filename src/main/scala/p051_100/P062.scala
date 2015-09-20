package project_euler

/**
 * Problem 62:
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3).
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 *
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 *
 * 問題 62:
 * 立方数 41063625 (345^3) は, 桁の順番を入れ替えると2つの立方数になる: 56623104 (384^3) と 66430125 (405^3) である.
 * 41063625は, 立方数になるような桁の置換をちょうど3つもつ最小の立方数である.
 *
 * 立方数になるような桁の置換をちょうど5つもつ最小の立方数を求めよ.
 */
object P062 {
  import commons._

  val cubes = from(1).map { n => val c = n * n * n; (c.toString, digitCount(c)) }

  def solve(n: Int): Long =
    cubes.find { case (c, d) => cubes.dropWhile { _._2 < d }.takeWhile { _._2 == d }.count { _._1.sorted == c.sorted } == n }.map { _._1.toLong }.get
}
