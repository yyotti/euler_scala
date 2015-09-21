package test.project_euler

import project_euler.P064
import org.specs2.mutable._

class P064Spec extends Specification {
  "P064#continuedFractions(Int)" should {
    "returns Some(1, [2]) if n = 2" in {
      P064.continuedFractions(2) must beSome((1, List(2)))
    }

    "returns Some(1, [1, 2]) if n = 3" in {
      P064.continuedFractions(3) must beSome((1, List(1, 2)))
    }

    "returns None if n = 4" in {
      P064.continuedFractions(4) must beNone
    }

    "returns Some(2, [4]) if n = 5" in {
      P064.continuedFractions(5) must beSome((2, List(4)))
    }

    "returns Some(2, [2, 4]) if n = 6" in {
      P064.continuedFractions(6) must beSome((2, List(2, 4)))
    }

    "returns Some(2, [1, 1, 1, 4]) if n = 7" in {
      P064.continuedFractions(7) must beSome((2, List(1, 1, 1, 4)))
    }

    "returns Some(2, [1, 4]) if n = 8" in {
      P064.continuedFractions(8) must beSome((2, List(1, 4)))
    }

    "returns None if n = 9" in {
      P064.continuedFractions(9) must beNone
    }

    "returns Some(3, [6]) if n = 10" in {
      P064.continuedFractions(10) must beSome((3, List(6)))
    }

    "returns Some(3, [3, 6]) if n = 11" in {
      P064.continuedFractions(11) must beSome((3, List(3, 6)))
    }

    "returns Some(3, [2, 6]) if n = 12" in {
      P064.continuedFractions(12) must beSome((3, List(2, 6)))
    }

    "returns Some(3, [1, 1, 1, 1, 6]) if n = 13" in {
      P064.continuedFractions(13) must beSome((3, List(1, 1, 1, 1, 6)))
    }
  }

  "P064#solve(Int)" should {
    "returns 4 if n = 13" in {
      P064.solve(13) must beEqualTo(4)
    }

    "returns 1322 if n = 10000" in {
      P064.solve(10000) must beEqualTo(1322)
    }
  }
}
