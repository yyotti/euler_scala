package project_euler

/**
 * Problem 22:
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * 問題 22:
 * 5000個以上の名前が書かれている46Kのテキストファイル filenames.txt を用いる. まずアルファベット順にソートせよ.
 *
 * のち, 各名前についてアルファベットに値を割り振り, リスト中の出現順の数と掛け合わせることで, 名前のスコアを計算する.
 *
 * たとえば, リストがアルファベット順にソートされているとすると, COLINはリストの938番目にある. またCOLINは 3 + 15 + 12 + 9 + 14 = 53 という値を持つ. よってCOLINは 938 × 53 = 49714 というスコアを持つ.
 *
 * ファイル中の全名前のスコアの合計を求めよ.
 */
object P022 {
  import commons._

  def solve: Long =
    fromFileToString(new java.io.File("src/main/resources/p022_names.txt"))
      .split(",")
      .map { s => s.trim.drop(1).init }
      .sorted
      .zipWithIndex
      .map { case (s, idx) => (idx + 1) * s.map { c => c - 'A' + 1 }.sum }
      .toList
      .sum
}
