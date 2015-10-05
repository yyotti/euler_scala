package test.project_euler

import project_euler.P083
import org.specs2.mutable._

class P083Spec extends Specification {
  "P083#solve" should {
    "returns 425185" in {
      P083.solve must beEqualTo(425185)
    }
  }
}
