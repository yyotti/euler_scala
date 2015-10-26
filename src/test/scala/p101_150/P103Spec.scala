package test.project_euler

import project_euler.P103
import org.specs2.mutable._

class P103Spec extends Specification {
  "P103#solve(Int)" should {
    """returns "20313839404245"""" in {
      P103.solve(7) must beEqualTo("20313839404245")
    }
  }
}
