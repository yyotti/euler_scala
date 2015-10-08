package test.project_euler

import project_euler.P086
import org.specs2.mutable._

class P086Spec extends Specification {
  "P086#countMinRoutes(Int)" should {
    "returns 0 if m = 0" in {
      P086.countMinRoutes(0) must beEqualTo(0)
    }

    "returns 0 if m = 1" in {
      P086.countMinRoutes(1) must beEqualTo(0)
    }

    "returns 0 if m = 2" in {
      P086.countMinRoutes(2) must beEqualTo(0)
    }

    "returns 2 if m = 3" in {
      P086.countMinRoutes(3) must beEqualTo(2)
    }

    "returns 3 if m = 4" in {
      P086.countMinRoutes(4) must beEqualTo(3)
    }

    "returns 3 if m = 5" in {
      P086.countMinRoutes(5) must beEqualTo(3)
    }

    "returns 6 if m = 6" in {
      P086.countMinRoutes(6) must beEqualTo(6)
    }

    "returns 6 if m = 7" in {
      P086.countMinRoutes(7) must beEqualTo(6)
    }

    "returns 10 if m = 8" in {
      P086.countMinRoutes(8) must beEqualTo(10)
    }

    "returns 14 if m = 9" in {
      P086.countMinRoutes(9) must beEqualTo(14)
    }

    "returns 67 if m = 20" in {
      P086.countMinRoutes(20) must beEqualTo(67)
    }

    "returns 85 if m = 21" in {
      P086.countMinRoutes(21) must beEqualTo(85)
    }
  }

  "P086#solve(Int)" should {
    "returns 9 if n = 10" in {
      P086.solve(10) must beEqualTo(9)
    }

    "returns 100 if n = 2000" in {
      P086.solve(2000) must beEqualTo(100)
    }

    "returns 1818 if n = 1000000" in {
      P086.solve(1000000) must beEqualTo(1818)
    }
  }
}
