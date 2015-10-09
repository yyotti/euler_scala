package test.project_euler

import project_euler.P088
import org.specs2.mutable._

class P088Spec extends Specification {
  "P088#solve(Int)" should {
    "returns 61 if n = 12" in {
      P088.solve(12) must beEqualTo(61)
    }

    "returns 7587457 if n = 12000" in {
      P088.solve(12000) must beEqualTo(7587457)
    }
  }
}
