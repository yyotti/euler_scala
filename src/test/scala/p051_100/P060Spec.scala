package test.project_euler

import project_euler.P060
import org.specs2.mutable._

class P060Spec extends Specification {
  "P060#solve(Int)" should {
    "returns 10 if n = 2" in {
      P060.solve(2) must beEqualTo(10)
    }

    "returns 107 if n = 3" in {
      P060.solve(3) must beEqualTo(107)
    }

    "returns 792 if n = 4" in {
      P060.solve(4) must beEqualTo(792)
    }

    "returns 26033 if n = 5" in {
      P060.solve(5) must beEqualTo(26033)
    }
  }
}
