package test.project_euler

import project_euler.P053
import org.specs2.mutable._

class P053Spec extends Specification {
  "P053#solve" should {
    "returns 4075" in {
      P053.solve must beEqualTo(4075)
    }
  }
}
