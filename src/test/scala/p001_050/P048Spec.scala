package test.project_euler

import project_euler.P048
import org.specs2.mutable._

class P048Spec extends Specification {
  "P048#solve(Int)" should {
    "returns 405071317 if n = 10" in {
      P048.solve(10) must beEqualTo(405071317L)
    }

    "returns 9110846700 if n = 1000" in {
      P048.solve(1000) must beEqualTo(9110846700L)
    }
  }
}
