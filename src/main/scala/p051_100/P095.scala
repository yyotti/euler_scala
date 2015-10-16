package project_euler

/**
 * Problem 95:
 * The proper divisors of a number are all the divisors excluding the number itself.
 * For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As the sum of these divisors is equal to 28, we call it a perfect number.
 *
 * Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper divisors of 284 is 220,
 * forming a chain of two numbers. For this reason, 220 and 284 are called an amicable pair.
 *
 * Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:
 *
 * 12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)
 *
 * Since this chain returns to its starting point, it is called an amicable chain.
 *
 * Find the smallest member of the longest amicable chain with no element exceeding one million.
 *
 * 問題 95:
 * ある数の真の約数とは, それ自身を除く約数すべてである. 例えば, 28 の真の約数は 1, 2, 4, 7, 14 である.
 * これらの約数の和は 28 に等しいため, これを完全数と呼ぶ.
 *
 * 面白いことに, 220 の真の約数の和は 284 で, 284 の真の約数の和は 220 となっており, 二つの数が鎖をなしている.
 * このため, 220 と 284 は友愛数と呼ばれる.
 *
 * さらに長い鎖はあまり知られていないだろう. 例えば, 12496 から始めると, 5 つの数の鎖をなす.
 *
 * 12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)
 *
 * この鎖は出発点に戻っているため, 友愛鎖と呼ばれる.
 *
 * いずれの要素も 1,000,000 を超えない最長の友愛鎖の最小のメンバーを求めよ.
 */
object P095 {
  import commons._

  def sums(limit: Int) =
    (1 until limit)
      .foldLeft(Map[Int, Int]()) { (map, i) =>
        (2 * i until limit by i)
          .foldLeft(map + (i -> map.getOrElse(i, 0))) { (map, k) => map + (k -> (map.getOrElse(k, 0) + i)) }
      }
      .filter { case (_, s) => s < limit }

  def chainCount(start: Int, nums: Map[Int, Int]): Int =  {
    def loop(n: Int, result: List[Int]): List[Int] = n match {
      case k if result.contains(k) => k :: result
      case k if !nums.contains(k) => Nil
      case k => loop(nums(k), k :: result)
    }

    loop(start, Nil) match {
      case Nil => 0
      case x :: _ if x != start => 0
      case ls => ls.size - 1
    }
  }

  /**
   * まずエラトステネスの篩のイメージで真の約数の和の一覧を作る。
   * エラトステネスの篩は、ある数字の倍数を順に削除していくアルゴリズムだが、今回は
   *   YがXの倍数である → XはYの約数である
   * ということで篩にかける。
   *
   * 一覧ができたら、あとは和を辿っていってループになっているか調べればよい。
   */
  def solve: Long = {
    val limit = 1000000
    val nums = sums(limit)
    (1 until limit)
      .foldLeft((0, 0)) { case ((minN, maxCount), n) =>
        val c = chainCount(n, nums)
        if (c > maxCount) (n, c)
        else if (c == maxCount) (minN.min(n), c)
        else (minN, maxCount)
      }
      ._1
  }
}
