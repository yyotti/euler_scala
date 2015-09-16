package test.project_euler

import project_euler.P059
import org.specs2.mutable._

class P059Spec extends Specification {
  "P059#solve" should {
    "returns 107359" in {
      P059.solve must beEqualTo(107359)
    }
  }
}
