package test.project_euler

import project_euler.P092
import org.specs2.mutable._

class P092Spec extends Specification {
  "P092#sumSquareDigits(Int)" should {
    "returns 0 if n = 0" in {
      P092.sumSquareDigits(0) must beEqualTo(0)
    }

    "returns 1 if n = 1" in {
      P092.sumSquareDigits(1) must beEqualTo(1)
    }

    "returns 4 if n = 2" in {
      P092.sumSquareDigits(2) must beEqualTo(4)
    }

    "returns 5 if n = 12" in {
      P092.sumSquareDigits(12) must beEqualTo(5)
    }

    "returns 1 if n = 1000" in {
      P092.sumSquareDigits(1000) must beEqualTo(1)
    }

    "returns 55 if n = 12345" in {
      P092.sumSquareDigits(12345) must beEqualTo(55)
    }
  }

  "P092#findEnd(Int)" should {
    "returns 1 if n = 44" in {
      P092.findEnd(44) must beEqualTo(1)
    }

    "returns 89 if n = 85" in {
      P092.findEnd(85) must beEqualTo(89)
    }
  }

  "P092#solve(Int)" should {
    "returns 7 if n = 10" in {
      P092.solve(10) must beEqualTo(7)
    }

    "returns 8581146 if n = 10000000" in {
      P092.solve(10000000) must beEqualTo(8581146)
    }
  }
}
