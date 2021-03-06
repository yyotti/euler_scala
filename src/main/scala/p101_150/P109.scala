package project_euler

/**
 * Problem 109:
 * In the game of darts a player throws three darts at a target board which is split into twenty equal sized sections numbered one to twenty.
 *
 * (図は省略)
 *
 * The score of a dart is determined by the number of the region that the dart lands in.
 * A dart landing outside the red/green outer ring scores zero. The black and cream regions inside this ring represent single scores.
 * However, the red/green outer ring and middle ring score double and treble scores respectively.
 *
 * At the centre of the board are two concentric circles called the bull region, or bulls-eye.
 * The outer bull is worth 25 points and the inner bull is a double, worth 50 points.
 *
 * There are many variations of rules but in the most popular game the players will begin with a score 301 or 501
 * and the first player to reduce their running total to zero is a winner.
 * However, it is normal to play a "doubles out" system, which means that the player must land a double
 * (including the double bulls-eye at the centre of the board) on their final dart to win;
 * any other dart that would reduce their running total to one or lower means the score for that set of three darts is "bust".
 *
 * When a player is able to finish on their current score it is called a "checkout" and the highest checkout is 170: T20 T20 D25 (two treble 20s and double bull).
 *
 * There are exactly eleven distinct ways to checkout on a score of 6:
 *
 * D3
 * D1  D2
 * S2  D2
 * D2  D1
 * S4  D1
 * S1  S1  D2
 * S1  T1  D1
 * S1  S3  D1
 * D1  D1  D1
 * D1  S2  D1
 * S2  S2  D1
 *
 * Note that D1 D2 is considered different to D2 D1 as they finish on different doubles. However, the combination S1 T1 D1 is considered the same as T1 S1 D1.
 *
 * In addition we shall not include misses in considering combinations; for example, D3 is the same as 0 D3 and 0 0 D3.
 *
 * Incredibly there are 42336 distinct ways of checking out in total.
 *
 * How many distinct ways can a player checkout with a score less than 100?
 *
 * 問題 109:
 * ダーツゲームでは, プレイヤーは 20 等分に分けられたダーツボードに 3 本のダーツを投げる. ダーツボードは 1 から 20 の番号がふられている.
 *
 * (図は省略)
 *
 * ダーツの点数は, ダーツが刺さった領域の番号によって決まる. 外側の赤緑の輪の外に刺さったダーツは 0 点である.
 * この輪の内側の黒と白の領域はシングル (1 倍) の点数を表している. しかし, 外側と内側の赤緑の輪はそれぞれダブル (2 倍) とトリプル (3 倍) の点数である.
 *
 * ボードの中央の 2 つの同心円はブルやブルズアイと呼ばれる. 外側のブルは 25 点, 内側のブルはダブルの 50 点である.
 *
 * ルールには多くのバリエーションがあるが, 最もポピュラーなゲームでは, プレイヤーは 301 または 501 点から始まり,
 * 最も早く現在の得点を 0 点に減らしたプレイヤーが勝者となる. しかし, 普通は「ダブルアウト」方式でプレイをする.
 * この方式では, プレイヤーは勝利するために, 最後のダーツをダブル (ボードの中央のダブルのブルズアイを含む) に刺さなければならない.
 * それ以外で現在の得点を 1 点以下に減らした場合, 3 本のダーツに対する得点は「バースト(無効)」になる.
 *
 * プレイヤーが現在の得点で終了できる場合を「チェックアウト」と呼ぶ. 最も高いチェックアウトは 170: T20 T20 D25 (トリプルの 20 を 2 回とダブルのブル) である.
 *
 * 得点が 6 でチェックアウトする異なるやり方はちょうど 11 通りある.
 *
 * D3
 * D1  D2
 * S2  D2
 * D2  D1
 * S4  D1
 * S1  S1  D2
 * S1  T1  D1
 * S1  S3  D1
 * D1  D1  D1
 * D1  S2  D1
 * S2  S2  D1
 *
 * D1 D2 と D2 D1 は, 異なるダブルで終了しているので異なるとみなすことに注意しよう. しかし S1 T1 D1 の組み合わせは T1 S1 D1 と同じとみなす.
 *
 * さらに, 組み合わせを考える上でミスは含まないこととする; たとえば, D3 は 0 D3 や 0 0 D3 と同じである.
 *
 * 信じられないことに, 異なるチェックアウトは全部で 42336 通りある.
 *
 * 得点が 100 未満の異なるチェックアウトは何通りあるか.
 */
object P109 {
  val points = (1 to 20).flatMap { p => Seq(1, 2, 3).map { m => (m, p) } } ++ Seq((1, 25), (2, 25), (0, 0))

  /**
   * 異なるチェックアウトは全部で42336通りなので、全て列挙することにする。
   *
   * 1投目、2投目、3投目を順に
   *   (p1, p2, p3)
   * とする。p3はダブルでなければならない。
   * 3投目までいかずにチェックアウトする場合も考えるために、1投目と2投目には0も含むことにし、
   * 1投目にD1でチェックアウトするケースなどは
   *   (0, 0, D1)
   * と表現することにする。
   *
   * この場合、p3にはD1～D20、D25(ダブルのブル)しか入らないので、21通りである。
   * p1,p2には以下の2つのケースが考えられる。
   *    i) p1、p2が同じケース
   *   ii) p1、p2が異なるケース
   * それぞれのケースを考えるために、1投でとりうるポイントの値を全て列挙すると、
   *   1点～20点にはシングルからトリプルまであるので60通り
   *   25点(ブル)にはシングルとダブルがあるので2通り
   *   0点は1通り
   * となり、計63通りある。
   * iのケースでは、(p1, p2) = (p1, p1)とすればいいので63通りある((0, 0)となった場合が
   * 1投でチェックアウトするケースに相当する)。
   * iiのケースでは、(p1, p2)に重複はなく、またp1とp2が逆になっても同じとみなすので、
   * 63通りから2通りを選ぶ組み合わせを列挙すればよい。よって63C2 = 1953通りある((0, x)と
   * なった場合が2投でチェックアウトするケースに相当する)。
   * i、iiの全ての場合に対して21通りのp3を付加できるので、総数は
   *   (1953 + 63) * 21 = 42336 通り
   * であり、問題文の総数と一致する。
   *
   * 上記の全ての組み合わせを列挙し、1投目から3投目までのポイントの和を出して、
   * それが100未満であるケースをカウントすればよい。
   */
  def solve(n: Int): Long = {
    val p12 =
      (points.zip(points) ++ points.combinations(2).map { ls => (ls(0), ls(1)) })
        .map { case ((m1, p1), (m2, p2)) => (m1 * p1, m2 * p2) }
    val ends = points.collect { case (m, p) if m == 2 => m * p }

    p12
      .flatMap { case (p1, p2) => ends.map { p3 => p1 + p2 + p3 } }
      .count { _ < n }
  }
}
