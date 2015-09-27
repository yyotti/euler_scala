package test.project_euler

import project_euler.P074
import org.specs2.mutable._

class P074Spec extends Specification {
  "P074#solve" should {
    "returns 402" in {
      P074.solve must beEqualTo(402)
    }
  }
}
