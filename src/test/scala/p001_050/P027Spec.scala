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

  "P027#solve(Int)" should {
    "returns -41 if max = 42" in {
      P027.solve(42) must beEqualTo(-41)
    }

    "returns -59231 if max = 1000" in {
      P027.solve(1000) must beEqualTo(-59231)
    }
  }
}
