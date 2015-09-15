package test.project_euler

import project_euler.P005
import org.specs2.mutable._

class P005Spec extends Specification {
  "P005#solve(Int)" should {
    "returns 2520 if n = 10" in {
      P005.solve(10) must beEqualTo(2520)
    }

    "returns 232792560 if n = 20" in {
      P005.solve(20) must beEqualTo(232792560)
    }
  }
}
