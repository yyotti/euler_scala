package test.project_euler

import project_euler.P047
import org.specs2.mutable._

class P047Spec extends Specification {
  "P047#solve(Int)" should {
    "returns 14 if n = 2" in {
      P047.solve(2) must beEqualTo(14)
    }

    "returns 644 if n = 3" in {
      P047.solve(3) must beEqualTo(644)
    }

    "returns 134043 if n = 4" in {
      P047.solve(4) must beEqualTo(134043)
    }
  }
}
