package test.project_euler

import project_euler.P006
import org.specs2.mutable._

class P006Spec extends Specification {
  "P006#solve(Long)" should {
    "returns 2640 if n = 10" in {
      P006.solve(10) must beEqualTo(2640)
    }

    "returns 25164150 if n = 100" in {
      P006.solve(100) must beEqualTo(25164150)
    }
  }
}
