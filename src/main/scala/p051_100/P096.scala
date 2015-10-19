package project_euler

/**
 * Problem 96:
 * Su Doku (Japanese meaning number place) is the name given to a popular puzzle concept.
 * Its origin is unclear, but credit must be attributed to Leonhard Euler who invented a similar, and much more difficult, puzzle idea called Latin Squares.
 * The objective of Su Doku puzzles, however, is to replace the blanks (or zeros) in a 9 by 9 grid in such that each row, column,
 * and 3 by 3 box contains each of the digits 1 to 9. Below is an example of a typical starting puzzle grid and its solution grid.
 *
 * 0 0 3  0 2 0  6 0 0      4 8 3  9 2 1  6 5 7
 * 9 0 0  3 0 5  0 0 1      9 6 7  3 4 5  8 2 1
 * 0 0 1  8 0 6  4 0 0      2 5 1  8 7 6  4 9 3
 *
 * 0 0 8  1 0 2  9 0 0      5 4 8  1 3 2  9 7 6
 * 7 0 0  0 0 0  0 0 8      7 2 9  5 6 4  1 3 8
 * 0 0 6  7 0 8  2 0 0      1 3 6  7 9 8  2 4 5
 *
 * 0 0 2  6 0 9  5 0 0      3 7 2  6 8 9  5 1 4
 * 8 0 0  2 0 3  0 0 9      8 1 4  2 5 3  7 6 9
 * 0 0 5  0 1 0  3 0 0      6 9 5  4 1 7  3 8 2
 *
 * A well constructed Su Doku puzzle has a unique solution and can be solved by logic, although it may be necessary to employ "guess and test"
 * methods in order to eliminate options (there is much contested opinion over this).
 * The complexity of the search determines the difficulty of the puzzle;
 * the example above is considered easy because it can be solved by straight forward direct deduction.
 *
 * The 6K text file, sudoku.txt (right click and 'Save Link/Target As...'), contains fifty different Su Doku puzzles ranging in difficulty,
 * but all with unique solutions (the first puzzle in the file is the example above).
 *
 * By solving all fifty puzzles find the sum of the 3-digit numbers found in the top left corner of each solution grid;
 * for example, 483 is the 3-digit number found in the top left corner of the solution grid above.
 *
 * 問題 96:
 * "数独"(日本語で数字を配置するという意味)とは人気があるパズルの名前である.
 * 起源は不明だが, その評判はラテン語で"Squares"と呼ばれる同様な, そしてはるかに難しいパズルを考案した レオンハルト・オイラーの貢献によるものに違いない.
 * しかしながら, "数独"パズルの目的は それぞれの行, 列が3×3の枠を含む9×9の格子の空白（もしくは0）をそれぞれ1から9の数字で置き換えることである.
 * 下に, 一般的なパズルの開始状態とその解答の例がある.
 *
 * 0 0 3  0 2 0  6 0 0      4 8 3  9 2 1  6 5 7
 * 9 0 0  3 0 5  0 0 1      9 6 7  3 4 5  8 2 1
 * 0 0 1  8 0 6  4 0 0      2 5 1  8 7 6  4 9 3
 *
 * 0 0 8  1 0 2  9 0 0      5 4 8  1 3 2  9 7 6
 * 7 0 0  0 0 0  0 0 8      7 2 9  5 6 4  1 3 8
 * 0 0 6  7 0 8  2 0 0      1 3 6  7 9 8  2 4 5
 *
 * 0 0 2  6 0 9  5 0 0      3 7 2  6 8 9  5 1 4
 * 8 0 0  2 0 3  0 0 9      8 1 4  2 5 3  7 6 9
 * 0 0 5  0 1 0  3 0 0      6 9 5  4 1 7  3 8 2
 *
 * うまく作られている"数独"パズルは, 選択肢を消去するために"仮定とテスト"方式を用いる必要があるかもしれないが, ただ一つの解を持ち,
 * 論理によって解くことができる(これについては様々な意見がある).
 *
 * 探索の複雑さがパズルの難易度を決定する; 上に挙げた例は, 単純で直接的な推論によって解く事ができるため, 簡単であると考えられる.
 *
 * 6kバイトのテキストファイルfilesudoku.txt(右クリックで,"名前をつけてリンク先を保存") にはただ一つの解を持つ,
 * 様々な難易度の50の"数独"パズルが含まれている(上の例題はこのファイルにおける最初のパズルである).
 *
 * 50すべてのパズルを解き, それぞれの解答の左上隅にある3桁の数の合計を求めよ; 例えば483は上の解答例の左上隅の3桁の数である.
 */
