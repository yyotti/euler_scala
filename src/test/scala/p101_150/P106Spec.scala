package test.project_euler

import project_euler.P106
import org.specs2.mutable._

class P106Spec extends Specification {
  "P106#countValidateRequires(List[Int])" should {
    "returns 2 if nums = [1, 2, 3, 4]" in {
      P106.countValidateRequires(List(1, 2, 3, 4)) must beEqualTo(2)
    }

    "returns 140 if nums = [3, 4, 5, 6, 7, 8, 9]" in {
      P106.countValidateRequires(List(3, 4, 5, 6, 7, 8, 9)) must beEqualTo(140)
    }
  }

  "P106#solve(Int)" should {
    "returns 1 if n = 4" in {
      P106.solve(4) must beEqualTo(1)
    }

    "returns 70 if n = 7" in {
      P106.solve(7) must beEqualTo(70)
    }

    "returns 21384 if n = 12" in {
      P106.solve(12) must beEqualTo(21384)
    }
  }
}
