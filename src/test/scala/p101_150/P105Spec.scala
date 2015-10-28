package test.project_euler

import project_euler.P105
import org.specs2.mutable._

class P105Spec extends Specification {
  "P105#solve" should {
    "returns 73702" in {
      P105.solve must beEqualTo(73702)
    }
  }
}
