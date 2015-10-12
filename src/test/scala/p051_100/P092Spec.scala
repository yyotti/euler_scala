package test.project_euler

import project_euler.P092
import org.specs2.mutable._

class P092Spec extends Specification {
  "P092#solve(Int)" should {
    "returns 7 if n = 10" in {
      P092.solve(10) must beEqualTo(7)
    }

    "returns 8581146 if n = 10000000" in {
      P092.solve(10000000) must beEqualTo(8581146)
    }
  }
}
