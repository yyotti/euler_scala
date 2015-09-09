package project_euler

/**
 * Problem 46:
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 *
 * 問題 46:
 * Christian Goldbachは全ての奇合成数は平方数の2倍と素数の和で表せると予想した.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 *
 * 後に, この予想は誤りであることが分かった.
 *
 * 平方数の2倍と素数の和で表せない最小の奇合成数はいくつか?
 */
object P046 {
  import commons._

  val squares = Stream.from(1).map { n => n * n }

  def solve: Long =
    from(3, 2)
      .filter { n =>
        !isPrime(n) &&
        !squares.takeWhile { _ < n / 2 }.exists { s => isPrime(n - 2 * s) }
      }.head

}
