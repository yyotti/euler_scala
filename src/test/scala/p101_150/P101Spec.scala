package test.project_euler

import project_euler.P101
import org.specs2.mutable._

class P101Spec extends Specification {
  "P101#solve" should {
    "returns 37076114526" in {
      P101.solve(10) must beEqualTo(37076114526L)
    }
  }
}
