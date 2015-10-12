package test.project_euler

import project_euler.P091
import org.specs2.mutable._

class P091Spec extends Specification {
  "P091#solve(Int)" should {
    "returns 14 if n = 2" in {
      P091.solve(2) must beEqualTo(14)
    }

    "returns 14234 if n = 50" in {
      P091.solve(50) must beEqualTo(14234)
    }
  }
}
