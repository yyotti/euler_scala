package test.project_euler

import project_euler.P106
import org.specs2.mutable._

class P106Spec extends Specification {
  "P106#solve(Int)" should {
    "returns 21384 if n = 12" in {
      P106.solve(12) must beEqualTo(21384)
    }
  }
}
