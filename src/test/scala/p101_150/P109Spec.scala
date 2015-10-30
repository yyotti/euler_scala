package test.project_euler

import project_euler.P109
import org.specs2.mutable._

class P109Spec extends Specification {
  "P109#solve(Int)" should {
    "returns 38182 if n = 100" in {
      P109.solve(100) must beEqualTo(38182)
    }
  }
}
