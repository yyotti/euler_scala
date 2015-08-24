package test.project_euler

import project_euler.P022
import org.specs2.mutable._

class P022Spec extends Specification {
  "P022#solve" should {
    "returns 871198282" in {
      P022.solve must beEqualTo(871198282)
    }
  }
}
