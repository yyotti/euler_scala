package project_euler

/**
 * Problem 74:
 * The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:
 *
 * 1! + 4! + 5! = 1 + 24 + 120 = 145
 *
 * Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:
 *
 * 169 → 363601 → 1454 → 169
 * 871 → 45361 → 871
 * 872 → 45362 → 872
 *
 * It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,
 *
 * 69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 * 78 → 45360 → 871 → 45361 (→ 871)
 * 540 → 145 (→ 145)
 *
 * Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.
 *
 * How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
 *
 * 問題 74:
 * 145は各桁の階乗の和が145と自分自身に一致することで有名である.
 *
 * 1! + 4! + 5! = 1 + 24 + 120 = 145
 *
 * 169の性質はあまり知られていない. これは169に戻る数の中で最長の列を成す. このように他の数を経て自分自身に戻るループは3つしか存在しない.
 *
 * 169 → 363601 → 1454 → 169
 * 871 → 45361 → 871
 * 872 → 45362 → 872
 *
 * どのような数からスタートしてもループに入ることが示せる.
 *
 * 例を見てみよう.
 *
 * 69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 * 78 → 45360 → 871 → 45361 (→ 871)
 * 540 → 145 (→ 145)
 *
 * 69から始めた場合, 列は5つの循環しない項を持つ. また100万未満の数から始めた場合最長の循環しない項は60個であることが知られている.
 *
 * 100万未満の数から開始する列の中で, 60個の循環しない項を持つものはいくつあるか?
 */
object P074 {
  def solve: Long = ???
}
