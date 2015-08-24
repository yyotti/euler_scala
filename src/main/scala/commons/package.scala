package project_euler

package object commons {
  import io.Source
  import java.io.File

  def from(start: Long): Stream[Long] = from(start, 1)

  def from(start: Long, step: Long): Stream[Long] = start #:: from(start + step, step)

  def isPrime(n: Long): Boolean =
    if (n <= 1) false
    else primes.takeWhile { _ <= math.sqrt(n) }.forall { n % _ != 0 }

  val primes: Stream[Long] = 2L #:: from(3L, 2).filter { n => isPrime(n) }

  def primeFactors(n: Long): List[Long] =
    if (n == 1) Nil
    else primes.takeWhile { _ <= math.sqrt(n) }.find { n % _ == 0 } match {
      case Some(k) => k :: primeFactors(n / k)
      case _ => List(n)
    }

  def fact(n: BigInt): BigInt =
    if (n <= 1) 1
    else n * fact(n - 1)

  def digits(n: BigInt): Seq[Int] = n.toString.map { _.toString.toInt }

  def withSource[R](src: Source)(body: Source => R): R =
    try {
      body(src)
    } finally {
      src.close
    }

  def fromFileToString(file: File): String =
    withSource(Source.fromFile(file)) { src =>
      src.getLines.mkString
    }

  def sumProperDivisors(n: Long) =
    primeFactors(n).groupBy { k => k }.map { case (k, list) => (0 to list.size).map { a => BigInt(k).pow(a) }.sum }.product.toLong - n
}
