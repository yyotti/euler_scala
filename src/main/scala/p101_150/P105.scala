package project_euler

/**
 * Problem 105:
 * Let S(A) represent the sum of elements in set A of size n.
 * We shall call it a special sum set if for any two non-empty disjoint subsets, B and C, the following properties are true:
 *
 *    i. S(B) ≠ S(C); that is, sums of subsets cannot be equal.
 *   ii.If B contains more elements than C then S(B) &gt; S(C).
 *
 * For example, {81, 88, 75, 42, 87, 84, 86, 65} is not a special sum set because 65 + 87 + 88 = 75 + 81 + 84,
 * whereas {157, 150, 164, 119, 79, 159, 161, 139, 158} satisfies both rules for all possible subset pair combinations
 * and S(A) = 1286.
 *
 * Using sets.txt (right click and "Save Link/Target As..."), a 4K text file with one-hundred sets containing seven to twelve elements
 * (the two examples given above are the first two sets in the file), identify all the special sum sets, A1, A2, ..., Ak,
 * and find the value of S(A1) + S(A2) + ... + S(Ak).
 *
 * NOTE: This problem is related to Problem 103 and Problem 106.
 *
 * 問題 105:
 * 大きさ n の集合 A の要素の和を S(A) で表す.
 * 空でなく共通要素を持たないいかなる 2 つの部分集合 B と C に対しても以下の性質が真であれば, A を特殊和集合と呼ぼう.
 *
 *  i. S(B) ≠ S(C); つまり, 部分集合の和が等しくてはならない.
 * ii. B が C より多くの要素を含んでいればこのとき S(B) &gt; S(C) となる.
 *
 * たとえば, {81, 88, 75, 42, 87, 84, 86, 65} は, 65 + 87 + 88 = 75 + 81 + 84 であるため特殊和集合ではないが,
 * {157, 150, 164, 119, 79, 159, 161, 139, 158} はすべての可能な部分集合の対の組み合わせについて両方のルールを満たしており,
 * また S(A) = 1286 である.
 *
 * 7 から 12 の要素を含む 100 個の集合が記された 4K のテキストファイル sets.txt (右クリックして "名前をつけてリンク先を保存")
 * を用いて (上の二例はファイルの最初の 2 集合である), 特殊和集合 A1, A2, ... , Ak をすべて特定し, S(A1) + S(A2) + ... + S(Ak) を求めよ.
 *
 * 注意: この問題は Problem 103 と 106 に関連している.
 */
object P105 {
  import commons._

  def validate(nums: List[Int]): Boolean =
    (1 to nums.size / 2)
      .flatMap { r =>
        nums.combinations(r)
          .flatMap { n =>
            (r to nums.size - n.size).flatMap { k =>
              nums.diff(n).combinations(k).map { ls => (n, ls) }
            }
          }
      }
      .forall { case (ls1, ls2) =>
        val sA = ls1.sum
        val sB = ls2.sum
        sA != sB && (ls1.size >= ls2.size || sA < sB)
      }

  /**
   * 全ての部分集合のペアを作って全チェック
   */
  def solve: Long =
    withSource(io.Source.fromFile(new java.io.File("src/main/resources/p105_sets.txt"))) { src =>
      src
        .getLines
        .map { _.split(",").map { _.toInt }.toList.sorted }
        .withFilter { nums => validate(nums) }
        .map { _.sum }
        .sum
    }
}
