package test.project_euler

import project_euler.P035
import org.specs2.mutable._

class P035Spec extends Specification {
  "P035#solve(Int)" should {
    "returns 13 if n = 100" in {
      P035.solve(100) must beEqualTo(13)
    }

    "returns 55 if n = 1000000" in {
      P035.solve(1000000) must beEqualTo(55)
    }
  }
}
