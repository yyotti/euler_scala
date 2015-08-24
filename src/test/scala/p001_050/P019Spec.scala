package test.project_euler

import project_euler.P019
import org.specs2.mutable._

class P019Spec extends Specification {
  "P019#isLeapYear(Int)" should {
    "returns true if year = 2000" in {
      P019.isLeapYear(2000) must beTrue
    }

    "returns false if year = 1900" in {
      P019.isLeapYear(1900) must beFalse
    }

    "returns true if year = 1904" in {
      P019.isLeapYear(1904) must beTrue
    }
  }

  "P019#dateCount(Int, Int)" should {
    "returns 29 if (year, month) = (2000, 2)" in {
      P019.dateCount(2000, 2) must beEqualTo(29)
    }

    "returns 28 if (year, month) = (1900, 2)" in {
      P019.dateCount(1900, 2) must beEqualTo(28)
    }

    "returns 30 if (year, month) = (2000, 4)" in {
      P019.dateCount(2000, 4) must beEqualTo(30)
    }

    "returns 30 if (year, month) = (2000, 9)" in {
      P019.dateCount(2000, 9) must beEqualTo(30)
    }

    "returns 30 if (year, month) = (1900, 4)" in {
      P019.dateCount(1900, 4) must beEqualTo(30)
    }

    "returns 30 if (year, month) = (1900, 9)" in {
      P019.dateCount(1900, 9) must beEqualTo(30)
    }

    "returns 31 if (year, month) = (2000, 5)" in {
      P019.dateCount(2000, 5) must beEqualTo(31)
    }

    "returns 31 if (year, month) = (2000, 10)" in {
      P019.dateCount(2000, 10) must beEqualTo(31)
    }

    "returns 31 if (year, month) = (1900, 5)" in {
      P019.dateCount(1900, 5) must beEqualTo(31)
    }

    "returns 31 if (year, month) = (1900, 10)" in {
      P019.dateCount(1900, 10) must beEqualTo(31)
    }
  }

  "P019#solve" should {
    "returns 171" in {
      P019.solve must beEqualTo(171)
    }
  }
}
