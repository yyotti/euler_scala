package project_euler

/**
 * Problem 63:
 * The 5-digit number, 16807=75, is also a fifth power.
 * Similarly, the 9-digit number, 134217728=8^9, is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 *
 * 問題 63:
 * 5桁の数 16807 = 7^5は自然数を5乗した数である. 同様に9桁の数 134217728 = 8^9も自然数を9乗した数である.
 *
 * 自然数を n 乗して得られる n 桁の正整数は何個あるか?
 */
object P063 {
  import commons._

  def solve: Long =
    from(1)
      .map { n =>
        from(1)
          .map { k => val kn = BigInt(k).pow(n.toInt); (kn, digitCount(kn)) }
          .dropWhile { _._2 < n }
          .takeWhile { _._2 == n }
          .size
      }
      .takeWhile { _ > 0 }.sum

}
