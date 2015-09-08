package test.project_euler

import project_euler.P040
import org.specs2.mutable._

class P040Spec extends Specification {
  "P040#solve" should {
    "returns 210" in {
      P040.solve must beEqualTo(210)
    }
  }
}
