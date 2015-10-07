package test.project_euler

import project_euler.P086
import org.specs2.mutable._

class P086Spec extends Specification {
  "P086#solve(Int)" should {
    "returns 100 if n = 2000" in {
      P086.solve(2000) must beEqualTo(100)
    }

    "returns 1818 if n = 1000000" in {
      P086.solve(1000000) must beEqualTo(1818)
    }
  }
}
