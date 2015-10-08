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

  def countMinRoutes(m: Int) =
    (1 to m)
      .flatMap { w =>
        (2 to 2 * m)
          .withFilter { hd => val z = math.sqrt(math.pow(hd, 2) + math.pow(w, 2)); z.toInt == z }
          .map { hd =>
            if (hd <= w) hd / 2
            else if (hd / 2 < hd - w) 0
            else hd / 2 - (hd - w) + 1
          }
      }
      .sum

  /**
   * 立方体の底面の長方形をSABC、上面(底面と平行な面)の長方形をXYFZとし、各辺の長さを下記のように定義する。
   *   SA = d (奥行)
   *   SC = w (横)
   *   SX = h (高さ)
   * 立方体の向きを変えれば同じ形になるケースがあるので、h &le; d &le; w としてよい。
   *
   * 展開図を描いて考える。最短ルートの候補をr1,r2,r3とすれば、
   *   r1: SからABと交差してFに繋ぐ線分
   *   r2: SからBCと交差してFに繋ぐ線分
   *   r3: SからZCと交差してFに繋ぐ線分
   * となる。
   * これらはそれぞれ、展開図における下記の長さに等しい。
   *   r1: SYFCの対角線
   *   r2: SAFZの対角線
   *   r3: SXFBの対角線
   *
   * r1については、SYFCの対角線なので、辺の長さがそれぞれ (h + d)、w の長方形である。
   *   →対角線の2乗 = (h + d)^2 + w^2 = h^2 + d^2 + w^2 + 2hd
   * r2については、SAFZの対角線なので、辺の長さがそれぞれ (w + h)、d の長方形である。
   *   →対角線の2乗 = (w + h)^2 + d^2 = h^2 + d^2 + w^2 + 2hw
   * r3については、SXFBの対角線なので、辺の長さがそれぞれ (d + w)、h の長方形である。
   *   →対角線の2乗 = (d + w)^2 + h^2 = h^2 + d^2 + w^2 + 2dw
   *
   * h &le; d &le; w であるから、2hd &le; 2d^2 &le; 2hw。
   * d &le; w 2d^2 &le; 2dw より、2hd &le; 2d^2 &le; 2dw &le; 2hw。
   * よって、最短ルートはr1である。
   *
   * x = h + d, y = w とすると、y &le; M の範囲で √(x^2 + y^2) が整数となる(x, y)の組を探し、
   * その後xをhとdの和に分割すればよい。
   *
   * ※ピタゴラス数でいけるかと思ったが、ピタゴラス数を小さい方から並べる方法が分からなかった
   */
  def solve(n: Int): Long =
    Stream.from(0).map { m => countMinRoutes(m) }.indexWhere { _ > n }
}
