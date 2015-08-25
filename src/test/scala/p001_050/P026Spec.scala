package test.project_euler

import project_euler.P026
import org.specs2.mutable._

class P026Spec extends Specification {
  "P026#recuringCycleLength(Int, Int)" should {
    "returns 0 if (n, d) = (1, 1)" in {
      P026.recuringCycleLength(1, 1) must beEqualTo(0)
    }

    "returns 0 if (n, d) = (1, 2)" in {
      P026.recuringCycleLength(1, 2) must beEqualTo(0)
    }

    "returns 1 if (n, d) = (1, 3)" in {
      P026.recuringCycleLength(1, 3) must beEqualTo(1)
    }

    "returns 0 if (n, d) = (1, 4)" in {
      P026.recuringCycleLength(1, 4) must beEqualTo(0)
    }

    "returns 0 if (n, d) = (1, 5)" in {
      P026.recuringCycleLength(1, 5) must beEqualTo(0)
    }

    "returns 1 if (n, d) = (1, 6)" in {
      P026.recuringCycleLength(1, 6) must beEqualTo(1)
    }

    "returns 6 if (n, d) = (1, 7)" in {
      P026.recuringCycleLength(1, 7) must beEqualTo(6)
    }

    "returns 0 if (n, d) = (1, 8)" in {
      P026.recuringCycleLength(1, 8) must beEqualTo(0)
    }

    "returns 1 if (n, d) = (1, 9)" in {
      P026.recuringCycleLength(1, 9) must beEqualTo(1)
    }

    "returns 0 if (n, d) = (1, 10)" in {
      P026.recuringCycleLength(1, 10) must beEqualTo(0)
    }
  }

  "P026#solve(Int)" should {
    "returns 7 if max = 10" in {
      P026.solve(10) must beEqualTo(7)
    }

    "returns 983 if max = 1000" in {
      P026.solve(1000) must beEqualTo(983)
    }
  }
}
