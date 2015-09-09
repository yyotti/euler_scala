package test.project_euler

import project_euler.P042
import org.specs2.mutable._

class P042Spec extends Specification {
  "P042#solve" should {
    "returns 162" in {
      P042.solve must beEqualTo(162)
    }
  }
}
