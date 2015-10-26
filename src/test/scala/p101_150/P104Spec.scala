package test.project_euler

import project_euler.P104
import org.specs2.mutable._

class P104Spec extends Specification {
  "P104#solve" should {
    "returns 329468" in {
      P104.solve must beEqualTo(329468)
    }
  }
}
