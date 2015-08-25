package test.project_euler

import project_euler.P024
import org.specs2.mutable._

class P024Spec extends Specification {
  "P024#solve(List[Char], Long)" should {
    """returns "102" if (list, n) = (['0', '1', '2'], 3)""" in {
      P024.solve(List('0', '1', '2'), 3) must beEqualTo("102")
    }

    """returns "2783915460" if (list, n) = (['0', '1', '2', ..., '9'], 1000000)""" in {
      P024.solve(List('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'), 1000000) must beEqualTo("2783915460")
    }
  }
}
