package project_euler

/**
 * Problem 98:
 * By replacing each of the letters in the word CARE with 1, 2, 9, and 6 respectively, we form a square number: 1296 = 36^2.
 * What is remarkable is that, by using the same digital substitutions, the anagram, RACE, also forms a square number: 9216 = 96^2.
 * We shall call CARE (and RACE) a square anagram word pair and specify further that leading zeroes are not permitted,
 * neither may a different letter have the same digital value as another letter.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words,
 * find all the square anagram word pairs (a palindromic word is NOT considered to be an anagram of itself).
 *
 * What is the largest square number formed by any member of such a pair?
 *
 * NOTE: All anagrams formed must be contained in the given text file.
 *
 * 問題 98:
 * CARE という単語の各文字をそれぞれ 1, 2, 9, 6 に置き換えることによって, 平方数 1296 = 36^2 ができる.
 * 注目すべきことに, 同じ数字の置換をつかうことにより, アナグラムの RACE も平方数 9216 = 96^2 をつくる.
 * CARE (と RACE) を平方アナグラム単語対と呼ぼう. 先頭のゼロは許されず, 異なる文字が同じ数字をもつこともないとする.
 *
 * 約 2,000 個の一般的な英単語を含む 16K のテキストファイルfilewords.txt (右クリックして "名前をつけてリンク先を保存") を用いて,
 * 平方アナグラム単語対をすべて求めよ (回文となる単語はそれ自身のアナグラムとはみなさない).
 *
 * そのような対のメンバーから作られる最大の平方数は何か?
 *
 * 注: 作られるアナグラムは, すべて与えられたテキストファイルに含まれている.
 */
object P098 {
  import commons._

  val squares = Stream.from(1).map { n => digits(n * n) }

  def findMaxSquareNums(words: List[String]): List[Int] = words match {
    case Nil => Nil
    case x :: Nil => Nil
    case x :: y :: _ =>
      val nums = squares.dropWhile { _.length < x.length }.takeWhile { _.length == x.length }
      nums
        .map { ns => x.zip(ns).toMap }
        .filter { map => map.values.toList.distinct.size == map.size }
        .map { map => (x.map { c => map(c) }, y.map { c => map(c) }) }
        .withFilter { case (n1, n2) => nums.contains(n2) }
        .map { case (n1, n2) => n1.mkString.toInt.max(n2.mkString.toInt) }
        .toList
        .distinct
  }

  /**
   * まずテキスト中の全ての単語を読み込み、アナグラムになっているものをまとめる。
   * それぞれの組について、下記の操作で平方アナグラム単語対を検索する。
   *   1. 組の中から2つの単語を選択する。
   *   2. 選択した単語の一方に、単語の長さと同じ桁数をもつ平方数を1つ割り当てる。
   *   3. 平方数の桁を単語の1文字に対応させ割り振る。
   *   4. もう一方の単語を数字に変換する。
   *   5. 4で変換した数字も平方数であれば、大きいほうの数を記録する。
   * この操作で得られた平方数のうち、最も大きい数字を結果とする。
   */
  def solve: Long =
    fromFileToString(new java.io.File("src/main/resources/p098_words.txt"))
      .split(",")
      .map { _.tail.init }
      .toList
      .groupBy { _.sorted }
      .withFilter { _._2.size > 1 }
      .flatMap { case (_, ls) => ls.combinations(2).toList.flatMap { ws => findMaxSquareNums(ws.toList) } }
      .max

}
