package test.project_euler

import project_euler.P090
import org.specs2.mutable._

class P090Spec extends Specification {
  "P090#solve" should {
    "returns 1217" in {
      P090.solve must beEqualTo(1217)
    }
  }
}