object P096 {
  import commons._

  val B_SIZE = 3
  val SIZE = B_SIZE * B_SIZE

  type Field = Array[Either[Set[Int], Int]]

  def rowIndices(index: Int) = {
    val start = (index / SIZE) * SIZE
    (start until (start + SIZE))
  }

  def colIndices(index: Int) = {
    val start = index % SIZE
    (start until (start + SIZE * SIZE) by SIZE)
  }

  def blockIndices(index: Int) = {
    val (startI, startJ) = ((index / SIZE) / B_SIZE, (index % SIZE) / B_SIZE)
    (0 until B_SIZE)
      .flatMap { i => (0 until B_SIZE).map { j => (startI * B_SIZE + i) * SIZE + (startJ * B_SIZE + j) } }
  }

  def decide(field: Field, index: Int, n: Int) = {
    def decideRows(field: Field) =
      rowIndices(index).foldLeft(field) { (f, i) =>
        f(i) match {
          case Left(set) => f.updated(i, Left(set - n))
          case _ => f
        }
      }
    def decideCols(field: Field) =
      colIndices(index).foldLeft(field) { (f, i) =>
        f(i) match {
          case Left(set) => f.updated(i, Left(set - n))
          case _ => f
        }
      }
    def decideBlocks(field: Field) =
      blockIndices(index).foldLeft(field) { (f, i) =>
        f(i) match {
          case Left(set) => f.updated(i, Left(set - n))
          case _ => f
        }
      }

    field(index) match {
      case Right(num) => field
      case Left(set) if !set.contains(n) => field
      case _ => decideRows(decideCols(decideBlocks(field))).updated(index, Right(n))
    }
  }

  def findDecidable(field: Field): Option[Int] = {
    val index = field.indexWhere {
      case Left(set) if set.size == 1 => true
      case _ => false
    }

    if (index >= 0) Some(index)
    else None
  }

  def findMinNumsIndex(field: Field): Int =
    field
      .zipWithIndex
      .filter { _._1.isLeft }
      .minBy { case (p, _) => p.left.get.size }
      ._2

  def isCompleted(field: Field) = field.forall { _.isRight }

  def findAnswers(field: Field): Set[Field] =
    if (isCompleted(field)) Set(field)
    else findDecidable(field) match {
      case Some(index) => findAnswers(decide(field, index, field(index).left.get.head))
      case _ =>
        val minNumsIndex= findMinNumsIndex(field)
        field(minNumsIndex) match {
          case Left(set) if set.isEmpty => Set.empty // 解なし
          case Left(set) => set.flatMap { n => findAnswers(decide(field, minNumsIndex, n)) }
          case _ => Set.empty // ここには入らないけど
        }
    }

  def initField(lines: Seq[String]) =
    lines
      .mkString
      .zipWithIndex
      .foldLeft(Array.fill[Either[Set[Int], Int]](SIZE * SIZE) { Left((1 to SIZE).toSet) }) { case (f, (c, i)) => if (c == '0') f else decide(f, i, c.asDigit) }

  def solveNPs(problems: Seq[Seq[String]]) =
    problems
      .map { p => findAnswers(initField(p)) }
      .withFilter { answers => answers.size == 1 }
      .map { _.head.map { _.right.get } }

  def solve: Long = {
    val problems =
      withSource(io.Source.fromFile(new java.io.File("src/main/resources/p096_sudoku.txt"))) { src =>
        src.getLines.toList.grouped(SIZE + 1).map { _.tail }.toSeq
      }

    solveNPs(problems).map { _.take(3).mkString.toInt }.sum
  }
}
