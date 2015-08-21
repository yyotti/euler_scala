package test.project_euler

import project_euler.P007
import org.specs2.mutable._

class P007Spec extends Specification {
  "P007#solve(Int)" should {
    "returns 13 if n = 6" in {
      P007.solve(6) must beEqualTo(13)
    }

    "returns 104743 if n = 10001" in {
      P007.solve(10001) must beEqualTo(104743)
    }
  }
}
