package test.project_euler

import project_euler.P005
import org.specs2.mutable._

class P005Spec extends Specification {
  "P005#gcd(Int, Int)" should {
    "returns 1 if (m, n) = (2, 1)" in {
      P005.gcd(2, 1) must beEqualTo(1)
    }

    "returns 1 if (m, n) = (3, 2)" in {
      P005.gcd(3, 2) must beEqualTo(1)
    }

    "returns 2 if (m, n) = (4, 2)" in {
      P005.gcd(4, 2) must beEqualTo(2)
    }

    "returns 5 if (m, n) = (15, 10)" in {
      P005.gcd(15, 10) must beEqualTo(5)
    }

    "returns 3 if (m, n) = (6, 9)" in {
      P005.gcd(6, 9) must beEqualTo(3)
    }
  }

  "P005#lcm(Int, Int)" should {
    "returns 2 if (m, n) = (2, 1)" in {
      P005.lcm(2, 1) must beEqualTo(2)
    }

    "returns 6 if (m, n) = (3, 2)" in {
      P005.lcm(3, 2) must beEqualTo(6)
    }

    "returns 4 if (m, n) = (4, 2)" in {
      P005.lcm(4, 2) must beEqualTo(4)
    }

    "returns 30 if (m, n) = (15, 10)" in {
      P005.lcm(15, 10) must beEqualTo(30)
    }

    "returns 18 if (m, n) = (6, 9)" in {
      P005.lcm(6, 9) must beEqualTo(18)
    }
  }

  "P005#solve(Int)" should {
    "returns 2520 if n = 10" in {
      P005.solve(10) must beEqualTo(2520)
    }

    "returns 232792560 if n = 20" in {
      P005.solve(20) must beEqualTo(232792560)
    }
  }
}
