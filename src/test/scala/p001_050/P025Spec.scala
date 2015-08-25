package test.project_euler

import project_euler.P025
import org.specs2.mutable._

class P025Spec extends Specification {
  "P025#solve(Int)" should {
    "returns 12 if digit = 3" in {
      P025.solve(3) must beEqualTo(12)
    }

    "returns 4782 if digit = 1000" in {
      P025.solve(1000) must beEqualTo(4782)
    }
  }
}
