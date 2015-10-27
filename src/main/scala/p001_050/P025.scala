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
  val logPhi = math.log10((1 + math.sqrt(5)) / 2)
  val e = math.log10(5) / 2

  /**
   * フィボナッチ数列の一般項F(n)は、
   *   φ = (1 + √5) / 2
   * として
   *   F(n) = (φ^n - (-φ)^(-n)) / √5
   * で表せる。この式の第2項はn = 0のときの 1/√5 ≒ 0.447 が最大で、それを超えることはない。
   * よって、第2項を省略した
   *   F(n) ≒ (φ^n)/√5
   * は、F(n)の値を 0.447 以下の誤差で与える近似式である。
   * この誤差は0.5より小さいので、F(n)の正確な整数値は
   *   F(n) = ((φ^n)/√5 + 1/2)   (小数点以下は切り捨て)
   * で得られる。
   *
   * いま、フィボナッチ数列の桁数のみが知れればよいので、F(n)の10を底とする対数をとると、
   *   log10(F(n)) = log10((φ^n)/√5 + 1/2)
   *               ≒ log10((φ^n)/√5)
   *               = log10(φ^n) - log10(√5)
   *               = n*log10(φ) - log10(5)/2
   * 桁数はこれに1を加えた値の整数部分である。
   */
  def solve(digit: Int): Long =
    Stream.from(1).find { n => n * logPhi - e + 1 >= digit }.get
}
