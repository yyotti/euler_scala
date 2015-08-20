package test.project_euler

import project_euler.P004
import org.specs2.mutable._

class P004Spec extends Specification {
  "P004#solve(Int)" should {
    "returns 9009 if n = 2" in {
      P004.solve(2) must beEqualTo(9009)
    }

    "returns 906609 if n = 3" in {
      P004.solve(3) must beEqualTo(906609)
    }
  }
}
