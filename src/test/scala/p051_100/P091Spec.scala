package test.project_euler

import project_euler.P091
import org.specs2.mutable._

class P091Spec extends Specification {
  "P091#isRightTriangle((Int, Int), (Int, Int))" should {
    "returns true if (p, q) = ((1, 0), (0, 1))" in {
      P091.isRightTriangle((1, 0), (0, 1)) must beTrue
    }

    "returns true if (p, q) = ((2, 0), (0, 1))" in {
      P091.isRightTriangle((2, 0), (0, 1)) must beTrue
    }

    "returns true if (p, q) = ((1, 0), (0, 2))" in {
      P091.isRightTriangle((1, 0), (0, 2)) must beTrue
    }

    "returns false if (p, q) = ((2, 1), (0, 2))" in {
      P091.isRightTriangle((2, 1), (0, 2)) must beFalse
    }

    "returns true if (p, q) = ((1, 1), (2, 0))" in {
      P091.isRightTriangle((1, 1), (2, 0)) must beTrue
    }
  }

  "P091#solve(Int)" should {
    "returns 14 if n = 2" in {
      P091.solve(2) must beEqualTo(14)
    }

    "returns 14234 if n = 50" in {
      P091.solve(50) must beEqualTo(14234)
    }
  }
}
