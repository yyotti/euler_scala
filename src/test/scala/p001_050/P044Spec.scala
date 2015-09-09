package test.project_euler

import project_euler.P044
import org.specs2.mutable._

class P044Spec extends Specification {
  "P044#solve" should {
    "returns 5482660" in {
      P044.solve must beEqualTo(5482660)
    }
  }
}
