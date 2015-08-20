package test.project_euler

import project_euler.P004
import org.specs2.mutable._

class P004Spec extends Specification {
  "P004#isPalindromeNumber(Long)" should {
    "returns true if n = 1" in {
      P004.isPalindromeNumber(1) must beTrue
    }

    "returns true if n = 2" in {
      P004.isPalindromeNumber(2) must beTrue
    }

    "returns false if n = 10" in {
      P004.isPalindromeNumber(10) must beFalse
    }

    "returns true if n = 11" in {
      P004.isPalindromeNumber(11) must beTrue
    }

    "returns false if n = 2000" in {
      P004.isPalindromeNumber(2000) must beFalse
    }

    "returns true if n = 2002" in {
      P004.isPalindromeNumber(2002) must beTrue
    }

    "returns false if n = 30010" in {
      P004.isPalindromeNumber(30010) must beFalse
    }

    "returns true if n = 30103" in {
      P004.isPalindromeNumber(30103) must beTrue
    }
  }

  "P004#nDigitNumbers(Int)" should {
    "returns [] if n = 0" in {
      P004.nDigitNumbers(0) must beEmpty
    }

    "returns [1, 2, ... , 9] if n = 1" in {
      P004.nDigitNumbers(1) must beEqualTo(List(1, 2, 3, 4, 5, 6, 7, 8, 9))
    }

    "returns [10, 11, ... , 99] if n = 2" in {
      P004.nDigitNumbers(2) must beEqualTo(List.range(10, 100))
    }

    "returns [100, 101, ... , 999] if n = 3" in {
      P004.nDigitNumbers(3) must beEqualTo(List.range(100, 1000))
    }
  }

  "P004#solve(Int)" should {
    "returns 9009 if n = 2" in {
      P004.solve(2) must beEqualTo(9009)
    }

    "returns 906609 if n = 3" in {
      P004.solve(3) must beEqualTo(906609)
    }
  }
}
