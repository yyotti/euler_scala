package project_euler

/**
 * Problem 93:
 * By using each of the digits from the set, {1, 2, 3, 4}, exactly once,
 * and making use of the four arithmetic operations (+, −, *, /) and brackets/parentheses,
 * it is possible to form different positive integer targets.
 *
 * For example,
 *
 * 8 = (4 * (1 + 3)) / 2
 * 14 = 4 * (3 + 1 / 2)
 * 19 = 4 * (2 + 3) − 1
 * 36 = 3 * 4 * (2 + 1)
 *
 * Note that concatenations of the digits, like 12 + 34, are not allowed.
 *
 * Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the maximum,
 * and each of the numbers 1 to 28 can be obtained before encountering the first non-expressible number.
 *
 * Find the set of four distinct digits, a ＜ b ＜ c ＜ d, for which the longest set of consecutive positive integers,
 * 1 to n, can be obtained, giving your answer as a string: abcd.
 *
 * 問題 93:
 * 集合 {1, 2, 3, 4} の各数字をちょうど一度用い, また四則演算 (+, －, *, /) と括弧を使うことにより, 異なる正の整数を作ることができる.
 *
 * 例えば,
 *
 * 8 = (4 * (1 + 3)) / 2
 * 14 = 4 * (3 + 1 / 2)
 * 19 = 4 * (2 + 3) － 1
 * 36 = 3 * 4 * (2 + 1)
 *
 * 12 + 34 のように数字をつなげることは許されないことに注意しよう.
 *
 * 集合 {1, 2, 3, 4} を使うと, 36 を最大とする 31 個の異なる数が得られる. 最初の表現できない数に会うまで, 1 から 28 の各数を得ることができる.
 *
 * 最長の連続した正の整数 1 から n の集合を得ることができる, 4 つの異なる数字 a ＜ b ＜ c ＜ d を見つけよ. 答えを文字列 abcd として与えよ.
 */
object P093 {

  sealed abstract class FormulaElement {
    val priority = -1
  }
  sealed abstract class Operator extends FormulaElement
  case class Expr(ex: Expr) extends FormulaElement
  case object ParenthesisS extends FormulaElement
  case object ParenthesisE extends FormulaElement

  case class Num(value: Int) extends FormulaElement
  case object Plus extends Operator { override val priority = 0 }
  case object Minus extends Operator { override val priority = 0 }
  case object Times extends Operator { override val priority = 1 }
  case object Div extends Operator { override val priority = 1 }

  val operators = List(Plus, Minus, Times, Div)

  def toRPN(formula: List[FormulaElement]): List[FormulaElement] = {
    def conv(formula: List[FormulaElement], buff: Seq[FormulaElement], stack: List[FormulaElement]): List[FormulaElement] = formula match {
      case Nil => (buff ++ stack).toList
      case Num(x) :: xs => conv(xs, buff :+ Num(x), stack)
      case ParenthesisE :: xs => conv(xs, buff ++ stack.takeWhile { _ != ParenthesisS }, stack.dropWhile { _ != ParenthesisS }.tail)
      case ParenthesisS :: xs => conv(xs, buff, ParenthesisS :: stack)
      case x :: xs if (stack.isEmpty) => conv(xs, buff, x :: stack)
      case x :: _ if (stack.head.priority >= x.priority) => conv(formula, buff :+ stack.head, stack.tail)
      case x :: xs => conv(xs, buff, x :: stack)
    }

    conv(formula, Seq.empty, Nil)
  }

  def calcRPN(formula: List[FormulaElement]): Double = {
    def calc(formula: List[FormulaElement], stack: List[Double]): Double = (formula, stack) match {
      case (Nil, _) => stack.head
      case (Num(x) :: xs, _) => calc(xs, x :: stack)
      case (Plus :: xs, m :: n :: ts) => calc(xs, (n + m) :: ts)
      case (Minus :: xs, m :: n :: ts) => calc(xs, (n - m) :: ts)
      case (Times :: xs, m :: n :: ts) => calc(xs, (n * m) :: ts)
      case (Div :: xs, m :: n :: ts) => calc(xs, (n.toDouble / m) :: ts)
      case _ => 0
    }

    calc(formula, Nil)
  }

