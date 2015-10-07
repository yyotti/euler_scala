package test.project_euler

import project_euler.P085
import org.specs2.mutable._

class P085Spec extends Specification {
  "P085#phi" should {
    "first 10 terms are [0, 1, 3, 6, 10, 15, 21, 28, 36, 45]" in {
      P085.phi.take(10).toList must beEqualTo(List(0, 1, 3, 6, 10, 15, 21, 28, 36, 45))
    }
  }

  "P085#pi(Int, Int)" should {
    "returns 1 if (x, y) = (1, 1)" in {
      P085.pi(1, 1) must beEqualTo(1)
    }

    "returns 3 if (x, y) = (1, 2)" in {
      P085.pi(1, 2) must beEqualTo(3)
    }

    "returns 9 if (x, y) = (2, 2)" in {
      P085.pi(2, 2) must beEqualTo(9)
    }

    "returns 6 if (x, y) = (1, 3)" in {
      P085.pi(1, 3) must beEqualTo(6)
    }

    "returns 18 if (x, y) = (2, 3)" in {
      P085.pi(2, 3) must beEqualTo(18)
    }

    "returns 36 if (x, y) = (3, 3)" in {
      P085.pi(3, 3) must beEqualTo(36)
    }
  }

  "P085#solve(Int)" should {
    "returns 6 if n = 18" in {
      P085.solve(18) must beEqualTo(6)
    }

    "returns 9 if n = 33" in {
      P085.solve(33) must beEqualTo(9)
    }

    "returns 2772 if n = 2000000" in {
      P085.solve(2000000) must beEqualTo(2772)
    }
  }
}
