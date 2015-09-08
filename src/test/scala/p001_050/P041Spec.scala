package test.project_euler

import project_euler.P041
import org.specs2.mutable._

class P041Spec extends Specification {
  "P041#solve" should {
    "returns 7652413" in {
      P041.solve must beEqualTo(7652413)
    }
  }
}