  def insertOperators(nums: List[Num]): List[List[FormulaElement]] = nums match {
    case Nil => List(Nil)
    case n :: Nil => List(List(n))
    case n :: ns => operators.flatMap { op => insertOperators(ns).map { xs => n :: op :: xs } }
  }

  def addParenthesis(formula: List[FormulaElement]): List[List[FormulaElement]] = {
    def insertAt[FormulaElement](ls: List[FormulaElement], n: Int, elem: FormulaElement): List[FormulaElement] = (ls, n) match {
      case (_, 0) => elem :: ls
      case (Nil, _) => List(elem)
      case (x :: xs, n) => x :: insertAt(xs, n - 1, elem)
    }

    // パターンが少ないのでハードコーディング
    List(
      formula,
      insertAt(insertAt(formula, 0, ParenthesisS), 4, ParenthesisE),
      insertAt(insertAt(formula, 2, ParenthesisS), 6, ParenthesisE),
      insertAt(insertAt(formula, 4, ParenthesisS), 8, ParenthesisE),
      insertAt(insertAt(insertAt(insertAt(formula, 0, ParenthesisS), 4, ParenthesisE), 6, ParenthesisS), 10, ParenthesisE),
      insertAt(insertAt(formula, 0, ParenthesisS), 6, ParenthesisE),
      insertAt(insertAt(formula, 2, ParenthesisS), 8, ParenthesisE),
      insertAt(insertAt(insertAt(insertAt(formula, 0, ParenthesisS), 1, ParenthesisS), 5, ParenthesisE), 8, ParenthesisE),
      insertAt(insertAt(insertAt(insertAt(formula, 0, ParenthesisS), 3, ParenthesisS), 7, ParenthesisE), 8, ParenthesisE),
      insertAt(insertAt(insertAt(insertAt(formula, 2, ParenthesisS), 3, ParenthesisS), 7, ParenthesisE), 10, ParenthesisE),
      insertAt(insertAt(insertAt(insertAt(formula, 2, ParenthesisS), 5, ParenthesisS), 9, ParenthesisE), 10, ParenthesisE)
    )
  }

  def findN(nums: List[Int]): Int =
    nums
      .map { n => Num(n) }
      .permutations
      .toSeq
      .flatMap { ns =>
        insertOperators(ns).flatMap { formula =>
          addParenthesis(formula).map { f => calcRPN(toRPN(f)) }
        }
      }
      .filter { k => k > 0 && k.toInt == k }
      .sorted
      .distinct
      .zip(Stream.from(1))
      .takeWhile { case (n1, n2) => n1 == n2 }
      .size

  /**
   * 全パターンを網羅する場合を考える。
   *   9つの数字から4つを選ぶ場合の選び方： 9C4 = 126 通り
   *   4つの数字の並べ方： 4! = 24 通り
   *   4つの数字の間(3箇所)に4つの演算子を入れる場合の入れ方： 4^3 = 64 通り
   *   括弧で囲む場合の囲み方： 全く囲まない → 1通り
   *                            2つの数字を括弧で囲む → 4 通り
   *                            3つの数字を括弧で囲む → 2 通り
   *                            3つの数字を囲みつつその中の2つの数字を括弧で囲む → 4 通り
   *                            合計 11 通り
   * よってパターンの総数は 126 * 24 * 64 * 11 = 2,128,896 通りある。
   *
   * 手順は
   *   1. 9つの数字から4つを選択する
   *   2. 選択した数字と演算子、および括弧の組み合わせで生成できる正の整数を全て列挙し、重複を排除して小さい順に並べる。
   *   3. 1から始めて連続した整数がいくつまで生成できているかチェックし、最大値をnとする。1が生成できていない場合はn = 0とする。
   *   4. 最も大きなnを得られた4つの数字を小さい順に連結し、解とする。
   *
   * 括弧を含む演算があるので、式を逆ポーランド記法に変換して計算する。
   */
  def solve: String = (1 to 9).combinations(4).maxBy { ls => findN(ls.toList) }.mkString
}
