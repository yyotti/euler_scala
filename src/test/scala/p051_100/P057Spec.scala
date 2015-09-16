package test.project_euler

import project_euler.P057
import project_euler.P057.Fraction
import org.specs2.mutable._

class P057Spec extends Specification {
  "P057#Int2Fraction(Int)" should {
    "returns 3/1 if i = 3" in {
      P057.Int2Fraction(3) must beEqualTo(Fraction(3, 1))
    }
  }

  "P057#BigInt2Fraction(BigInt)" should {
    "returns 3/1 if i = 3" in {
      P057.BigInt2Fraction(3) must beEqualTo(Fraction(3, 1))
    }
  }

  "P057#Fraction(Long, Long)" should {
    "returns 2/3 if (n, d) = (2, 3)" in {
      Fraction(2, 3) must beEqualTo(Fraction(2, 3))
    }
  }

  "P057#Fraction(Fraction, Fraction)" should {
    "returns 3/2 if (n, d) = (1, 2/3)" in {
      Fraction(1, Fraction(2, 3)) must beEqualTo(Fraction(3, 2))
    }
  }

  "Fraction#+(Fraction)" should {
    "returns 3/2 if (this, that) = (1, 1/2)" in {
      (1 + Fraction(1, 2)) must beEqualTo(Fraction(3, 2))
    }

    "returns 5/6 if (this, that) = (1/3, 1/2)" in {
      (Fraction(1, 3) + Fraction(1, 2)) must beEqualTo(Fraction(5, 6))
    }

    "returns 29/24 if (this, that) = (5/6, 3/8)" in {
      (Fraction(5, 6) + Fraction(3, 8)) must beEqualTo(Fraction(29, 24))
    }
  }

  "Fraction#*(Fraction)" should {
    "returns 1/2 if (this, that) = (1, 1/2)" in {
      (1 * Fraction(1, 2)) must beEqualTo(Fraction(1, 2))
    }

    "returns 1/6 if (this, that) = (1/3, 1/2)" in {
      (Fraction(1, 3) * Fraction(1, 2)) must beEqualTo(Fraction(1, 6))
    }

    "returns 6/5 if (this, that) = (3/4, 8/5)" in {
      (Fraction(3, 4) * Fraction(8, 5)) must beEqualTo(Fraction(6, 5))
    }
  }

  "P057#frac(Int)" should {
    "returns 1/2 if n = 1" in {
      P057.frac(1) must beEqualTo(Fraction(1, 2))
    }

    "returns 2/5 if n = 2" in {
      P057.frac(2) must beEqualTo(Fraction(2, 5))
    }

    "returns 5/12 if n = 3" in {
      P057.frac(3) must beEqualTo(Fraction(5, 12))
    }

    "returns 12/29 if n = 4" in {
      P057.frac(4) must beEqualTo(Fraction(12, 29))
    }
  }

  "P057#solve(Int)" should {
    "returns 1 if n = 8" in {
      P057.solve(8) must beEqualTo(1)
    }

    "returns 153 if n = 1000" in {
      P057.solve(1000) must beEqualTo(153)
    }
  }
}
