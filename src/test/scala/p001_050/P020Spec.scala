package test.project_euler

import project_euler.P020
import org.specs2.mutable._

class P020Spec extends Specification {
  "P020#solve(Int)" should {
    "returns 27 if n = 10" in {
      P020.solve(10) must beEqualTo(27)
    }

    "returns 648 if n = 100" in {
      P020.solve(100) must beEqualTo(648)
    }
  }
}
