package project_euler

/**
 * Problem 88:
 * A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers,
 * {a1, a2, ... , ak} is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.
 *
 * For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.
 *
 * For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number.
 * The minimal product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.
 *
 * k=2: 4 = 2 × 2 = 2 + 2
 * k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
 * k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
 * k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
 * k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6
 *
 * Hence for 2≤k≤6, the sum of all the minimal product-sum numbers is 4+6+8+12 = 30; note that 8 is only counted once in the sum.
 *
 * In fact, as the complete set of minimal product-sum numbers for 2≤k≤12 is {4, 6, 8, 12, 15, 16}, the sum is 61.
 *
 * What is the sum of all the minimal product-sum numbers for 2≤k≤12000?
 *
 * 問題 88:
 * 少なくとも2つの自然数 {a1, a2, ... , ak} の集合の和かつ積として表せる自然数Nを積和数と呼ぶ：N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.
 *
 * 例えば, 6 = 1 + 2 + 3 = 1 × 2 × 3.
 *
 * ある集合の大きさ k に対して,この性質を持つ最小の N を最小積和数と呼ぼう. 集合の大きさ k = 2, 3, 4, 5, 6 に対する最小積和数は次のとおりである.
 *
 * k=2: 4 = 2 × 2 = 2 + 2
 * k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
 * k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
 * k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
 * k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6
 *
 * したがって 2 ≤ k ≤ 6 に対して,全ての最小積和数の和は 4+6+8+12 = 30 である. 8 は和に一度だけカウントされていることに気をつけよう.
 *
 * 実際, 2 ≤ k ≤ 12 に対する最小積和数の完全な集合は {4, 6, 8, 12, 15, 16} なので,その和は 61 である.
 *
 * 2 ≤ k ≤ 12000 に対する全ての最小積和数の和は何か?
 */
object P088 {
  def solve(n: Int): Long = ???
}
