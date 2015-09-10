package test.project_euler

import project_euler.P050
import org.specs2.mutable._

class P050Spec extends Specification {
  "P050#solve(Int)" should {
    "returns 41 if n = 100" in {
      P050.solve(100) must beEqualTo(41)
    }

    "returns 953 if n = 1000" in {
      P050.solve(1000) must beEqualTo(953)
    }

    "returns 997651 if n = 1000000" in {
      P050.solve(1000000) must beEqualTo(997651)
    }
  }
}
