package test.project_euler

import project_euler.P073
import org.specs2.mutable._

class P073Spec extends Specification {
  "P073#solve" should {
    "returns 3 if d = 8" in {
      P073.solve(8) must beEqualTo(3)
    }

    "returns 7295372 if d = 12000" in {
      P073.solve(12000) must beEqualTo(7295372)
    }
  }
}
