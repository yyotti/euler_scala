package test.project_euler

import project_euler.P016
import org.specs2.mutable._

class P016Spec extends Specification {
  "P016#solve(Int)" should {
    "returns 26 if n = 15" in {
      P016.solve(15) must beEqualTo(26)
    }

    "returns 1366 if n = 1000" in {
      P016.solve(1000) must beEqualTo(1366)
    }
  }
}
