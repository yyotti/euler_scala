package test.project_euler

import project_euler.P040
import org.specs2.mutable._

class P040Spec extends Specification {
  "P040#d(Int)" should {
    "returns 1 if n = 1" in {
      P040.d(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P040.d(2) must beEqualTo(2)
    }

    "returns 0 if n = 11" in {
      P040.d(11) must beEqualTo(0)
    }

    "returns 1 if n = 12" in {
      P040.d(12) must beEqualTo(1)
    }

    "returns 1 if n = 13" in {
      P040.d(13) must beEqualTo(1)
    }

    "returns 0 if n = 191" in {
      P040.d(191) must beEqualTo(0)
    }
  }

  "P040#solve" should {
    "returns 210" in {
      P040.solve must beEqualTo(210)
    }
  }
}
