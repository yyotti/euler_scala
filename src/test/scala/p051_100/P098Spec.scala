package test.project_euler

import project_euler.P098
import org.specs2.mutable._

class P098Spec extends Specification {
  "P098#solve" should {
    "returns 18769" in {
      P098.solve must beEqualTo(18769)
    }
  }
}
