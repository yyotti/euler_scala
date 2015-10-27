package test.project_euler

import project_euler.P107
import org.specs2.mutable._

class P107Spec extends Specification {
  "P107#solve" should {
    "returns 259679" in {
      P107.solve must beEqualTo(259679)
    }
  }
}
