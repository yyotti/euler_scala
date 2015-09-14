package project_euler

/**
 * Problem 53:
 * There are exactly ten ways of selecting three from five, 12345:
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general, nCr = n!/r!(n−r)! ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 *
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 *
 * 問題 53:
 * 12345から3つ選ぶ選び方は10通りである.
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, 345.
 *
 * 組み合わせでは, 以下の記法を用いてこのことを表す: 5C3 = 10.
 *
 * 一般に, r ≤ n について nCr = n!/(r!(n-r)!) である. ここで, n! = n×(n−1)×...×3×2×1, 0! = 1 と階乗を定義する.
 *
 * n = 23 になるまで, これらの値が100万を超えることはない: 23C10 = 1144066.
 *
 * 1 ≤ n ≤ 100 について, 100万を超える nCr は何通りあるか?
 */
object P053 {
  def solve: Long = ???
}
