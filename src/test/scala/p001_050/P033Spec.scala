package test.project_euler

import project_euler.P033
import org.specs2.mutable._

class P033Spec extends Specification {
  "P033#solve" should {
    "returns 100" in {
      P033.solve must beEqualTo(100)
    }
  }
}
