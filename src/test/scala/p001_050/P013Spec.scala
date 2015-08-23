package test.project_euler

import project_euler.P013
import org.specs2.mutable._

class P013Spec extends Specification {
  "P013#solve" should {
    "returns 5537376230" in {
      P013.solve must beEqualTo(5537376230L)
    }
  }
}
