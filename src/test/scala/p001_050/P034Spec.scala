package test.project_euler

import project_euler.P034
import org.specs2.mutable._

class P034Spec extends Specification {
  "P034#solve" should {
    "returns 40730" in {
      P034.solve must beEqualTo(40730)
    }
  }
}
