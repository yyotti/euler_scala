package test.project_euler

import project_euler.P036
import org.specs2.mutable._

class P036Spec extends Specification {
  "P036#solve(Int)" should {
    "returns 57 if n = 20" in {
      P036.solve(20) must beEqualTo(57)
    }

    "returns 872187 if n = 1000000" in {
      P036.solve(1000000) must beEqualTo(872187)
    }
  }
}
