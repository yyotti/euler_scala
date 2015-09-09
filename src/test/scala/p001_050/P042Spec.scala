package test.project_euler

import project_euler.P042
import org.specs2.mutable._

class P042Spec extends Specification {
  "P042#triangleNumbers" should {
    "first 10 terms are [0, 1, 3, 6, 10, 15, 21, 28, 36, 45]" in {
      P042.triangleNumbers.take(10).toList must beEqualTo(List(0, 1, 3, 6, 10, 15, 21, 28, 36, 45))
    }
  }

  "P042#solve" should {
    "returns 162" in {
      P042.solve must beEqualTo(162)
    }
  }
}
