package project_euler

/**
 * Problem 106:
 * Let S(A) represent the sum of elements in set A of size n.
 * We shall call it a special sum set if for any two non-empty disjoint subsets, B and C, the following properties are true:
 *
 *    i. S(B) ≠ S(C); that is, sums of subsets cannot be equal.
 *   ii.If B contains more elements than C then S(B) &gt; S(C).
 *
 * For this problem we shall assume that a given set contains n strictly increasing elements and it already satisfies the second rule.
 *
 * Surprisingly, out of the 25 possible subset pairs that can be obtained from a set for which n = 4,
 * only 1 of these pairs need to be tested for equality (first rule).
 * Similarly, when n = 7, only 70 out of the 966 subset pairs need to be tested.
 *
 * For n = 12, how many of the 261625 subset pairs that can be obtained need to be tested for equality?
 *
 * NOTE: This problem is related to Problem 103 and Problem 105.
 *
 * 問題 106:
 * 大きさ n の集合 A の要素の和を S(A) で表す.
 * 空でなく共通要素を持たないいかなる 2 つの部分集合 B と C に対しても以下の性質が真であれば, A を特殊和集合と呼ぼう.
 *
 *  i. S(B) ≠ S(C); つまり, 部分集合の和が等しくてはならない.
 * ii. B が C より多くの要素を含んでいればこのとき S(B) &gt; S(C) となる.
 *
 * 本問題に対しては, 与えられた集合は n 個の単調増加する要素を含み, かつ第二のルールをすでに満たしているものと仮定しよう.
 *
 * 驚くべきことに, n = 4 の集合から得ることができる 25 個の可能な部分集合の対のうち,
 * 1 個の対のみが 同一性（第一のルール）をテストされる必要がある.
 * 同様に, n = 7 のときは, 966 個の部分集合の対のうち 70 個のみがテストされる必要がある.
 *
 * n = 12 に対して, 得られる 261625 個の部分集合の対のうち, 同一性をテストされる必要があるものは何個か.
 *
 * 注意: この問題は Problem 103 と 105 に関連している.
 */
object P106 {
  def countValidateRequires(nums: List[Int]): Long =
    (1 to nums.size / 2)
      .flatMap { r =>
        nums.combinations(r)
          .flatMap { n =>
            (r to nums.size - n.size).flatMap { k =>
              nums.diff(n).combinations(k).map { ls => (n, ls) }
            }
          }
      }
      .count { case (ls1, ls2) =>
        ls1.size == ls2.size && ls1.zip(ls2).map { case (a, b) => if (a < b) -1 else 1 }.sum.abs != ls1.size
      }

  /**
   * 条件iiを満たしているわけなので、BとCの要素数が異なる場合は考えなくてよい。
   * よってBとCの要素数が等しい場合についてのみ考える。
   *
   * 要素数をkとする。
   * k = 1の場合は要素同士を比較すればよいが、もともと各要素は異なっているので考えなくてよい。
   * よって k &ge; 2 の場合を考える。
   *
   * 集合内の要素を昇順にソートし、先頭から順に a1, a2, ..., an とする。
   * 大きさkの部分集合どうしを比較する。
   * 一方の集合に含まれる全ての要素がもう一方の集合の要素の最小値より小さい場合は、和が等しく
   * なる可能性はない。
   * また、部分集合の一方を {b1, b2, ..., bk} 、もう一方を {c1, c2, ..., ck} としたとき、
   *   ci &ge; bi   (1 &le; i &le; k)
   * が常に成立するなら、我が等しくなることはない。
   *
   * よって、上記が成立しない場合をチェックすればよい。
   *
   * 今回は、チェックが必要なパターンの数を求めればよいので、具体的な集合でなくとも
   *   {1, 2, 3, ..., n}
   * で考えても同じ結果が得られる。
   */
  def solve(n: Int): Long = countValidateRequires((1 to n).toList) / 2
}
