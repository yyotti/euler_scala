package project_euler

/**
 * Problem 48:
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 *
 * 問題 48:
 * 次の式は, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317 である.
 *
 * では, 1^1 + 2^2 + 3^3 + ... + 1000^1000 の最後の10桁を求めよ.
 */
object P048 {
  def solve(n: Int): Long =
    (Stream.from(1).take(n).map { k => BigInt(k).pow(k) }.sum % 10000000000L).toLong
}
