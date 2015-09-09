package test.project_euler

import project_euler.P044
import org.specs2.mutable._

class P044Spec extends Specification {
  "P044#pentagonalNumbers" should {
    "first 10 terms are [1, 5, 12, 22, 35, 51, 70, 92, 117, 145]" in {
      P044.pentagonalNumbers.take(10).toList must beEqualTo(List(1, 5, 12, 22, 35, 51, 70, 92, 117, 145))
    }
  }

  "P044#isPentagonalNumber(Long)" should {
    "returns true if n = 1" in {
      P044.isPentagonalNumber(1) must beTrue
    }

    "returns false if n = 2" in {
      P044.isPentagonalNumber(2) must beFalse
    }

    "returns true if n = 12" in {
      P044.isPentagonalNumber(12) must beTrue
    }
  }

  "P044#solve" should {
    "returns 5482660" in {
      P044.solve must beEqualTo(5482660)
    }
  }
}
