package test.project_euler

import project_euler.P067
import org.specs2.mutable._

class P067Spec extends Specification {
  "P067#solve" should {
    "returns 7273" in {
      P067.solve must beEqualTo(7273)
    }
  }
}
