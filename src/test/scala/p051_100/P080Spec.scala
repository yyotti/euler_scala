package test.project_euler

import project_euler.P080
import project_euler.P080.Fraction
import org.specs2.mutable._

class P080Spec extends Specification {
  "P080#continuedFractions(Int)" should {
    "returns Some(1, [2]) if n = 2" in {
      P080.continuedFractions(2) must beSome((1, List(2)))
    }

    "returns Some(1, [1, 2]) if n = 3" in {
      P080.continuedFractions(3) must beSome((1, List(1, 2)))
    }

    "returns None if n = 4" in {
      P080.continuedFractions(4) must beNone
    }

    "returns Some(2, [4]) if n = 5" in {
      P080.continuedFractions(5) must beSome((2, List(4)))
    }

    "returns Some(2, [2, 4]) if n = 6" in {
      P080.continuedFractions(6) must beSome((2, List(2, 4)))
    }

    "returns Some(2, [1, 1, 1, 4]) if n = 7" in {
      P080.continuedFractions(7) must beSome((2, List(1, 1, 1, 4)))
    }

    "returns Some(2, [1, 4]) if n = 8" in {
      P080.continuedFractions(8) must beSome((2, List(1, 4)))
    }

    "returns None if n = 9" in {
      P080.continuedFractions(9) must beNone
    }

    "returns Some(3, [6]) if n = 10" in {
      P080.continuedFractions(10) must beSome((3, List(6)))
    }

    "returns Some(3, [3, 6]) if n = 11" in {
      P080.continuedFractions(11) must beSome((3, List(3, 6)))
    }

    "returns Some(3, [2, 6]) if n = 12" in {
      P080.continuedFractions(12) must beSome((3, List(2, 6)))
    }

    "returns Some(3, [1, 1, 1, 1, 6]) if n = 13" in {
      P080.continuedFractions(13) must beSome((3, List(1, 1, 1, 1, 6)))
    }
  }

  "P080#div(Int, Int, Int)" should {
    "returns [] if (n, d, count) = (1, 2, 0)" in {
      P080.div(1, 2, 0) must beEmpty
    }

    "returns [] if (n, d, count) = (3, 2, 0)" in {
      P080.div(3, 2, 0) must beEmpty
    }

    "returns [2] if (n, d, count) = (2, 1, 3)" in {
      P080.div(2, 1, 3) must beEqualTo(List(2))
    }

    "returns [1, 5] if (n, d, count) = (3, 2, 3)" in {
      P080.div(3, 2, 3) must beEqualTo(List(1, 5))
    }

    "returns [3, 3, 3, 3, 3, 3] if (n, d, count) = (10, 3, 6)" in {
      P080.div(10, 3, 6) must beEqualTo(List(3, 3, 3, 3, 3, 3))
    }
  }

  "P080#appr(Int, Stream[Int], Int)" should {
    "returns [1, 4, 1, 4, 2, 1, 3, 5, 6] if (a0, part, count) = (1, [2], 9)" in {
      P080.appr(1, List(2), 9) must beEqualTo(List(1, 4, 1, 4, 2, 1, 3, 5, 6))
    }

    "returns [1, 4, 1, 4, 2, 1, 3, 5, 6, ...] if (a0, part, count) = (1, [2], 99)" in {
      val expected = List(
        1, 4, 1, 4, 2, 1, 3, 5, 6, 2,
        3, 7, 3, 0, 9, 5, 0, 4, 8, 8,
        0, 1, 6, 8, 8, 7, 2, 4, 2, 0,
        9, 6, 9, 8, 0, 7, 8, 5, 6, 9,
        6, 7, 1, 8, 7, 5, 3, 7, 6, 9,
        4, 8, 0, 7, 3, 1, 7, 6, 6, 7,
        9, 7, 3, 7, 9, 9, 0, 7, 3, 2,
        4, 7, 8, 4, 6, 2, 1, 0, 7, 0,
        3, 8, 8, 5, 0, 3, 8, 7, 5, 3,
        4, 3, 2, 7, 6, 4, 1, 5, 7
      )
      P080.appr(1, List(2), 99) must beEqualTo(expected)
    }

    "returns [1, 7, 3, 2, 0, 5, 0, 8] if (a0, part, count) = (1, [1, 2], 8)" in {
      P080.appr(1, List(1, 2), 8) must beEqualTo(List(1, 7, 3, 2, 0, 5, 0, 8))
    }
  }

  "P080#solve(Int)" should {
    "returns 475 if n = 2" in {
      P080.solve(2) must beEqualTo(475)
    }

    "returns 40886 if n = 100" in {
      P080.solve(100) must beEqualTo(40886)
    }
  }
}
