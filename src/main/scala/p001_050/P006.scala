package project_euler

/**
 * Problem 6:
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * 問題 6:
 * 最初の10個の自然数について, その二乗の和は,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 最初の10個の自然数について, その和の二乗は,
 *
 * (1 + 2 + ... + 10)^2 = 3025
 * これらの数の差は 3025 - 385 = 2640 となる.
 *
 * 同様にして, 最初の100個の自然数について二乗の和と和の二乗の差を求めよ.
 */
object P006 {
  /*
   * 1からnまでの自然数の和をSとすると、
   *   S = n(n + 1)/2
   * よってその2乗は
   *   S1 = S^2 = {n(n + 1)/2}^2
   *            = {n(n + 1)}^2/4
   *            = (n^2)(n + 1)^2/4
   *
   * 1からnまでの自然数の2乗和をS2とすると、
   *   S2 = n(n + 1)(2n + 1)/6
   *
   * 求めるのは S1 - S2 なので、
   *   S2 - S1 = (n^2)(n + 1)^2/4 - n(n + 1)(2n + 1)/6
   *           = [3{(n^2)(n + 1)^2} - 2n(n + 1)(2n + 1)]/12
   *           = {3(n^4 + 2n^3 + n^2) - (4n^3 + 6n^2 + 2n)}/12
   *           = (3n^4 + 6n^3 + 3n^2 - 4n^3 - 6n^2 - 2n)/12
   *           = (3n^4 + 2n^3 - 3n^2 - 2n)/12
   *           = n(3n^3 + 2n^2 - 3n - 2)/12
   *           = n(n - 1)(3n^2 + 5n - 2)/12
   *           = n(n - 1)(n + 1)(3n + 2)/12
   */
  def solve(n: Long): Long = n * (n - 1) * (n + 1) * (3 * n + 2) / 12
}
