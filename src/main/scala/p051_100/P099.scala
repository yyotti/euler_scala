package project_euler

/**
 * Problem 99:
 * Comparing two numbers written in index form like 2^11 and 3^7 is not difficult, as any calculator would confirm that 2^11 = 2048 &lt; 3^7 = 2187.
 *
 * However, confirming that 632382^518061 &gt; 519432^525806 would be much more difficult, as both numbers contain over three million digits.
 *
 * Using base_exp.txt (right click and 'Save Link/Target As...'), a 22K text file containing one thousand lines with a base/exponent pair on each line,
 * determine which line number has the greatest numerical value.
 *
 * NOTE: The first two lines in the file represent the numbers in the example given above.
 *
 * 問題 99:
 * 指数の形で表される2つの数, 例えば 2^11 と 3^7, の大小を調べることは難しくはない. 電卓を使えば, 2^11 = 2048 &lt; 3^7 = 2187 であることが確かめられる.
 *
 * しかし, 632382^518061 &lt; 519432^525806 を確認することは非常に難しい (両者ともに300万桁以上になる).
 *
 * 各行に1組が書かれている1000個の組を含んだ22Kのテキストファイル base_exp.txt から, 最大の数が書かれている行の番号を求めよ.
 *
 * 注: ファイル中の最初の二行は上の例である.
 */
object P099 {
  import commons._

  /**
   * 底が10の対数をとって比較する。
   *   log(a^m) = m*log(a)
   * であるから、aの対数をとってからmをかければよい。
   */
  def solve: Long =
    withSource(io.Source.fromFile(new java.io.File("src/main/resources/p099_base_exp.txt"))) { src =>
      src
        .getLines
        .zipWithIndex
        .foldLeft((0.0, 0)) { case ((m, lineNo), (line, idx)) =>
          val (base :: exp :: _) = line.split(",").map { _.toInt }.toList
          val value = math.log10(base) * exp
          if (m < value) (value, idx)
          else (m, lineNo)
        }
        ._2 + 1
    }
}
