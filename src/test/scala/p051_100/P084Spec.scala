package test.project_euler

import project_euler.P084
import org.specs2.mutable._

class P084Spec extends Specification {
  "P084#solve(Int)" should {
    "returns \"102400\"" in {
      P084.solve(6) must beEqualTo("102400")
    }

    "returns \"101524\"" in {
      P084.solve(4) must beEqualTo("101524")
    }
  }
}
