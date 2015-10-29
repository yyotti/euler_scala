package test.project_euler

import project_euler.P108
import org.specs2.mutable._

class P108Spec extends Specification {
  "P108#solve(Int)" should {
    "returns 180180 if n = 1000" in {
      P108.solve(1000) must beEqualTo(180180)
    }
  }
}
