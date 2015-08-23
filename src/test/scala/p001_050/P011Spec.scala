package test.project_euler

import project_euler.P011
import org.specs2.mutable._

class P011Spec extends Specification {
  "P011#solve" should {
    "returns 70600674" in {
      P011.solve must beEqualTo(70600674)
    }
  }
}
