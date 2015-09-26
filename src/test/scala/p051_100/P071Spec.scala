package test.project_euler

import project_euler.P071
import org.specs2.mutable._

class P071Spec extends Specification {
  "P071#solve(Int)" should {
    "returns 2 if d = 8" in {
      P071.solve(8) must beEqualTo(2)
    }

    "returns 428570 if d = 1000000" in {
      P071.solve(1000000) must beEqualTo(428570)
    }
  }
}
