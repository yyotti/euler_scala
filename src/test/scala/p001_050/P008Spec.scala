package test.project_euler

import project_euler.P008
import org.specs2.mutable._

class P008Spec extends Specification {
  "P008#solve(Int)" should {
    "returns 5832 if n = 4" in {
      P008.solve(4) must beEqualTo(5832)
    }

    "returns 23514624000 if n = 13" in {
      P008.solve(13) must beEqualTo(23514624000L)
    }
  }
}
