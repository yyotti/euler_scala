package test.project_euler

import project_euler.P015
import org.specs2.mutable._

class P015Spec extends Specification {
  "P015#solve(Int)" should {
    "returns 6 if n = 2" in {
      P015.solve(2) must beEqualTo(6)
    }

    "returns 137846528820 if n = 20" in {
      P015.solve(20) must beEqualTo(137846528820L)
    }
  }
}
