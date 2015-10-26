package test.project_euler

import project_euler.P102
import org.specs2.mutable._

class P102Spec extends Specification {
  "P102#solve" should {
    "returns 228" in {
      P102.solve must beEqualTo(228)
    }
  }
}
