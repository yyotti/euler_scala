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

  "P004#solve(Int)" should {
    "returns 9009 if n = 2" in {
      P004.solve(2) must beEqualTo(9009)
    }

    "returns 906609 if n = 3" in {
      P004.solve(3) must beEqualTo(906609)
    }
  }
}
