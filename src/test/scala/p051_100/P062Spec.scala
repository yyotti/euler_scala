package test.project_euler

import project_euler.P062
import org.specs2.mutable._

class P062Spec extends Specification {
  "P062#solve(Int)" should {
    "returns 41063625 if n = 3" in {
      P062.solve(3) must beEqualTo(41063625)
    }

    "returns 127035954683 if n = 5" in {
      P062.solve(5) must beEqualTo(127035954683L)
    }
  }
}
