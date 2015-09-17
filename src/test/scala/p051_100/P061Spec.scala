package test.project_euler

import project_euler.P061
import org.specs2.mutable._

class P061Spec extends Specification {
  "P061#solve(Int)" should {
    "returns 19291 if n = 3" in {
      P061.solve(3) must beEqualTo(19291)
    }

    "returns 28684 if n = 6" in {
      P061.solve(6) must beEqualTo(28684)
    }
  }
}
