package test.project_euler

import project_euler.P084
import org.specs2.mutable._

class P084Spec extends Specification {
  "P084#roll(Int)" should {
    "returns (x, y) (1 <= x,y <= 6) if dice = 6" in {
      val (d1, d2) = P084.roll(6)
      (d1 must beBetween(1, 6)) and (d2 must beBetween(1, 6))
    }

    "returns (x, y) (1 <= x,y <= 4) if dice = 4" in {
      val (d1, d2) = P084.roll(4)
      (d1 must beBetween(1, 4)) and (d2 must beBetween(1, 4))
    }
  }

  "P084#slide(List[A], Int)" should {
    "returns [] if (list, n) = ([], 3)" in {
      P084.slide(Nil, 3) must beEmpty
    }

    "returns [1, 2, 3] if (list, n) = ([1, 2, 3], 0)" in {
      P084.slide(List(1, 2, 3), 0) must beEqualTo(List(1, 2, 3))
    }

    "returns [2, 3, 1] if (list, n) = ([1, 2, 3], 1)" in {
      P084.slide(List(1, 2, 3), 1) must beEqualTo(List(2, 3, 1))
    }

    "returns [3, 1, 2] if (list, n) = ([1, 2, 3], 2)" in {
      P084.slide(List(1, 2, 3), 2) must beEqualTo(List(3, 1, 2))
    }

    "returns [1, 2, 3] if (list, n) = ([1, 2, 3], 3)" in {
      P084.slide(List(1, 2, 3), 3) must beEqualTo(List(1, 2, 3))
    }

    "returns [2, 3, 1] if (list, n) = ([1, 2, 3], 4)" in {
      P084.slide(List(1, 2, 3), 4) must beEqualTo(List(2, 3, 1))
    }
  }

  "P084#solve(Int)" should {
    "returns \"101524\"" in {
      P084.solve(4) must beEqualTo("101524")
    }
  }
}
