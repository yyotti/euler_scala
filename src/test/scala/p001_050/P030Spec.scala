package test.project_euler

import project_euler.P030
import org.specs2.mutable._

class P030Spec extends Specification {
  "P030#solve(Int)" should {
    "returns 19316 if n = 4" in {
      P030.solve(4) must beEqualTo(19316)
    }

    "returns 443839 if n = 5" in {
      P030.solve(5) must beEqualTo(443839)
    }
  }
}
