package test.project_euler

import project_euler.P023
import org.specs2.mutable._

class P023Spec extends Specification {
  "P023#isAbundant(Long)" should {
    "returns false if n = 6" in {
      P023.isAbundant(6) must beFalse
    }

    "returns false if n = 10" in {
      P023.isAbundant(10) must beFalse
    }

    "returns true if n = 12" in {
      P023.isAbundant(12) must beTrue
    }
  }

  "P023#abundantNumbers" should {
    "first 5 terms are [12, 18, 20, 24, 30]" in {
      P023.abundantNumbers.take(5).toList must beEqualTo(List(12, 18, 20, 24, 30))
    }
  }

  "P023#solve(Long)" should {
    "returns 2766 if n = 100" in {
      P023.solve(100) must beEqualTo(2766)
    }

    "returns 4179871 if n = 28123" in {
      P023.solve(28123) must beEqualTo(4179871)
    }
  }
}
