package test.project_euler

import project_euler.P100
import org.specs2.mutable._

class P100Spec extends Specification {
  "P100#solve(Int)" should {
    "returns 85" in {
      P100.solve(100) must beEqualTo(85)
    }

    "returns 756872327473" in {
      P100.solve(1000000000000L) must beEqualTo(756872327473L)
    }
  }
}
