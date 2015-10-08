package test.project_euler

import project_euler.P086
import org.specs2.mutable._

class P086Spec extends Specification {
  "P086#t(Int, Int)" should {
    "returns 5 if (x, y) = (3, 4)" in {
      P086.t(3, 4) must beEqualTo(5)
    }

    "returns √5 if (x, y) = (1, 2)" in {
      P086.t(1, 2) must beEqualTo(math.sqrt(5))
    }
  }

  "P086#r(Int, Int, Int)" should {
    "returns 0 if (h, d, w) = (1, 1, 1)" in {
      P086.r(1, 1, 1) must beEqualTo(0)
    }

    "returns 1 if (h, d, w) = (3, 5, 6)" in {
      P086.r(3, 5, 6) must beEqualTo(1)
    }
  }

  "P086#s" should {
    "first 10 terms are [0, 0, 0, 2, 3, 3, 6, 6, 10, 14]" in {
      P086.s.take(10).toList must beEqualTo(List(0, 0, 0, 2, 3, 3, 6, 6, 10, 14))
    }
  }

  "P086#solve(Int)" should {
    "returns 100 if n = 2000" in {
      P086.solve(2000) must beEqualTo(100)
    }

    "returns 1818 if n = 1000000" in {
      P086.solve(1000000) must beEqualTo(1818)
    }
  }
}
