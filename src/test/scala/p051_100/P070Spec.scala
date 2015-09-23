package test.project_euler

import project_euler.P070
import org.specs2.mutable._

class P070Spec extends Specification {
  "P070#solve" should {
    "returns 8319823" in {
      P070.solve must beEqualTo(8319823)
    }
  }
}
