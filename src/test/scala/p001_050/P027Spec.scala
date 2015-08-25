package test.project_euler

import project_euler.P027
import org.specs2.mutable._

class P027Spec extends Specification {
  "P027#func(Int, Int)(Int)" should {
    "returns 41 if (a, b) = (1, 41), n = 0" in {
      val f = P027.func(1, 41)(_)
      f(0) must beEqualTo(41)
    }
  }

  "P027#solve" should {
    "returns -59231" in {
      P027.solve must beEqualTo(-59231)
    }
  }
}
