package test.project_euler

import project_euler.P023
import org.specs2.mutable._

class P023Spec extends Specification {
  "P023#solve" should {
    "returns 4179871" in {
      P023.solve must beEqualTo(4179871)
    }
  }
}
