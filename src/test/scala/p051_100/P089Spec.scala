package test.project_euler

import project_euler.P089
import org.specs2.mutable._

class P089Spec extends Specification {
  "P089#solve" should {
    "returns 743" in {
      P089.solve must beEqualTo(743)
    }
  }
}
