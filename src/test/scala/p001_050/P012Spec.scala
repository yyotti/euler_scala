package test.project_euler

import project_euler.P012
import org.specs2.mutable._

class P012Spec extends Specification {
  "P012#triangleNumbers" should {
    "first 10 terms are [1, 3, 6, 10, 15, 21, 28, 36, 45, 55]" in {
      P012.triangleNumbers.take(10).toList must beEqualTo(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
    }
  }

  "P012#factorsCount(Long)" should {
    "returns 1 if n = 1" in {
      P012.factorsCount(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P012.factorsCount(2) must beEqualTo(2)
    }

    "returns 3 if n = 4" in {
      P012.factorsCount(4) must beEqualTo(3)
    }

    "returns 4 if n = 6" in {
      P012.factorsCount(6) must beEqualTo(4)
    }

    "returns 6 if n = 28" in {
      P012.factorsCount(28) must beEqualTo(6)
    }
  }


  "P012#solve(Int)" should {
    "returns 28 if n = 5" in {
      P012.solve(5) must beEqualTo(28)
    }

    "returns 76576500 if n = 500" in {
      P012.solve(500) must beEqualTo(76576500)
    }
  }
}
