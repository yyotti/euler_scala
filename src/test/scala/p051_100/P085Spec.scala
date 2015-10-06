package test.project_euler

import project_euler.P085
import org.specs2.mutable._

class P085Spec extends Specification {
  "P085#solve(Int)" should {
    "returns 2772 if n = 2000000" in {
      P085.solve(2000000) must beEqualTo(2772)
    }
  }
}
