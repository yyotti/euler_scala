package test.project_euler

import project_euler.P021
import org.specs2.mutable._

class P021Spec extends Specification {
  "P021#solve(300)" should {
    "returns 504 if n = 300" in {
      P021.solve(300) must beEqualTo(504)
    }

    "returns 31626 if n = 10000" in {
      P021.solve(10000) must beEqualTo(31626)
    }
  }
}
