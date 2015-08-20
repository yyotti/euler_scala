package test.project_euler

import project_euler.P001
import org.specs2.mutable._

class P001Spec extends Specification {
  "P001#solve(n)" should {
    "returns 23 if n is 10" in {
      P001.solve(10) must beEqualTo(23)
    }

    "returns 233168 if n is 1000" in {
      P001.solve(1000) must beEqualTo(233168)
    }
  }
}
