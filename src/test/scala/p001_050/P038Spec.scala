package test.project_euler

import project_euler.P038
import org.specs2.mutable._

class P038Spec extends Specification {
  "P038#solve" should {
    "returns 932718654" in {
      P038.solve must beEqualTo(932718654)
    }
  }
}
