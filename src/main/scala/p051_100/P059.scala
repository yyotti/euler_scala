package project_euler

/**
 * Problem 59:
 * Each character on a computer is assigned a unique code and the preferred standard is ASCII (American Standard Code for Information Interchange).
 * For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 *
 * A modern encryption method is to take a text file, convert the bytes to ASCII, then XOR each byte with a given value, taken from a secret key.
 * The advantage with the XOR function is that using the same encryption key on the cipher text, restores the plain text;
 * for example, 65 XOR 42 = 107, then 107 XOR 42 = 65.
 *
 * For unbreakable encryption, the key is the same length as the plain text message, and the key is made up of random bytes.
 * The user would keep the encrypted message and the encryption key in different locations, and without both "halves",
 * it is impossible to decrypt the message.
 *
 * Unfortunately, this method is impractical for most users, so the modified method is to use a password as a key.
 * If the password is shorter than the message, which is likely, the key is repeated cyclically throughout the message.
 * The balance for this method is using a sufficiently long password key for security, but short enough to be memorable.
 *
 * Your task has been made easy, as the encryption key consists of three lower case characters.
 * Using cipher.txt (right click and 'Save Link/Target As...'), a file containing the encrypted ASCII codes,
 * and the knowledge that the plain text must contain common English words, decrypt the message and find the sum of the ASCII values in the original text.
 *
 * 問題 59:
 * (訳者注: 文字コードの説明は適当です) 各文字はそれぞれ一意のコードに割り当てられている.
 * よく使われる標準としてASCII (American Standard Code for Information Interchange) がある.
 * ASCIIでは, 大文字A = 65, アスタリスク (*) = 42, 小文字k = 107というふうに割り当てられている.
 *
 * モダンな暗号化の方法として, テキストファイルの各バイトをASCIIに変換し, 秘密鍵から計算された値とXORを取るという手法がある.
 * XOR関数の良い点は, 暗号化に用いたのと同じ暗号化鍵でXORを取ると平文を復号できる点である. 65 XOR 42 = 107であり, 107 XOR 42 = 65である.
 *
 * 破られない暗号化のためには, 鍵は平文と同じ長さのランダムなバイト列でなければならない. ユーザーは暗号文と暗号化鍵を別々の場所に保存する必要がある.
 * また, もし一方が失われると, 暗号文を復号することは不可能になる.
 *
 * 悲しいかな, この手法はほとんどのユーザーにとって非現実的である. そこで, 鍵の変わりにパスワードを用いる手法が用いられる.
 * パスワードが平文より短ければ (よくあることだが), パスワードは鍵として繰り返し用いられる.
 * この手法では, 安全性を保つために十分長いパスワードを用いる必要があるが, 記憶するためにはある程度短くないといけない.
 *
 * この問題での課題は簡単になっている. 暗号化鍵は3文字の小文字である. cipher1.txtは暗号化されたASCIIのコードを含んでいる.
 * また, 平文はよく用いられる英単語を含んでいる. この暗号文を復号し, 平文のASCIIでの値の和を求めよ.
 */
object P059 {
  import commons._

  def findPassword(str: String, passwordLength: Int): String =
    new String(
      str
        .split(",")
        .map { _.toByte }
        .grouped(passwordLength)
        .filter { _.size == passwordLength }
        .toArray
        .transpose
        .map { ls => (ls.groupBy { b => b }.map { case (b, ls) => (b, ls.size) }.maxBy { _._2 }._1 ^ ' ').toByte }
    )

  def decrypt(str: String, pw: String): String =
    new String(
      str
        .split(",")
        .map { _.toByte }
        .grouped(pw.length)
        .flatMap { ls => ls.zip(pw).map { case (n, p) => (n ^ p).toByte } }
        .toArray
    )

  /**
   * まず3文字のパスワードを特定する。その3文字を p1,p2,p3 とする。
   * テキスト内の数列を3項ずつで分割すると、
   *   [79,59,12],[2,79,35],[8,28,20],[2,3,68],[8,9,68],[45,0,12],[9,67,68],[4,7,5],[23,27,1],[21...
   * となる。分割されたそれぞれの組のうち、先頭の数字はp1で、2番目の数字はp2で、3番目の数字はp3で暗号化
   * されているはずである。
   * よって、分割された組の先頭のみを拾って新たな数列 g1 を生成すると
   *   g1 = 79, 2, 8, 2, 8, 45, 9, 4, 23, 21, ...
   * となる。同様に、2番目の数字を拾って g2、3番目の数字を拾って g3 とすると、
   *   g2 = 59, 79, 28, 3, 9, 0, 67, 7, 27, ...
   *   g3 = 12, 35, 20, 68, 68, 12, 68, 5, 1, ...
   * になる。
   *
   * さらに、g1,g2,g3 の中での各数字の出現回数をカウントし、出現頻度の高い順に並べた数列をそれぞれ h1,h2,h3 とすると、
   *   h1 = 71, 2, 19, ...
   *   h2 = 79, 7, 10, ...
   *   h3 = 68, 1, 16, ...
   * となる。
   * 平文は英文であることを前提とすると、最も出現頻度が高いASCII文字は半角スペースであると予想できるので、
   * h1,h2,h3の初項は全て、暗号化された半角スペースであると考えられる。
   * 半角スペースのASCIIコードは 32 であるから、
   *   71^p1 = 32
   *   79^p2 = 32
   *   68^p3 = 32
   *   (^ はxor演算子)
   * を解くと、パスワードが求められる。(解いたら god となった)
   *
   * パスワードが求められれば、テキストを復号してASCII和を求めればよい。
   */
  def solve: Long = {
    val str = fromFileToString(new java.io.File("src/main/resources/p059_cipher.txt"))
    decrypt(str, findPassword(str, 3)).map { _.toInt }.sum
  }
}
