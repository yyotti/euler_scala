package test.project_euler

import project_euler.P078
import org.specs2.mutable._

class P078Spec extends Specification {
  "P078#solve" should {
    "returns 55374" in {
      P078.solve must beEqualTo(55374)
    }
  }
}
