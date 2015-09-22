package test.project_euler

import project_euler.P066
import org.specs2.mutable._

class P066Spec extends Specification {
  "P066#findMinX(Long)" should {
    "returns 3 if d = 2" in {
      P066.findMinX(2) must beEqualTo(3)
    }

    "returns 2 if d = 3" in {
      P066.findMinX(3) must beEqualTo(2)
    }

    "returns 9 if d = 5" in {
      P066.findMinX(5) must beEqualTo(9)
    }

    "returns 5 if d = 6" in {
      P066.findMinX(6) must beEqualTo(5)
    }

    "returns 8 if d = 7" in {
      P066.findMinX(7) must beEqualTo(8)
    }

    "returns 3 if d = 8" in {
      P066.findMinX(8) must beEqualTo(3)
    }

    "returns 19 if d = 10" in {
      P066.findMinX(10) must beEqualTo(19)
    }
  }

  "P066#isSquareNumber(Long)" should {
    "returns true if d = 1" in {
      P066.isSquareNumber(1) must beTrue
    }

    "returns false if d = 2" in {
      P066.isSquareNumber(2) must beFalse
    }

    "returns false if d = 3" in {
      P066.isSquareNumber(3) must beFalse
    }

    "returns true if d = 4" in {
      P066.isSquareNumber(4) must beTrue
    }

    "returns false if d = 5" in {
      P066.isSquareNumber(5) must beFalse
    }

    "returns false if d = 6" in {
      P066.isSquareNumber(6) must beFalse
    }

    "returns false if d = 7" in {
      P066.isSquareNumber(7) must beFalse
    }

    "returns false if d = 8" in {
      P066.isSquareNumber(8) must beFalse
    }

    "returns true if d = 9" in {
      P066.isSquareNumber(9) must beTrue
    }

    "returns false if d = 10" in {
      P066.isSquareNumber(10) must beFalse
    }
  }

  "P066#solve(Int)" should {
    "returns 5 if n = 7" in {
      P066.solve(7) must beEqualTo(5)
    }

    "returns 661 if n = 1000" in {
      P066.solve(1000) must beEqualTo(661)
    }
  }
}
