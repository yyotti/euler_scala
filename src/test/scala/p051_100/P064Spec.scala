package test.project_euler

import project_euler.P064
import org.specs2.mutable._

class P064Spec extends Specification {
  "P064#solve(Int)" should {
    "returns 4 if n = 13" in {
      P064.solve(13) must beEqualTo(4)
    }

    "returns 1322 if n = 10000" in {
      P064.solve(10000) must beEqualTo(1322)
    }
  }
}
