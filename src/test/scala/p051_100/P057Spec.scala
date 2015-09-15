package test.project_euler

import project_euler.P057
import org.specs2.mutable._

class P057Spec extends Specification {
  "P057#solve(Int)" should {
    "returns 1 if n = 8" in {
      P057.solve(8) must beEqualTo(1)
    }

    "returns 153 if n = 1000" in {
      P057.solve(1000) must beEqualTo(153)
    }
  }
}
