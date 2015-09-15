package test.project_euler

import project_euler.P056
import org.specs2.mutable._

class P056Spec extends Specification {
  "P056#solve" should {
    "returns 972" in {
      P056.solve must beEqualTo(972)
    }
  }
}
