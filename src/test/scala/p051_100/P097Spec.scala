package test.project_euler

import project_euler.P097
import org.specs2.mutable._

class P097Spec extends Specification {
  "P097#solve" should {
    "returns 8739992577" in {
      P097.solve must beEqualTo(8739992577L)
    }
  }
}
