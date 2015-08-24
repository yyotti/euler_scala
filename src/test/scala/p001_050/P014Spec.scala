package test.project_euler

import project_euler.P014
import org.specs2.mutable._

class P014Spec extends Specification {
  "P014#collatsCount(Long)" should {
    "returns 1 if n = 1" in {
      P014.collatsCount(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P014.collatsCount(2) must beEqualTo(2)
    }

    "returns 8 if n = 3" in {
      P014.collatsCount(3) must beEqualTo(8)
    }
  }

  "P014#solve(Int)" should {
    "returns 837799 if n = 1000000" in {
      P014.solve(1000000) must beEqualTo(837799)
    }
  }
}
