package test.project_euler

import project_euler.P003
import org.specs2.mutable._

class P003Spec extends Specification {
  "P003#primeFactors(Long)" should {
    "returns [] if n = 1" in {
      P003.primeFactors(1) must beEmpty
    }

    "returns [2] if n = 2" in {
      P003.primeFactors(2) must beEqualTo(List(2))
    }

    "returns [3] if n = 3" in {
      P003.primeFactors(3) must beEqualTo(List(3))
    }

    "returns [2] if n = 4" in {
      P003.primeFactors(4) must beEqualTo(List(2, 2))
    }

    "returns [2, 3] if n = 6" in {
      P003.primeFactors(6) must beEqualTo(List(2, 3))
    }

    "returns [2, 2, 3] if n = 12" in {
      P003.primeFactors(12) must beEqualTo(List(2, 2, 3))
    }

    "returns [5, 7, 13, 29] if n = 13195" in {
      P003.primeFactors(13195) must beEqualTo(List(5, 7, 13, 29))
    }
  }

  "P003#solve(Long)" should {
    "returns 29 if n = 13195" in {
      P003.solve(13195) must beEqualTo(29)
    }

    "returns 6857 if n = 600851475143" in {
      P003.solve(600851475143L) must beEqualTo(6857)
    }
  }
}
