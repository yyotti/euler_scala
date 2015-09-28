package test.project_euler

import project_euler.P075
import org.specs2.mutable._

class P075Spec extends Specification {
  "P075#solve" should {
    "returns 1 if n = 15" in {
      P075.solve(15) must beEqualTo(1)
    }

    "returns 161667 if n = 1500000" in {
      P075.solve(1500000) must beEqualTo(161667)
    }
  }
}
