package project_euler

/**
 * Problem 40:
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.12345678910[1]112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If d(n) represents the nth digit of the fractional part, find the value of the following expression.
 *
 * d(1) × d(10) × d(100) × d(1000) × d(10000) × d(100000) × d(1000000)
 *
 * 問題 40:
 * 正の整数を順に連結して得られる以下の10進の無理数を考える:
 *
 * 0.12345678910[1]112131415161718192021...
 * 小数第12位は1である.
 *
 * d(n)で小数第n位の数を表す. d(1) × d(10) × d(100) × d(1000) × d(10000) × d(100000) × d(1000000) を求めよ.
 */
object P040 {
  import commons._

  def d(n: Int): Int =
    if (n < 10) n
    else {
      val p = Stream.from(2).scanLeft("1") { case (s, i) => i + s }.map { _.toInt }.dropWhile { n > _ * 9 }.head
      val k = digitCount(p)
      val minn = 9 * p.toString.tail.toInt + 1
      val index = (n - minn) % k
      val num = (math.pow(10, k - 1).toLong + (n - minn) / k).toString()(index).asDigit

      num
    }

  /**
   * d(n)の一般項を考える。便宜上、d(0) = 0 とする。
   * d(n)は自然数の連結なので、連結する自然数を N とすると、n の位置に対応する自然数とそのどの桁を指すかが
   * 分かれば良い。
   *
   * N が 1 桁の数は 0 ～ 9 の 10 個ある。この間は桁数は 1 桁ずつ増える。
   * N が 2 桁の数は 10 ～ 99 で、これは 0 ～ 99 の100個から 0 ～ 9 の10個を除いた個数なので、90個ある。
   * この間は桁数は 2 桁ずつ増える。
   * 同様に、N が 3 桁の数は 100 ～ 999 で、900 個ある。この間は桁数は 3 桁ずつ増える。
   * この事実と n の対応を考えると、
   * 0 <= N <= 9 では、 0 <= n <= 9(1 × 9)
   * 10 <= N <= 99 では、10 <= n <= 189(21 × 9)
   * 100 <= N <= 999 では、190 <= n <= 2889(321 × 9)
   * 1000 <= N <= 9999 では、2890 <= n <= 38889(4321 × 9)
   * よって、n / 9 の値で桁数が分かる。
   *
   * (以下略)
   */
  def solve: Long = (0 to 6).map { k => d(math.pow(10, k).toInt) }.product
}
