package test.project_euler

import project_euler.P069
import org.specs2.mutable._

class P069Spec extends Specification {
  "P069#totient(Int)" should {
    "returns 1 if n = 1" in {
      P069.totient(1) must beEqualTo(1)
    }

    "returns 1 if n = 2" in {
      P069.totient(2) must beEqualTo(1)
    }

    "returns 2 if n = 3" in {
      P069.totient(3) must beEqualTo(2)
    }

    "returns 2 if n = 4" in {
      P069.totient(4) must beEqualTo(2)
    }

    "returns 4 if n = 5" in {
      P069.totient(5) must beEqualTo(4)
    }

    "returns 2 if n = 6" in {
      P069.totient(6) must beEqualTo(2)
    }

    "returns 6 if n = 7" in {
      P069.totient(7) must beEqualTo(6)
    }

    "returns 4 if n = 8" in {
      P069.totient(8) must beEqualTo(4)
    }

    "returns 6 if n = 9" in {
      P069.totient(9) must beEqualTo(6)
    }

    "returns 4 if n = 10" in {
      P069.totient(10) must beEqualTo(4)
    }
  }

  "P069#solve(Int)" should {
    "returns 6 if n = 10" in {
      P069.solve(10) must beEqualTo(6)
    }

    "returns 510510 if n = 1000000" in {
      P069.solve(1000000) must beEqualTo(510510)
    }
  }
}
