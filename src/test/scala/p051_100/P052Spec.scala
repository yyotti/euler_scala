package test.project_euler

import project_euler.P052
import org.specs2.mutable._

class P052Spec extends Specification {
  "P052#solve" should {
    "returns 142857" in {
      P052.solve must beEqualTo(142857)
    }
  }
}
