package project_euler

/**
 * Problem 69:
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of numbers less than n which are relatively prime to n.
 * For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, φ(9)=6.
 *
 * |n |Relatively Prime|φ(n)|n/φ(n)  |
 * |--|----------------|-----|---------|
 * |2 |1               |1    |2        |
 * |3 |1,2             |2    |1.5      |
 * |4 |1,3             |2    |2        |
 * |5 |1,2,3,4         |4    |1.25     |
 * |6 |1,5             |2    |3        |
 * |7 |1,2,3,4,5,6     |6    |1.1666...|
 * |8 |1,3,5,7         |4    |2        |
 * |9 |1,2,4,5,7,8     |6    |1.5      |
 * |10|1,3,7,9         |4    |2.5      |
 *
 * It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.
 *
 * Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
 *
 * 問題 69:
 * オイラーのトーティエント関数, φ(n) [時々ファイ関数とも呼ばれる]は, n と互いに素な n 未満の数の数を定める.
 * たとえば, 1, 2, 4, 5, 7, そして8はみな9未満で9と互いに素であり, φ(9)=6.
 *
 * |n |互いに素な数|φ(n)|n/φ(n)  |
 * |--|------------|-----|---------|
 * |2 |1           |1    |2        |
 * |3 |1,2         |2    |1.5      |
 * |4 |1,3         |2    |2        |
 * |5 |1,2,3,4     |4    |1.25     |
 * |6 |1,5         |2    |3        |
 * |7 |1,2,3,4,5,6 |6    |1.1666...|
 * |8 |1,3,5,7     |4    |2        |
 * |9 |1,2,4,5,7,8 |6    |1.5      |
 * |10|1,3,7,9     |4    |2.5      |
 *
 * n ≤ 10 では n/φ(n) の最大値は n=6 であることがわかる.
 *
 * n ≤ 1,000,000で n/φ(n) が最大となる値を見つけよ.
 */
object P069 {
  def solve(n: Int): Long = ???
}
