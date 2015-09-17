package project_euler

/**
 * Problem 60:
 * The primes 3, 7, 109, and 673, are quite remarkable.
 * By taking any two primes and concatenating them in any order the result will always be prime.
 * For example, taking 7 and 109, both 7109 and 1097 are prime.
 * The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
 *
 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 *
 * 問題 60:
 * 素数3, 7, 109, 673は非凡な性質を持っている.
 * 任意の2つの素数を任意の順で繋げると, また素数になっている.
 * 例えば, 7と109を用いると, 7109と1097の両方が素数である.
 * これら4つの素数の和は792である. これは, このような性質をもつ4つの素数の集合の和の中で最小である.
 *
 * 任意の2つの素数を繋げたときに別の素数が生成される, 5つの素数の集合の和の中で最小のものを求めよ.
 */
object P060 {
  import commons._

  def search(n: Int, p: Long, ps: List[Long]): Option[Long] = {
    concatPrimes(filterConcatPrimes(p, ps), n - 1) match {
      case ls if ls.nonEmpty => Some(p + ls.map { _.sum }.min)
      case _ => None
    }
  }

  def concatPrimes(ps: List[Long], k: Long): List[List[Long]] = (ps, k) match {
    case (_, 0) => List(Nil)
    case (Nil, _) => Nil
    case (x :: xs, n) => concatPrimes(filterConcatPrimes(x, xs), n - 1).map { x :: _ } ++ concatPrimes(xs, n)
  }

  def filterConcatPrimes(n: Long, ps: List[Long]): List[Long] = {
    def isConcatPrime(x: Long, y: Long) = isPrime((x.toString + y).toLong) && isPrime((y.toString + x).toLong)
    ps.filter { p => isConcatPrime(n, p) }
  }

  def solve(n: Int): Long =
    primes
      .tail
      .scanLeft(List(primes.head)) { case (ls, p) => p :: ls }
      .map { ls => search(n, ls.head, ls.tail) }
      .find { _.isDefined }
      .get
      .get

}
