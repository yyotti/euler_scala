package test.project_euler

import project_euler.P079
import org.specs2.mutable._

class P079Spec extends Specification {
  "P079#solve" should {
    "returns 73162890" in {
      P079.solve must beEqualTo(73162890)
    }
  }
}
