package test.project_euler

import project_euler.P053
import org.specs2.mutable._

class P053Spec extends Specification {
  "P053#combination(BigInt, BigInt)" should {
    "returns 1" in {
      P053.combination(3, 0) must beEqualTo(1)
    }

    "returns 3" in {
      P053.combination(3, 1) must beEqualTo(3)
    }

    "returns 10" in {
      P053.combination(5, 3) must beEqualTo(10)
    }
  }

  "P053#solve" should {
    "returns 4075" in {
      P053.solve must beEqualTo(4075)
    }
  }
}
