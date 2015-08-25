package test.project_euler

import project_euler.P029
import org.specs2.mutable._

class P029Spec extends Specification {
  "P029#solve(Int)" should {
    "returns 15 if n = 5" in {
      P029.solve(5) must beEqualTo(15)
    }

    "returns 9183 if n = 100" in {
      P029.solve(100) must beEqualTo(9183)
    }
  }
}
