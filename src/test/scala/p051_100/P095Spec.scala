package test.project_euler

import project_euler.P095
import org.specs2.mutable._

class P095Spec extends Specification {
  "P095#solve" should {
    "returns 14316" in {
      P095.solve must beEqualTo(14316)
    }
  }
}
