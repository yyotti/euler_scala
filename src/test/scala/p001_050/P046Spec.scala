package test.project_euler

import project_euler.P046
import org.specs2.mutable._

class P046Spec extends Specification {
  "P046#solve" should {
    "returns 5777" in {
      P046.solve must beEqualTo(5777)
    }
  }
}
