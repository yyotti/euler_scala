package test.project_euler

import project_euler.P085
import org.specs2.mutable._

class P085Spec extends Specification {
  "P085#phi" should {
    "first 10 terms are [1, 3, 6, 10, 15, 21, 28, 36, 45, 55]" in {
      P085.phi.take(10).toList must beEqualTo(List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55))
    }
  }

  "P085#findPhiPair(Int)" should {
    "returns Some((1, 1)) if n = 1" in {
      P085.findPhiPair(1) must beSome((1, 1))
    }

    "returns Some((1, 1)) if n = 2" in {
      P085.findPhiPair(2) must beNone
    }

    "returns Some((1, 3)) if n = 3" in {
      P085.findPhiPair(3) must beSome((1, 3))
    }

    "returns Some((1, 3)) if n = 4" in {
      P085.findPhiPair(4) must beNone
    }

    "returns Some((1, 6)) if n = 6" in {
      P085.findPhiPair(6) must beSome((1, 6))
    }

    "returns Some((3, 6)) if n = 18" in {
      P085.findPhiPair(18) must beSome((3, 6))
    }
  }

  "P085#solve(Int)" should {
    "returns 6 if n = 18" in {
      P085.solve(18) must beEqualTo(6)
    }

    "returns 8 if n = 33" in {
      P085.solve(33) must beEqualTo(8)
    }

    "returns 2772 if n = 2000000" in {
      P085.solve(2000000) must beEqualTo(2772)
    }
  }
}
