package project_euler

/**
 * Problem 103:
 * Let S(A) represent the sum of elements in set A of size n.
 * We shall call it a special sum set if for any two non-empty disjoint subsets, B and C, the following properties are true:
 *
 *    i. S(B) ≠ S(C); that is, sums of subsets cannot be equal.
 *   ii.If B contains more elements than C then S(B) &gt; S(C).
 *
 * If S(A) is minimised for a given n, we shall call it an optimum special sum set. The first five optimum special sum sets are given below.
 *
 * n = 1: {1}
 * n = 2: {1, 2}
 * n = 3: {2, 3, 4}
 * n = 4: {3, 5, 6, 7}
 * n = 5: {6, 9, 11, 12, 13}
 *
 * It seems that for a given optimum set, A = {a1, a2, ... , an}, the next optimum set is of the form B = {b, a1+b, a2+b, ... ,an+b},
 * where b is the "middle" element on the previous row.
 *
 * By applying this "rule" we would expect the optimum set for n = 6 to be A = {11, 17, 20, 22, 23, 24}, with S(A) = 117.
 * However, this is not the optimum set, as we have merely applied an algorithm to provide a near optimum set.
 * The optimum set for n = 6 is A = {11, 18, 19, 20, 22, 25}, with S(A) = 115 and corresponding set string: 111819202225.
 *
 * Given that A is an optimum special sum set for n = 7, find its set string.
 *
 * NOTE: This problem is related to Problem 105 and Problem 106.
 *
 * 問題 103:
 * 大きさ n の集合 A の要素の和を S(A) で表す.
 * 空でなく共通要素を持たないいかなる 2 つの部分集合 B と C に対しても以下の性質が真であれば, A を特殊和集合と呼ぼう.
 *
 *  i. S(B) ≠ S(C); つまり, 部分集合の和が等しくてはならない.
 * ii. B が C より多くの要素を含んでいればこのとき S(B) &gt; S(C) となる.
 *
 * ある n に対し S(A) が最小化されていれば, それを最適特殊和集合と呼ぼう. はじめの 5 つの最適特殊和集合は下に与えられる.
 *
 * n = 1: {1}
 * n = 2: {1, 2}
 * n = 3: {2, 3, 4}
 * n = 4: {3, 5, 6, 7}
 * n = 5: {6, 9, 11, 12, 13}
 *
 * ある最適集合 A = {a1, a2, ... , an} に対し, 次の最適集合は B = {b, a1+b, a2+b, ... ,an+b} となりそうである. ここで b は前列の「中央の」要素である.
 *
 * この「法則」を用いると n = 6 に対する最適集合は A = {11, 17, 20, 22, 23, 24} で, S(A) = 117 と予期するだろう.
 * しかしこれは, 最適に近い集合を与えるアルゴリズムを用いたにすぎないため, 最適集合とはならない.
 * n = 6 に対する最適集合は A = {11, 18, 19, 20, 22, 25} で, S(A) = 115 である. これに対応する集合の文字列は 111819202225 である.
 *
 * A を n = 7 に対する最適特殊集合とするとき, その集合の文字列を求めよ.
 *
 * 注意: この問題は Problem 105 と 106 に関連している.
 */
object P103 {
  def solve(n: Int): Long = ???
}
