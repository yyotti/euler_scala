package test.project_euler

import project_euler.P045
import org.specs2.mutable._

class P045Spec extends Specification {
  "P045#isTriangleNumber(Long)" should {
    "returns true if n = 1" in {
      P045.isTriangleNumber(1) must beTrue
    }

    "returns false if n = 2" in {
      P045.isTriangleNumber(2) must beFalse
    }

    "returns true if n = 10" in {
      P045.isTriangleNumber(10) must beTrue
    }
  }

  "P045#isPentagonalNumber(Long)" should {
    "returns true if n = 1" in {
      P045.isPentagonalNumber(1) must beTrue
    }

    "returns false if n = 2" in {
      P045.isPentagonalNumber(2) must beFalse
    }

    "returns true if n = 12" in {
      P045.isPentagonalNumber(12) must beTrue
    }
  }

  "P045#hexagonalNumbers" should {
    "first 10 terms are [1, 6, 15, 28, 45, 66, 91, 120, 153, 190]" in {
      P045.hexagonalNumbers.take(10).toList must beEqualTo(List(1, 6, 15, 28, 45, 66, 91, 120, 153, 190))
    }
  }

  "P045#solve" should {
    "returns 1533776805" in {
      P045.solve must beEqualTo(1533776805)
    }
  }
}
