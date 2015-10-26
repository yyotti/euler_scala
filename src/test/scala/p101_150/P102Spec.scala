package test.project_euler

import project_euler.P102
import org.specs2.mutable._

class P102Spec extends Specification {
  "P102#isAroundO((Int, Int), (Int, Int), (Int, Int))" should {
    "returns true if (a, b, c) = ((-340, 495), (-153, -910), (835, -947))" in {
      P102.isAroundO((-340, 495), (-153, -910), (835, -947)) must beTrue
    }

    "returns false if (a, b, c) = ((-175, 41), (-421, -714), (574, -645))" in {
      P102.isAroundO((-175, 41), (-421, -714), (574, -645)) must beFalse
    }
  }

  "P102#solve" should {
    "returns 228" in {
      P102.solve must beEqualTo(228)
    }
  }
}
