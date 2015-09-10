package test.project_euler

import project_euler.P049
import org.specs2.mutable._

class P049Spec extends Specification {
  "P049#solve" should {
    "returns 296962999629" in {
      P049.solve must beEqualTo(296962999629L)
    }
  }
}
