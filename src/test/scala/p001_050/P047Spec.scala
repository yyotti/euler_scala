package test.project_euler

import project_euler.P047
import org.specs2.mutable._

class P047Spec extends Specification {
  "P047#primeFactorsSet(Long)" should {
    "returns [(2, 1), (7, 1)] if n = 14" in {
      P047.primeFactorsSet(14) must beEqualTo(Set((2, 1), (7, 1)))
    }

    "returns [(3, 1), (5, 1)] if n = 15" in {
      P047.primeFactorsSet(15) must beEqualTo(Set((3, 1), (5, 1)))
    }

    "returns [(2, 2), (7, 1), (23, 1)] if n = 644" in {
      P047.primeFactorsSet(644) must beEqualTo(Set((2, 2), (7, 1), (23, 1)))
    }
  }

  "P047#solve(Int)" should {
    "returns 14 if n = 2" in {
      P047.solve(2) must beEqualTo(14)
    }

    "returns 644 if n = 3" in {
      P047.solve(3) must beEqualTo(644)
    }

    "returns 134043 if n = 4" in {
      P047.solve(4) must beEqualTo(134043)
    }
  }
}
