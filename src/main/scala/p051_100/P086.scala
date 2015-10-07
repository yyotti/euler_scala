package project_euler

/**
 * Problem 86:
 * A spider, S, sits in one corner of a cuboid room, measuring 6 by 5 by 3, and a fly, F, sits in the opposite corner.
 * By travelling on the surfaces of the room the shortest "straight line" distance from S to F is 10 and the path is shown on the diagram.
 *
 * (図は省略)
 *
 * However, there are up to three "shortest" path candidates for any given cuboid and the shortest route doesn't always have integer length.
 *
 * It can be shown that there are exactly 2060 distinct cuboids, ignoring rotations, with integer dimensions,
 * up to a maximum size of M by M by M, for which the shortest route has integer length when M = 100.
 * This is the least value of M for which the number of solutions first exceeds two thousand; the number of solutions when M = 99 is 1975.
 *
 * Find the least value of M such that the number of solutions first exceeds one million.
 *
 * 問題 86:
 * 下に示す直方体は寸法が6×5×3である. この直方体の1つの頂点Sにクモがいる. また反対の頂点Fにはハエがいる.
 * SからFまでの壁に沿って直線移動する最短ルートは図に示す通りで, この長さは10である.
 *
 * (図は省略)
 *
 * この最短ルートの候補は3本あるが, 最短のものがいつも整数長さとは限らない.
 *
 * さて, M×M×M以下の寸法の直方体について, 最短ルートが整数である直方体の数を考える. M=100のとき, 条件を満たす直方体は2060個ある.
 * このM=100は個数が2000を超える最小のMである. なお, M=99のときは1975個である.
 *
 * 100万個を超える最小のMを求めよ.
 */
object P086 {
  def solve(n: Int): Long = ???
}
