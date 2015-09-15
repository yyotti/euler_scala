package test.project_euler

import project_euler.P055
import org.specs2.mutable._

class P055Spec extends Specification {
  "P055#isLychrelNumber(BigInt)" should {
    "returns false if n = 47" in {
      P055.isLychrelNumber(47) must beFalse
    }

    "returns false if n = 349" in {
      P055.isLychrelNumber(349) must beFalse
    }

    "returns true if n = 196" in {
      P055.isLychrelNumber(196) must beTrue
    }

    "returns true if n = 4994" in {
      P055.isLychrelNumber(4994) must beTrue
    }
  }

  "P055#solve" should {
    "returns 249" in {
      P055.solve must beEqualTo(249)
    }
  }
}
