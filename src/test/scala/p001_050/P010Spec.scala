package test.project_euler

import project_euler.P010
import org.specs2.mutable._

class P010Spec extends Specification {
  "P010#solve(Long)" should {
    "returns 17 if max = 10" in {
      P010.solve(10) must beEqualTo(17)
    }

    "returns 142913828922 if max = 2000000" in {
      P010.solve(2000000) must beEqualTo(142913828922L)
    }
  }
}
