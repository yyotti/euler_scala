package test.project_euler

import project_euler.P089
import org.specs2.mutable._

class P089Spec extends Specification {
  "P089#savedLength(String)" should {
    """returns 2 if s = "IIII"""" in {
      P089.savedLength("IIII") must beEqualTo(2)
    }

    """returns 3 if s = "XVIIII"""" in {
      P089.savedLength("XVIIII") must beEqualTo(3)
    }

    """returns 5 if s = "XXXXVIIII"""" in {
      P089.savedLength("XXXXVIIII") must beEqualTo(5)
    }

    """returns 0 if s = "XX"""" in {
      P089.savedLength("XX") must beEqualTo(0)
    }
  }

  "P089#solve" should {
    "returns 743" in {
      P089.solve must beEqualTo(743)
    }
  }
}
