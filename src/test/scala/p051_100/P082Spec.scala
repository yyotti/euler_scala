package test.project_euler

import project_euler.P082
import org.specs2.mutable._

class P082Spec extends Specification {
  "P082#solve" should {
    "returns 260324" in {
      P082.solve must beEqualTo(260324)
    }
  }
}
