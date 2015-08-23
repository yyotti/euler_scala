package test.project_euler

import project_euler.P012
import org.specs2.mutable._

class P012Spec extends Specification {
  "P012#solve(Int)" should {
    "returns 28 if n = 5" in {
      P012.solve(5) must beEqualTo(28)
    }

    "returns 76576500 if n = 500" in {
      P012.solve(500) must beEqualTo(76576500)
    }
  }
}
