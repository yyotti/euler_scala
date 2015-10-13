package test.project_euler

import project_euler.P093
import org.specs2.mutable._

class P093Spec extends Specification {
  "P093#solve(Int)" should {
    """returns "1258"""" in {
      P093.solve must beEqualTo("1258")
    }
  }
}
