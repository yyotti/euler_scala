package test.project_euler

import project_euler.P033
import org.specs2.mutable._

class P033Spec extends Specification {
  "P033#splitDigits(Int)" should {
    "returns [1] if n = 1" in {
      P033.splitDigits(1) must beEqualTo(List(1))
    }

    "returns [2] if n = 2" in {
      P033.splitDigits(2) must beEqualTo(List(2))
    }

    "returns [1, 0] if n = 10" in {
      P033.splitDigits(10) must beEqualTo(List(1, 0))
    }

    "returns [2, 1, 0] if n = 210" in {
      P033.splitDigits(210) must beEqualTo(List(2, 1, 0))
    }
  }

  "P033#solve" should {
    "returns 100" in {
      P033.solve must beEqualTo(100)
    }
  }
}
