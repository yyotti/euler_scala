package test.project_euler

import project_euler.P019
import org.specs2.mutable._

class P019Spec extends Specification {
  "P019#solve" should {
    "returns 171" in {
      P019.solve must beEqualTo(171)
    }
  }
}
