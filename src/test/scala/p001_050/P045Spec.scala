package test.project_euler

import project_euler.P045
import org.specs2.mutable._

class P045Spec extends Specification {
  "P045#solve" should {
    "returns 1533776805" in {
      P045.solve must beEqualTo(1533776805)
    }
  }
}
