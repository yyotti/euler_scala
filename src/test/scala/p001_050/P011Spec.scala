package test.project_euler

import project_euler.P011
import org.specs2.mutable._

class P011Spec extends Specification {
  "P011#getHorizontalNums(Int, Int, Int)" should {
    "returns [8, 2, 22, 97] if (i, j, n) = (0, 0, 4)" in {
      P011.getHorizontalNums(0, 0, 4) must beEqualTo(Array(8, 2, 22, 97))
    }

    "returns [18, 8, 46, 29, 32] if (i, j, n) = (16, 11, 5)" in {
      P011.getHorizontalNums(16, 11, 5) must beEqualTo(Array(18, 8, 46, 29, 32))
    }

    "returns [] if (i, j, n) = (20, 0, 3)" in {
      P011.getHorizontalNums(20, 0, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 20, 3)" in {
      P011.getHorizontalNums(14, 20, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 16, 5)" in {
      P011.getHorizontalNums(14, 16, 5) must beEqualTo(Array.empty)
    }
  }

  "P011#getVerticalNums(Int, Int, Int)" should {
    "returns [8, 49, 81, 52] if (i, j, n) = (0, 0, 4)" in {
      P011.getVerticalNums(0, 0, 4) must beEqualTo(Array(8, 49, 81, 52))
    }

    "returns [18, 69, 71] if (i, j, n) = (16, 11, 3)" in {
      P011.getVerticalNums(16, 11, 3) must beEqualTo(Array(18, 69, 71))
    }

    "returns [] if (i, j, n) = (20, 0, 3)" in {
      P011.getVerticalNums(20, 0, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 20, 3)" in {
      P011.getVerticalNums(14, 20, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 16, 7)" in {
      P011.getVerticalNums(14, 16, 7) must beEqualTo(Array.empty)
    }
  }

  "P011#getDiagonalNums1(Int, Int, Int)" should {
    "returns [8, 49, 31, 23] if (i, j, n) = (0, 0, 4)" in {
      P011.getDiagonalNums1(0, 0, 4) must beEqualTo(Array(8, 49, 31, 23))
    }

    "returns [18, 82, 86, 52] if (i, j, n) = (16, 11, 4)" in {
      P011.getDiagonalNums1(16, 11, 4) must beEqualTo(Array(18, 82, 86, 52))
    }

    "returns [] if (i, j, n) = (20, 0, 3)" in {
      P011.getDiagonalNums1(20, 0, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 20, 3)" in {
      P011.getDiagonalNums1(14, 20, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 16, 7)" in {
      P011.getDiagonalNums1(14, 16, 7) must beEqualTo(Array.empty)
    }
  }

  "P011#getDiagonalNums2(Int, Int, Int)" should {
    "returns [8, 62, 13, 37] if (i, j, n) = (0, 19, 4)" in {
      P011.getDiagonalNums2(0, 19, 4) must beEqualTo(Array(8, 62, 13, 37))
    }

    "returns [18, 99, 31, 16] if (i, j, n) = (16, 11, 4)" in {
      P011.getDiagonalNums2(16, 11, 4) must beEqualTo(Array(18, 99, 31, 16))
    }

    "returns [] if (i, j, n) = (20, 0, 3)" in {
      P011.getDiagonalNums2(20, 0, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 20, 3)" in {
      P011.getDiagonalNums2(14, 20, 3) must beEqualTo(Array.empty)
    }

    "returns [] if (i, j, n) = (14, 16, 7)" in {
      P011.getDiagonalNums2(14, 16, 7) must beEqualTo(Array.empty)
    }
  }

  "P011#solve(Int)" should {
    "returns 70600674 if n = 4" in {
      P011.solve(4) must beEqualTo(70600674)
    }
  }
}
