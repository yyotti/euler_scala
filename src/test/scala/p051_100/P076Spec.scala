package test.project_euler

import project_euler.P076
import org.specs2.mutable._

class P076Spec extends Specification {
  "P076#solve(Int)" should {
    "returns 6 if n = 5" in {
      P076.solve(5) must beEqualTo(6)
    }

    "returns 190569291 if n = 100" in {
      P076.solve(100) must beEqualTo(190569291)
    }
  }
}
