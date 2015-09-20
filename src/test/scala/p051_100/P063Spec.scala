package test.project_euler

import project_euler.P063
import org.specs2.mutable._

class P063Spec extends Specification {
  "P063#solve" should {
    "returns 49" in {
      P063.solve must beEqualTo(49)
    }
  }
}
