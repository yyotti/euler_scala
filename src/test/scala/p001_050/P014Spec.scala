package test.project_euler

import project_euler.P014
import org.specs2.mutable._

class P014Spec extends Specification {
  "P014#solve(1000000)" should {
    "returns 837799 if n = 1000000" in {
      P014.solve(1000000) must beEqualTo(837799)
    }
  }
}
