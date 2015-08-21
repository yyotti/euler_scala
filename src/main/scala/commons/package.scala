package project_euler

package object commons {
  def from(start: Long): Stream[Long] = from(start, 1)

  def from(start: Long, step: Long): Stream[Long] = start #:: from(start + step, step)

  def isPrime(n: Long): Boolean =
    if (n <= 1) false
    else primes.takeWhile { _ <= math.sqrt(n) }.forall { n % _ != 0 }

  val primes: Stream[Long] = 2L #:: from(3L, 2).filter { n => isPrime(n) }
}
