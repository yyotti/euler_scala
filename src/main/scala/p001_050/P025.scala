package project_euler

/**
 * Problem 25:
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * F(n) = F(n−1) + F(n−2), where F(1) = 1 and F(2) = 1.
 * Hence the first 12 terms will be:
 *
 * F(1) = 1
 * F(2) = 1
 * F(3) = 2
 * F(4) = 3
 * F(5) = 5
 * F(6) = 8
 * F(7) = 13
 * F(8) = 21
 * F(9) = 34
 * F(10) = 55
 * F(11) = 89
 * F(12) = 144
 *
 * The 12th term, F(12), is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * 問題 25:
 * フィボナッチ数列は以下の漸化式で定義される:
 *
 * F(n) = F(n-1) + F(n-2), ただし F(1) = 1, F(2) = 1.
 * 最初の12項は以下である.
 *
 * F(1) = 1
 * F(2) = 1
 * F(3) = 2
 * F(4) = 3
 * F(5) = 5
 * F(6) = 8
 * F(7) = 13
 * F(8) = 21
 * F(9) = 34
 * F(10) = 55
 * F(11) = 89
 * F(12) = 144
 *
 * 12番目の項, F(12)が3桁になる最初の項である.
 *
 * 1000桁になる最初の項の番号を答えよ.
 */
object P025 {
  import commons._

  val fib: Stream[BigInt] = BigInt(1) #:: BigInt(1) #:: fib.zip(fib.tail).map { case (a, b) => a + b }

  def solve(digit: Int): Long =
    fib.zipWithIndex.dropWhile { case (n, idx) => digitCount(n) < digit }.head._2 + 1
}
