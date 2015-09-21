package test.project_euler

import project_euler.P065
import project_euler.P065.Fraction
import org.specs2.mutable._

class P065Spec extends Specification {
  "P065#efrac(Int)" should {
    "returns 2/1 if n = 1" in {
      P065.efrac(1) must beEqualTo(Fraction(2, 1))
    }

    "returns 3/1 if n = 2" in {
      P065.efrac(2) must beEqualTo(Fraction(3, 1))
    }

    "returns 8/3 if n = 3" in {
      P065.efrac(3) must beEqualTo(Fraction(8, 3))
    }

    "returns 11/4 if n = 4" in {
      P065.efrac(4) must beEqualTo(Fraction(11, 4))
    }

    "returns 19/7 if n = 5" in {
      P065.efrac(5) must beEqualTo(Fraction(19, 7))
    }

    "returns 1457/536 if n = 10" in {
      P065.efrac(10) must beEqualTo(Fraction(1457, 536))
    }
  }

  "P065#solve(Int)" should {
    "returns 17 if n = 10" in {
      P065.solve(10) must beEqualTo(17)
    }

    "returns 272 if n = 100" in {
      P065.solve(100) must beEqualTo(272)
    }
  }
}
