package test.project_euler

import project_euler.P054
import org.specs2.mutable._

class P054Spec extends Specification {
  "P054#solve" should {
    "returns 376" in {
      P054.solve must beEqualTo(376)
    }
  }
}
