package test.project_euler

import project_euler.P020
import org.specs2.mutable._

class P020Spec extends Specification {
  "P020#fact(BigInt)" should {
    "returns 1 if n = 1" in {
      P020.fact(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P020.fact(2) must beEqualTo(2)
    }

    "returns 6 if n = 3" in {
      P020.fact(3) must beEqualTo(6)
    }
  }

  "P020#solve(Int)" should {
    "returns 27 if n = 10" in {
      P020.solve(10) must beEqualTo(27)
    }

    "returns 648 if n = 100" in {
      P020.solve(100) must beEqualTo(648)
    }
  }
}
