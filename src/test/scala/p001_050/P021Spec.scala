package test.project_euler

import project_euler.P021
import org.specs2.mutable._

class P021Spec extends Specification {
  "P021#d(Int)" should {
    "returns 0 if n = 1" in {
      P021.d(1) must beEqualTo(0)
    }

    "returns 1 if n = 2" in {
      P021.d(2) must beEqualTo(1)
    }

    "returns 3 if n = 4" in {
      P021.d(4) must beEqualTo(3)
    }

    "returns 284 if n = 220" in {
      P021.d(220) must beEqualTo(284)
    }
  }

  "P021#solve(300)" should {
    "returns 504 if n = 300" in {
      P021.solve(300) must beEqualTo(504)
    }

    "returns 31626 if n = 10000" in {
      P021.solve(10000) must beEqualTo(31626)
    }
  }
}
