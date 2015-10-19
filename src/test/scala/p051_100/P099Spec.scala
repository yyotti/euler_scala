package test.project_euler

import project_euler.P099
import org.specs2.mutable._

class P099Spec extends Specification {
  "P099#solve" should {
    "returns 709" in {
      P099.solve must beEqualTo(709)
    }
  }
}
