package test.project_euler

import project_euler.P080
import org.specs2.mutable._

class P080Spec extends Specification {
  "P080#solve(Int)" should {
    "returns 475 if n = 2" in {
      P080.solve(2) must beEqualTo(475)
    }

    "returns 40886 if n = 100" in {
      P080.solve(100) must beEqualTo(40886)
    }
  }
}
