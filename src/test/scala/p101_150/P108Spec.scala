package test.project_euler

import project_euler.P108
import org.specs2.mutable._

class P108Spec extends Specification {
  "P108#countAnswers(Int)" should {
    "returns 1 if n = 1" in {
      P108.countAnswers(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P108.countAnswers(2) must beEqualTo(2)
    }

    "returns 2 if n = 3" in {
      P108.countAnswers(3) must beEqualTo(2)
    }

    "returns 3 if n = 4" in {
      P108.countAnswers(4) must beEqualTo(3)
    }

    "returns 2 if n = 5" in {
      P108.countAnswers(5) must beEqualTo(2)
    }

    "returns 5 if n = 6" in {
      P108.countAnswers(6) must beEqualTo(5)
    }
  }

  "P108#solve(Int)" should {
    "returns 12 if n = 5" in {
      P108.solve(5) must beEqualTo(12)
    }

    "returns 24 if n = 10" in {
      P108.solve(10) must beEqualTo(24)
    }

    "returns 180180 if n = 1000" in {
      P108.solve(1000) must beEqualTo(180180)
    }
  }
}
