package test.project_euler

import project_euler.P009
import org.specs2.mutable._

class P009Spec extends Specification {
  "P009#solve" should {
    "returns 31875000" in {
      P009.solve must beEqualTo(31875000)
    }
  }
}
