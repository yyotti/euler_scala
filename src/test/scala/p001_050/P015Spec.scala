package test.project_euler

import project_euler.P015
import org.specs2.mutable._

class P015Spec extends Specification {
  "P015#combination(Int, Int)" should {
    "returns 0 if (n, r) = (3, 0)" in {
      P015.combination(3, 0) must beEqualTo(0)
    }

    "returns 0 if (n, r) = (4, 5)" in {
      P015.combination(4, 5) must beEqualTo(0)
    }

    "returns 1 if (n, r) = (2, 2)" in {
      P015.combination(2, 2) must beEqualTo(1)
    }

    "returns 3 if (n, r) = (3, 1)" in {
      P015.combination(3, 1) must beEqualTo(3)
    }

    "returns 5 if (n, r) = (5, 4)" in {
      P015.combination(5, 4) must beEqualTo(5)
    }

    "returns 20 if (n, r) = (6, 3)" in {
      P015.combination(6, 3) must beEqualTo(20)
    }

  }

  "P015#solve(Int)" should {
    "returns 6 if n = 2" in {
      P015.solve(2) must beEqualTo(6)
    }

    "returns 137846528820 if n = 20" in {
      P015.solve(20) must beEqualTo(137846528820L)
    }
  }
}
