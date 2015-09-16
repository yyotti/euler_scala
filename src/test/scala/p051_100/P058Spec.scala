package test.project_euler

import project_euler.P058
import org.specs2.mutable._

class P058Spec extends Specification {
  "P058#solve" should {
    "returns 26241" in {
      P058.solve must beEqualTo(26241)
    }
  }
}
