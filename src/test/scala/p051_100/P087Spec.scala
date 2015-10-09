package test.project_euler

import project_euler.P087
import org.specs2.mutable._

class P087Spec extends Specification {
  "P087#solve(Int)" should {
    "returns 4 if n = 50" in {
      P087.solve(50) must beEqualTo(4)
    }

    "returns 1097343 if n = 50000000" in {
      P087.solve(50000000) must beEqualTo(1097343)
    }
  }
}
