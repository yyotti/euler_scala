package test.project_euler

import project_euler.P031
import org.specs2.mutable._

class P031Spec extends Specification {
  "P031#solve(Int)" should {
    "throws IllegalArgumentException if n = -1" in {
      P031.solve(-1) must throwA[IllegalArgumentException]
    }

    "returns 1 if n = 0" in {
      P031.solve(0) must beEqualTo(1)
    }

    "returns 1 if n = 1" in {
      P031.solve(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P031.solve(2) must beEqualTo(2)
    }

    "returns 2 if n = 3" in {
      P031.solve(3) must beEqualTo(2)
    }

    "returns 73682 patterns if n = 200" in {
      P031.solve(200) must beEqualTo(73682)
    }
  }
}
