package test.project_euler

import project_euler.P026
import org.specs2.mutable._

class P026Spec extends Specification {
  "P026#solve(Int)" should {
    "returns 7 if max = 10" in {
      P026.solve(10) must beEqualTo(7)
    }

    "returns 983 if max = 1000" in {
      P026.solve(1000) must beEqualTo(983)
    }
  }
}
