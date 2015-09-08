package test.project_euler

import project_euler.P039
import org.specs2.mutable._

class P039Spec extends Specification {
  "P039#solve" should {
    "returns 840" in {
      P039.solve must beEqualTo(840)
    }
  }
}
