package project_euler

/**
 * Problem 51:
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit, is part of an eight prime value family.
 *
 * 問題 51:
 * *3の第1桁を置き換えることで, 13, 23, 43, 53, 73, 83という6つの素数が得られる.
 *
 * 56**3の第3桁と第4桁を同じ数で置き換えることを考えよう.
 * この5桁の数は7つの素数をもつ最初の例である: 56003, 56113, 56333, 56443, 56663, 56773, 56993.
 * よって, この族の最初の数である56003は, このような性質を持つ最小の素数である.
 *
 * 桁を同じ数で置き換えることで8つの素数が得られる最小の素数を求めよ. (注:連続した桁でなくても良い)
 */
object P051 {
  import commons._

  def replacedNumbers(n: String, d: Int): List[Seq[Long]] =
    (0 to (n.length - 2)).toList.combinations(d).map {
      case ls =>
        val start = if (ls.contains(0)) 1 else 0
        (start to 9).map { k =>
          ls.foldLeft(n) { case (n, i) => n.updated(i, k.toString.head) }.toLong
        }
    }.toList

  /**
   * 1の位を置き換えると偶数もしくは5の倍数になるので、8個の素数を生成できない。
   * また、1つの桁だけを0～9で置き換えると最低3つは3の倍数になってしまい、8個の素数を
   * 生成できないため、置き換え対象は2つ以上である。
   *
   * n桁の整数のうちd桁をkに置き換えることを考える。
   * 置き換えられない(n - d)桁の数字の和をaとし、
   *   S(k) = a + kd
   * とすると、S(k)が3で割り切れるkの個数が2つでなければ、8個の素数を生成できない。
   * dが3の倍数でない場合は、
   *   (1) a が3の倍数である場合：kが3の倍数であれば割り切れる => 3つのケースがある
   *   (2) a を3で割ると1余る場合：kdを3で割って2余る場合は割り切れる => 3つのケースがある
   *   (3) a を3で割ると2余る場合：kdを3で割って1余る場合は割り切れる => 3つのケースがある
   * となり、いずれの場合も8個の素数を生成できないため、dは3の倍数でなければならない。
   *
   * 以上のことから、4桁以上の素数を調査対象とすればよい。
   */
  def solve: Long =
    primes
      .dropWhile { _ < 1000 }
      .flatMap { p =>
        (3 to digitCount(p) by 3).flatMap { d =>
          replacedNumbers(p.toString, d).map { ls => ls.filter { n => isPrime(n) } }.find { _.size == 8 }
        }
      }
      .head
      .head
}
