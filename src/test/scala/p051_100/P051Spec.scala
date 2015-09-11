package test.project_euler

import project_euler.P051
import org.specs2.mutable._

class P051Spec extends Specification {
  "P051#solve" should {
    "returns 121313" in {
      P051.solve must beEqualTo(121313)
    }
  }
}
