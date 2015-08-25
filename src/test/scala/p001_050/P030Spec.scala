package test.project_euler

import project_euler.P030
import org.specs2.mutable._

class P030Spec extends Specification {
  "P030#findMaxDigits(Int)" should {
    "returns 3 if n = 2" in {
      P030.findMaxDigits(2) must beEqualTo(3)
    }

    "returns 4 if n = 3" in {
      P030.findMaxDigits(3) must beEqualTo(4)
    }

    "returns 5 if n = 4" in {
      P030.findMaxDigits(4) must beEqualTo(5)
    }

    "returns 6 if n = 5" in {
      P030.findMaxDigits(5) must beEqualTo(6)
    }
  }

  "P030#solve(Int)" should {
    "returns 19316 if n = 4" in {
      P030.solve(4) must beEqualTo(19316)
    }

    "returns 443839 if n = 5" in {
      P030.solve(5) must beEqualTo(443839)
    }
  }
}
