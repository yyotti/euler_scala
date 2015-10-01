package project_euler

/**
 * Problem 79:
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.
 *
 * The text file, keylog.txt, contains fifty successful login attempts.
 *
 * Given that the three characters are always asked for in order,
 * analyse the file so as to determine the shortest possible secret passcode of unknown length.
 *
 * 問題 79:
 * オンラインバンクで通常使われるsecurity methodは, パスコードからランダムに選んだ3文字をユーザーに要求するものである.
 *
 * たとえば, パスコードが531278のとき, 2番目, 3番目, 5番目の文字を要求されるかもしれない. このとき, 期待される答えは: 317 である.
 *
 * テキストファイルkeylog.txtには, ログインに成功した50回の試行が記録されている.
 *
 * 3つの文字が常に順番通りに要求されるとするとき, ファイルを分析して, 可能なパスコードのなかでもっとも短いものを見つけよ.
 */
object P079 {
  import commons._

  type PosMap = Map[Int, Set[Int]]

  def init(lines: List[List[Int]]) = {
    val chars = lines.flatten.toSet
    chars.map { c => (c -> Seq.range(0, chars.size).toSet) }.toMap
  }

  def dropHead(c: Int, min: Int, nums: PosMap) = nums + (c -> nums(c).filter { _ > min })

  def dropTail(c: Int, max: Int, nums: PosMap) = nums + (c -> nums(c).filter { _ < max })

  def dropBoth(c: Int, min: Int, max: Int, nums: PosMap) = dropHead(c, min, dropTail(c, max, nums))

  def apply(c: Int, nums: PosMap) = {
    val pos = nums(c).head
    nums.map { case (k, set) => if (k == c) (k, set) else (k, set - pos) }
  }

  def squeezeHead(cs: List[Int], nums: PosMap) =
    cs.tail.foldLeft((cs.head, nums)) { case ((a, ns), b) => (b, dropHead(b, ns(a).min, ns)) }._2

  def squeezeTail(cs: List[Int], nums: PosMap) = {
    val (h :: ts) = cs.reverse
    ts.foldLeft((h, nums)) { case ((a, ns), b) => (b, dropTail(b, ns(a).max, ns)) }._2
  }

  def dropNums(line: List[Int], nums: PosMap) = {
    val (a :: b :: c :: _) = line
    squeezeTail(line, squeezeHead(line, dropHead(c, 1, dropBoth(b, 0, nums.size - 1, dropTail(a, nums.size - 2, nums)))))
  }

  def analyze(lines: List[List[Int]], nums: PosMap) = {
    val analyzed = lines.foldLeft(nums) { case (ns, line) => dropNums(line, ns) }
    analyzed
      .filter { case (_, pos) => pos.size == 1 }
      .foldLeft(analyzed) { case (ns, (c, _)) => apply(c, ns) }
  }

  /**
   * keylog.txtの中身から、求めるパスコードは全て数字で構成されているとみなしてよい。
   * また、同じ数字が2回出現している行が存在しないので、各数字は1度ずつしか使われていない。
   * よって、求めるパスコードの桁数は、3桁以上9桁以下である。
   *
   * 上記を前提に、下記の手順で各数字の位置を絞っていく。
   *
   * まずテキストの中に出現する数字を全て見て、1度も出現していない数字の個数をカウントする。
   * その個数をkとすると、求めるパスコードの桁数は(9 - k)桁である。
   *
   * その後、0から9の各数字について、位置の候補を設定する。(1度も出現しない数字は除く)
   *   0 → [0, 1, 2, ... , (9 - k - 1)]
   *   1 → [0, 1, 2, ... , (9 - k - 1)]
   *   2 → [0, 1, 2, ... , (9 - k - 1)]
   *   4 → [0, 1, 2, ... , (9 - k - 1)]
   *   5 → [0, 1, 2, ... , (9 - k - 1)]
   *   6 → [0, 1, 2, ... , (9 - k - 1)]
   *   8 → [0, 1, 2, ... , (9 - k - 1)]
   *   9 → [0, 1, 2, ... , (9 - k - 1)]
   *   ※3と7が一度も出現していない場合の例。k = 2なので、位置候補の末尾は 9 - 2 - 1 = 6 である。
   *
   * keylog.txtのコードを1行ずつ読みながら、下記の手順で候補を消していく。
   * コードの1桁ずつをabcとすると、
   * 1. aの数字の位置候補から、[(9 - k - 2), (9 - k - 1)]を削除する(aが末尾もしくは末尾の1つ前に存在することはないため)
   * 2. bの数字の位置候補から、[0, (9 - k - 1)]を削除する(bが先頭もしくは末尾に存在することはないため)
   * 3. cの数字の位置候補から、[0, 1]を削除する(bが先頭もしくは末尾に存在することはないため)
   * 4. bの数字の位置候補から、cの数字の位置候補の最大値以上の位置を削除する(bがcより後ろに存在することはないため)
   * 5. aの数字の位置候補から、bの数字の位置候補の最大値以上の位置を削除する(aがbより後ろに存在することはないため)
   * 6. bの数字の位置候補から、aの数字の位置候補の最小値以下の位置を削除する(bがaより前に存在することはないため)
   * 7. cの数字の位置候補から、bの数字の位置候補の最小値以下の位置を削除する(cがbより前に存在することはないため)
   * 8. 位置pが確定した数字iがあれば、i以外の数字の位置候補からpを削除する
   */
  def solve: Long = {
    val lines = withSource(io.Source.fromFile(new java.io.File("src/main/resources/p079_keylog.txt"))) { src =>
      src.getLines.toList.map { line => line.toList.map { _.asDigit } }
    }

    val analyzed = analyze(lines, init(lines))
    if (analyzed.forall { _._2.size == 1 }) analyzed.toList.sortBy { _._2.head }.map { _._1 }.mkString.toLong
    else -1
  }
}
