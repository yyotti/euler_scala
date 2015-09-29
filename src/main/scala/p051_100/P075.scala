package project_euler

/**
 * Problem 75:
 * It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle triangle in exactly one way,
 * but there are many more examples.
 *
 * 12 cm: (3,4,5)
 * 24 cm: (6,8,10)
 * 30 cm: (5,12,13)
 * 36 cm: (9,12,15)
 * 40 cm: (8,15,17)
 * 48 cm: (12,16,20)
 *
 * In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle,
 * and other lengths allow more than one solution to be found;
 * for example, using 120 cm it is possible to form exactly three different integer sided right angle triangles.
 *
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 *
 * Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right angle triangle be formed?
 *
 * 問題 75:
 * ある長さの鉄線を折り曲げて3辺の長さが整数の直角三角形を作るとき, その方法が1通りしかないような最短の鉄線の長さは12cmである.
 * 他にも沢山の例が挙げられる.
 *
 * 12 cm: (3,4,5)
 * 24 cm: (6,8,10)
 * 30 cm: (5,12,13)
 * 36 cm: (9,12,15)
 * 40 cm: (8,15,17)
 * 48 cm: (12,16,20)
 *
 * それとは対照的に, ある長さの鉄線 (例えば20cm) は3辺の長さが整数の直角三角形に折り曲げることができない.
 * また2つ以上の折り曲げ方があるものもある. 2つ以上ある例としては, 120cmの長さの鉄線を用いた場合で, 3通りの折り曲げ方がある.
 *
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 *
 * Lを鉄線の長さとする. 直角三角形を作るときに1通りの折り曲げ方しか存在しないような L ≤ 1,500,000 の総数を答えよ.
 *
 * 注: この問題は最近変更されました. あなたが正しいパラメータを使っているか確認してください.
 */
object P075 {
  import commons._

  def len(m: Long, n: Long): Long = 2 * m * (m + n)

  /**
   * 鉄線の長さをlとすると、lはピタゴラス数(a, b, c)の和である。
   *
   * m,nを下記の条件を満たす自然数とする。
   * ・m &gt; n
   * ・mとnは互いに素
   * ・mとnの差は奇数
   * このとき、(a, b, c)を原始ピタゴラス数とすると、
   *   (a, b, c) = (m^2 - n^2, 2mn, m^2 + n^2)
   * で表される。
   * ピタゴラス数は原始ピタゴラス数の整数倍である。
   *
   * いま、l = a + b + c であるから、
   *   l = (m^2 - n^2) + 2mn + (m^2 + n^2)
   *     = 2m^2 + 2mn
   *     = 2m(m + n)
   *
   * よって、lの最大値をLとすると、l &le; L を満たす全てのm,nと、あるlについて整数倍したものの
   * 総数が求める値となる。
   *
   * ただし、l = 120 のように、複数のピタゴラス数で表現できてはいけないので、最終的に
   * 複数回出現した長さは排除しなければならない。
   *
   * また、mの範囲を考えると、
   *   l = 2m(m + n)
   * よりmの最大値はn = 1の場合で、
   *   l = 2m(m + 1)
   *   2m^2 + 2m - l = 0
   * を満たす2以上のmについて調べていけばよい。
   */
  def solve(l: Int): Long =
    from(2)
      .takeWhile { m => 2 * m * (m + 1) <= l }
      .flatMap { m =>
        from(if (m % 2 == 0) 1 else 2, 2)
          .takeWhile { _ < m }
          .withFilter { n => gcd(m, n) == 1 }
          .flatMap { n => from(1).map { _ * len(m, n).toLong }.takeWhile { _ <= l } }
          .filter { _ <= l }
      }
      .groupBy { l => l }
      .filter { case (_, ls) => ls.size == 1 }
      .size

}
