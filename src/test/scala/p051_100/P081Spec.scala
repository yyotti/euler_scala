package test.project_euler

import project_euler.P081
import org.specs2.mutable._

class P081Spec extends Specification {
  "P081#solve" should {
    "returns 427337" in {
      P081.solve must beEqualTo(427337)
    }
  }
}
