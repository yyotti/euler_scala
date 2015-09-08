package project_euler

/**
 * Problem 38:
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 *
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 *
 * 問題 38:
 * 192 に 1, 2, 3 を掛けてみよう.
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 *
 * 積を連結することで1から9の パンデジタル数 192384576 が得られる. 192384576 を 192 と (1,2,3) の連結積と呼ぶ.
 *
 * 同じようにして, 9 を 1,2,3,4,5 と掛け連結することでパンデジタル数 918273645 が得られる. これは 9 と (1,2,3,4,5) との連結積である.
 *
 * 整数と (1,2,...,n) (n > 1) との連結積として得られる9桁のパンデジタル数の中で最大のものはいくつか?
 */
object P038 {
  import commons._

  /**
   * かける数は(1, 2, ..., n)でn > 1なので、少なくともn = 2までは計算される。
   *
   * d 桁の整数に 1 桁の数字をかけ合わせると、d桁もしくは(d + 1)桁となる。
   * かけられる数をi、その桁数をdとすると、
   * d = 5 の場合は
   *   i × 1 → 5桁
   *   i × 2 → 5桁 or 6桁
   * となり、連結積が必ず9桁を超える。
   *
   * d = 4 の場合は
   *   i × 1 → 4桁
   *   i × 2 → 4桁 or 5桁
   * となるので、d <= 4の範囲で調べれば良い。
   */
  def solve: Long = Stream.from(1).takeWhile { _ < 10000 }.map { i =>
    Stream.from(2).map { k =>
      Stream.from(1).takeWhile { _ <= k }.map { _ * i }.mkString
    }.dropWhile { _.length < 9 }.head
  }.withFilter { s => s.length == 9 && isPandigitalNumber(s.toLong) }.map { _.toLong }.max

}
