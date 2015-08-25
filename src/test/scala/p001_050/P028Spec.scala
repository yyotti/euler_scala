package test.project_euler

import project_euler.P028
import org.specs2.mutable._

class P028Spec extends Specification {
  "P028#solve(Int)" should {
    "returns 101 if n = 5" in {
      P028.solve(5) must beEqualTo(101)
    }

    "returns 669171001 if n = 1001" in {
      P028.solve(1001) must beEqualTo(669171001)
    }
  }
}
