package project_euler

/**
 * Problem 88:
 * A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers,
 * {a1, a2, ... , ak} is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.
 *
 * For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.
 *
 * For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number.
 * The minimal product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.
 *
 * k=2: 4 = 2 × 2 = 2 + 2
 * k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
 * k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
 * k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
 * k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6
 *
 * Hence for 2≤k≤6, the sum of all the minimal product-sum numbers is 4+6+8+12 = 30; note that 8 is only counted once in the sum.
 *
 * In fact, as the complete set of minimal product-sum numbers for 2≤k≤12 is {4, 6, 8, 12, 15, 16}, the sum is 61.
 *
 * What is the sum of all the minimal product-sum numbers for 2≤k≤12000?
 *
 * 問題 88:
 * 少なくとも2つの自然数 {a1, a2, ... , ak} の集合の和かつ積として表せる自然数Nを積和数と呼ぶ：N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.
 *
 * 例えば, 6 = 1 + 2 + 3 = 1 × 2 × 3.
 *
 * ある集合の大きさ k に対して,この性質を持つ最小の N を最小積和数と呼ぼう. 集合の大きさ k = 2, 3, 4, 5, 6 に対する最小積和数は次のとおりである.
 *
 * k=2: 4 = 2 × 2 = 2 + 2
 * k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
 * k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
 * k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
 * k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6
 *
 * したがって 2 ≤ k ≤ 6 に対して,全ての最小積和数の和は 4+6+8+12 = 30 である. 8 は和に一度だけカウントされていることに気をつけよう.
 *
 * 実際, 2 ≤ k ≤ 12 に対する最小積和数の完全な集合は {4, 6, 8, 12, 15, 16} なので,その和は 61 である.
 *
 * 2 ≤ k ≤ 12000 に対する全ての最小積和数の和は何か?
 */
object P088 {
  import commons._

  def multiplyOne(x: Int, ls: List[Int]): List[List[Int]] = ls match {
    case Nil => Nil
    case h :: ts => ((x * h) :: ts) :: multiplyOne(x, ts).map { zs => (h :: zs) }
  }

  def addFactor(n: Int, products: List[Int]): List[List[Int]] = (n :: products).sorted :: multiplyOne(n, products).map { _.sorted }

  def productLists(fs: List[Int]): List[List[Int]] = fs match {
    case Nil => List(Nil)
    case x :: xs => productLists(xs).flatMap { ls => addFactor(x, ls) }.distinct
  }

  def findK(n: Int) = productLists(primeFactors(n).map { _.toInt }).map { ls => n - ls.sum + ls.size }.sorted

  /**
   * 積和数を作るには2以上の因数を2つ以上もつ自然数が必要である。
   * よって、最小の積和数は 2 * 2 = 4 であり、これがk = 2の場合の最小積和数になる。
   *
   * 2以上の因数を2つ以上もたなければならないので、素数は積和数になりえない。
   * そこで、4以上の合成数を対象に素因数分解する。
   *
   * n = 4の場合、
   *   4 = 2 * 2 = 2 + 2  (k = 2)
   *
   * n = 6の場合、
   *   6 = 2 * 3 != 2 + 3 = 5
   * であるが、和と積が等しくなるように1を加えていくと
   *   6 = 2 * 3 * 1 = 2 + 3 + 1 = 6  (k = 3)
   *
   * n = 8 の場合、
   *   8 = 2 * 2 * 2 * 1 * 1 = 2 + 2 + 2 + 1 + 1 = 8  (k = 5)
   * であるが、他にも
   *   8 = 2 * 4 * 1 * 1 = 2 + 4 + 1 + 1 = 8  (k = 4)
   * がある。
   *
   * 以上のことから、合成数nを素因数分解し、全ての約数の組み合わせを列挙したうえで、
   * 生成できるkを全て列挙する。同じkが見付かる場合があるが、その場合はより小さいnを
   * 採用する。
   */
  def solve(n: Int): Long =
    from(1)
      .flatMap { i => findK(i.toInt).map { k => (i.toInt, k) } }
      .filter { case (_, k) => k <= n }
      .scanLeft(Map[Int, Int]()) { case (mins, (i, k)) => mins + (k -> i.min(mins.getOrElse(k, i))) }
      .find { _.size >= n }
      .map { m => (m - 1).map { _._2 }.toSet.sum }
      .get

}
