package test.project_euler

import project_euler.P009
import org.specs2.mutable._

class P009Spec extends Specification {
  "P009#isPytagoreanTriplet(Long, Long, Long)" should {
    "returns false if (a, b, c) = (1, 1, 1)" in {
      P009.isPytagoreanTriplet(1, 1, 1) must beFalse
    }

    "returns true if (a, b, c) = (3, 4, 5)" in {
      P009.isPytagoreanTriplet(3, 4, 5) must beTrue
    }

    "returns true if (a, b, c) = (6, 8, 10)" in {
      P009.isPytagoreanTriplet(6, 8, 10) must beTrue
    }
  }

  "P009#solve" should {
    "returns 31875000" in {
      P009.solve must beEqualTo(31875000)
    }
  }
}
