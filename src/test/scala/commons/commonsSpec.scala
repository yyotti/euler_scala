package test.project_euler.commons

import project_euler.commons._
import org.specs2.mutable._

class commonsSpec extends Specification {
  "def from(start)" should {
    "first 10 terms are [1, 2, ... , 10] if start = 1" in {
      from(1).take(10).toList must beEqualTo(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    }

    "first 10 terms are [5, 6, ... , 14] if start = 5" in {
      from(5).take(10).toList must beEqualTo(List(5, 6, 7, 8, 9, 10, 11, 12, 13, 14))
    }
  }

  "def from(start, step)" should {
    "first 10 terms are [1, 3, 5, ... , 19] if (start, step) = (1, 2)" in {
      from(1, 2).take(10).toList must beEqualTo(List(1, 3, 5, 7, 9, 11, 13, 15, 17, 19))
    }

    "first 10 terms are [5, 10, 15, ... , 50] if (start, step) = (5, 5)" in {
      from(5, 5).take(10).toList must beEqualTo(List(5, 10, 15, 20, 25, 30, 35, 40, 45, 50))
    }
  }

  "def isPrime(n)" should {
    "returns false if n = 0" in {
      isPrime(0) must beFalse
    }

    "returns false if n = 1" in {
      isPrime(1) must beFalse
    }

    "returns true if n = 2" in {
      isPrime(2) must beTrue
    }

    "returns true if n = 3" in {
      isPrime(3) must beTrue
    }

    "returns false if n = 4" in {
      isPrime(4) must beFalse
    }

    "returns true if n = 7" in {
      isPrime(7) must beTrue
    }

    "returns true if n = 129" in {
      isPrime(129) must beFalse
    }

    "returns false if n = 84237" in {
      isPrime(84237) must beFalse
    }
  }

  "val primes" should {
    "first 10 terms are [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]" in {
      primes.take(10).toList must beEqualTo(List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))
    }
  }

  "def primeFactors(n)" should {
    "returns [] if n = 1" in {
      primeFactors(1) must beEmpty
    }

    "returns [2] if n = 2" in {
      primeFactors(2) must beEqualTo(List(2))
    }

    "returns [3] if n = 3" in {
      primeFactors(3) must beEqualTo(List(3))
    }

    "returns [2] if n = 4" in {
      primeFactors(4) must beEqualTo(List(2, 2))
    }

    "returns [2, 3] if n = 6" in {
      primeFactors(6) must beEqualTo(List(2, 3))
    }

    "returns [2, 2, 3] if n = 12" in {
      primeFactors(12) must beEqualTo(List(2, 2, 3))
    }

    "returns [5, 7, 13, 29] if n = 13195" in {
      primeFactors(13195) must beEqualTo(List(5, 7, 13, 29))
    }
  }

  "def fact(n)" should {
    "returns 1 if n = 1" in {
      fact(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      fact(2) must beEqualTo(2)
    }

    "returns 6 if n = 3" in {
      fact(3) must beEqualTo(6)
    }
  }

  "def digits(n)" should {
    "returns [1] if n = 1" in {
      digits(1) must beEqualTo(Seq(1))
    }

    "returns [1, 2] if n = 12" in {
      digits(12) must beEqualTo(Seq(1, 2))
    }

    "returns [1, 2, 3] if n = 123" in {
      digits(123) must beEqualTo(Seq(1, 2, 3))
    }
  }
}
