package project_euler

/**
 * Problem 97:
 * The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 2^6972593−1;
 * it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p−1, have been found which contain more digits.
 *
 * However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×2^7830457+1.
 *
 * Find the last ten digits of this prime number.
 *
 * 問題 97:
 * 100万桁を超える初めての素数は1999年に発見された. これはメルセンヌ素数であり, 2^6972593-1 である.
 * 実際, 2,098,960桁ある. それ以降も, より多くの桁になるメルセンヌ素数 (2^p-1の形の数) が他にも発見されている.
 *
 * しかし, 2004年に, 非常に大きな非メルセンヌ素数が発見された. これは2,357,207桁の数であり, 28433×2^7830457+1である.
 *
 * この素数の末尾10桁を答えよ.
 */
object P097 {
  /**
   * BigIntを使えば、素直に 28433×2^7830457 + 1 を計算して10^10 で割った余りをとれば答えが出せる。
   * しかしそれでは面白くないので一工夫する。
   *
   *   28433×2^7830457 + 1 ≡ x (mod 10^10)
   * を満たすxを求める。
   * a,b,c,d,mを整数とし、a ≡ b (mod m), c ≡ d (mod m)とする。
   * 合同式の性質から
   *   a + c ≡ b + d (mod m)
   * であるから、
   *   28433×2^7830457 + 1 ≡ x (mod 10^10)
   * と
   *   -1 ≡ -1  (mod 10^10)
   * から
   *   28433×2^7830457 ≡ x - 1 (mod 10^10)
   * である。
   * また、
   *   ac ≡ bc (mod m)  特に  ac ≡ bc (mod m)
   * であり、aとmが互いに素なら
   *   b ≡ c (mod m)
   * であるから、
   *   2^7830457 ≡ (x - 1)/28433 (mod 10^10)
   * である。(28433は素数なので10^10とは互いに素である)
   * X = (x - 1)/28433 とすれば、
   *   2^7830457 ≡ X (mod 10^10)
   * を満たすXを求めればよい。
   *   2^7830457 = 2 * 2^7830456 = 2^7830456 + 2^7830456
   * であるから、
   *   2^7830456 ≡ Y  (mod 10^10)
   * とすると
   *   2^7830457 = 2^7830456 + 2^7830456 ≡ Y + Y = 2Y  (mod 10^10)
   * となる。よって X は
   *   「2をかけて10^10で割る」
   * を7830456回繰り返すことで計算できる。
   * あとは
   *   x = 28433X + 1
   * である。
   */
  def solve: Long = {
    def loop(n: Long, m: Long, count: Int): Long = count match {
      case 0 => n
      case _ => loop(2 * n % m, m, count - 1)
    }

    val m = math.pow(10, 10).toLong
    (loop(28433, m, 7830457) + 1) % m
  }
}
