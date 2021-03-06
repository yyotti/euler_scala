package project_euler

/**
 * Problem 89:
 * For a number written in Roman numerals to be considered valid there are basic rules which must be followed.
 * Even though the rules allow some numbers to be expressed in more than one way there is always a "best" way of writing a particular number.
 *
 * For example, it would appear that there are at least six ways of writing the number sixteen:
 *
 * IIIIIIIIIIIIIIII
 * VIIIIIIIIIII
 * VVIIIIII
 * XIIIIII
 * VVVI
 * XVI
 *
 * However, according to the rules only XIIIIII and XVI are valid, and the last example is considered to be the most efficient,
 * as it uses the least number of numerals.
 *
 * The 11K text file, roman.txt (right click and 'Save Link/Target As...'), contains one thousand numbers written in valid,
 * but not necessarily minimal, Roman numerals; see About... Roman Numerals for the definitive rules for this problem.
 *
 * Find the number of characters saved by writing each of these in their minimal form.
 *
 * Note: You can assume that all the Roman numerals in the file contain no more than four consecutive identical units.
 *
 * ==========
 * About... Roman Numerals
 * How do you read and write Roman numerals?
 *
 * Traditional Roman numerals are made up of the following denominations:
 *
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000
 *
 * In order for a number written in Roman numerals to be considered valid there are three basic rules which must be followed.
 *
 * Numerals must be arranged in descending order of size.
 * M, C, and X cannot be equalled or exceeded by smaller denominations.
 * D, L, and V can each only appear once.
 *
 * For example, the number sixteen could be written as XVI or XIIIIII, with the first being the preferred form as it uses the least number of numerals.
 * We could not write IIIIIIIIIIIIIIII because we are making X (ten) from smaller denominations,
 * nor could we write VVVI because the second and third rule are being broken.
 *
 * The "descending size" rule was introduced to allow the use of subtractive combinations.
 * For example, four can be written IV because it is one before five. As the rule requires that the numerals be arranged
 * in order of size it should be clear to a reader that the presence of a smaller numeral out of place, so to speak,
 * was unambiguously to be subtracted from the following numeral rather than added.
 *
 * For example, nineteen could be written XIX = X (ten) + IX (nine). Note also how the rule requires X (ten) be placed before IX (nine),
 * and IXX would not be an acceptable configuration (descending size rule). Similarly, XVIV would be invalid because V can only appear once in a number.
 *
 * Generally the Romans tried to use as few numerals as possible when displaying numbers.
 * For this reason, XIX would be the preferred form of nineteen over other valid combinations, like XIIIIIIIII or XVIIII.
 *
 * By mediaeval times it had become standard practice to avoid more than three consecutive identical numerals
 * by taking advantage of the more compact subtractive combinations.
 * That is, IV would be written instead of IIII, IX would be used instead of IIIIIIIII or VIIII, and so on.
 *
 * In addition to the three rules given above, if subtractive combinations are used then the following four rules must be followed.
 *
 *     i. Only one I, X, and C can be used as the leading numeral in part of a subtractive pair.
 *    ii. I can only be placed before V and X.
 *   iii. X can only be placed before L and C.
 *    iv. C can only be placed before D and M.
 *
 * Which means that IL would be considered to be an invalid way of writing forty-nine, and whereas XXXXIIIIIIIII, XXXXVIIII, XXXXIX, XLIIIIIIIII, XLVIIII,
 * and XLIX are all quite legitimate, the latter is the preferred (minimal) form.
 * However, minimal form was not a rule and there still remain in Rome many examples where economy of numerals has not been employed.
 * For example, in the famous Colosseum the numerals above the forty-ninth entrance is written XXXXVIIII rather than XLIX.
 *
 * It is also expected, but not required, that higher denominations should be used whenever possible;
 * for example, V should be used in place of IIIII, L should be used in place of XXXXX, and D should be used in place of CCCCC.
 * However, in the church of Sant'Agnese fuori le Mura (St Agnes' outside the walls), found in Rome, the date, MCCCCCCVI (1606),
 * is written on the gilded and coffered wooden ceiling; I am sure that many would argue that it should have been written MDCVI.
 *
 * So if we believe the adage, "when in Rome do as the Romans do," and we see how the Romans write numerals,
 * then it clearly gives us much more freedom than many would care to admit.
 *
 * 問題 89:
 * ローマ数字の記法は一つの数について沢山ある場合が存在する (FAQを見よ). しかし, ある数については最良の記法が必ず存在する.
 *
 * 例えば, 16の正しい記法を全て並べてみる.
 *
 * IIIIIIIIIIIIIIII
 * VIIIIIIIIIII
 * VVIIIIII
 * XIIIIII
 * VVVI
 * XVI
 *
 * 最後の例は, 最小の文字数で表せるという意味で, 最も効率が良い.
 *
 * 11Kのテキストファイルfileroman.txt は1000個のローマ記法で書かれた数を含んでいる.
 * これらは, 正しい記法に従っている. 即ち, 大きい数から順に書かれていて, 引き算ペアのルールにも従っている(このルールについてはFAQを見よ)
 * 但し, 最小の文字数で表されているとは限らない.
 *
 * 最小形で書いたときに, 何文字節約できるかを求めよ.
 *
 * 注: ファイル中の全てのローマ数字には, 5つ以上の同じ文字が連続して含まれることはない.
 * ==========
 * FAQ: ローマ数字のルール
 * (訳者:概略のみ与える)
 *
 * I V X   L   C   D   M
 * 1 5 10  50  100 500 1000
 * ↑
 * 基本法則1
 * 全ての文字はサイズの降順に並ぶ
 *
 * ↑
 * 基本法則2
 * 引き算ペアについて.
 *
 * X (10) + IX (9) として19=XIXと表せる. ただし, 8をIIXと二文字以上を引くことは許されない.
 *
 * 1. I, X, Cのみが引き算ペアの最初の文字として許される.
 * 2. IはVまたはXの前に来ることが許される
 * 3. XはLまたはCの前に来ることが許される
 * 4. CはDまたはMの前に来ることが許される
 */
object P089 {
  import commons._

  val replaces = List(
    ("DCCCC", "CM"),
    ("CCCC", "CD"),
    ("LXXXX", "XC"),
    ("XXXX", "XL"),
    ("VIIII", "IX"),
    ("IIII", "IV")
  )

  def savedLength(s: String) =
    s.length - replaces.foldLeft(s) { case (z, (r, t)) => z.replaceAll(r, t) }.length

  /**
   * 短くなる文字数が分かればよいので、最短表記がされていない部分を最短表記に置き換えて長さの差を取ればよい。
   * ただし、例えば"DCCCC"という文字列は"CM"と等価であるが、見方次第では"D CCCC" → "DCD" となってしまうので、
   * 置換の順番に注意しなければならない。
   *
   * また、最短表記ではないがルールに従って書かれているようなので、"IIIII" → "V" などの変換は行わなくてよい。
   */
  def solve: Long =
    withSource(io.Source.fromFile(new java.io.File("src/main/resources/p089_roman.txt"))) { src =>
      src.getLines.map { savedLength }.sum
    }

}
