package test.project_euler

import project_euler.P069
import org.specs2.mutable._

class P069Spec extends Specification {
  "P069#solve(Int)" should {
    "returns 6 if n = 10" in {
      P069.solve(10) must beEqualTo(6)
    }

    "returns 510510 if n = 1000000" in {
      P069.solve(1000000) must beEqualTo(510510)
    }
  }
}
