package test.project_euler

import project_euler.P077
import org.specs2.mutable._

class P077Spec extends Specification {
  "P077#solve(Int)" should {
    "returns 10 if n = 5" in {
      P077.solve(5) must beEqualTo(10)
    }

    "returns 71 if n = 5000" in {
      P077.solve(5000) must beEqualTo(71)
    }
  }
}
