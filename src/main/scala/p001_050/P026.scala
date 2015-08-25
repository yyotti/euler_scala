package project_euler

/**
 * Problem 26:
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2  = 0.5
 * 1/3  = 0.(3)
 * 1/4  = 0.25
 * 1/5  = 0.2
 * 1/6  = 0.1(6)
 * 1/7  = 0.(142857)
 * 1/8  = 0.125
 * 1/9  = 0.(1)
 * 1/10 = 0.1
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d &lt; 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 * 問題 26:
 * 単位分数とは分子が1の分数である. 分母が2から10の単位分数を10進数で表記すると次のようになる.
 *
 * 1/2  = 0.5
 * 1/3  = 0.(3)
 * 1/4  = 0.25
 * 1/5  = 0.2
 * 1/6  = 0.1(6)
 * 1/7  = 0.(142857)
 * 1/8  = 0.125
 * 1/9  = 0.(1)
 * 1/10 = 0.1
 *
 * 0.1(6)は 0.166666... という数字であり, 1桁の循環節を持つ. 1/7 の循環節は6桁ある.
 *
 * d &lt; 1000 なる 1/d の中で小数部の循環節が最も長くなるような d を求めよ.
 */
object P026 {

  def recuringCycleLength(n: Int, d: Int): Int = {
    def rc(n: Int, d: Int, count: Int, cache: Map[Int, Int]): Int =
      if ((n * 10) % d == 0) 0
      else if (cache.contains(n)) count - cache(n)
      else rc((n * 10) % d, d, count + 1, cache + (n -> count))

    rc(n, d, 1, Map.empty)
  }

  def solve(max: Int): Int = (1 until max).map { k => (k -> recuringCycleLength(1, k)) }.maxBy { _._2 }._1
}
