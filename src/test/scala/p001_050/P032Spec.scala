package test.project_euler

import project_euler.P032
import org.specs2.mutable._

class P032Spec extends Specification {
  "P032#solve" should {
    "returns 45228" in {
      P032.solve must beEqualTo(45228)
    }
  }
}
