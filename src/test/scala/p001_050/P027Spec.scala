package test.project_euler

import project_euler.P027
import org.specs2.mutable._

class P027Spec extends Specification {
  "P027#solve" should {
    "returns -59231" in {
      P027.solve must beEqualTo(-59231)
    }
  }
}
