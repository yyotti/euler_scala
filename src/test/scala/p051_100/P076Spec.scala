package test.project_euler

import project_euler.P076
import org.specs2.mutable._

class P076Spec extends Specification {
  "P076#solve(Int)" should {
    "returns 0 if n = 1" in {
      P076.solve(1) must beEqualTo(0)
    }

    "returns 1 if n = 2" in {
      P076.solve(2) must beEqualTo(1)
    }

    "returns 2 if n = 3" in {
      P076.solve(3) must beEqualTo(2)
    }

    "returns 4 if n = 4" in {
      P076.solve(4) must beEqualTo(4)
    }

    "returns 6 if n = 5" in {
      P076.solve(5) must beEqualTo(6)
    }

    "returns 10 if n = 6" in {
      P076.solve(6) must beEqualTo(10)
    }

    "returns 14 if n = 7" in {
      P076.solve(7) must beEqualTo(14)
    }

    "returns 21 if n = 8" in {
      P076.solve(8) must beEqualTo(21)
    }

    "returns 190569291 if n = 100" in {
      P076.solve(100) must beEqualTo(190569291)
    }
  }
}
