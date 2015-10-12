package test.project_euler

import project_euler.P090
import org.specs2.mutable._

class P090Spec extends Specification {
  "P090#createDices(List[Int], Int)" should {
    "returns [[1, 2, 3, 4, 5, 6]] if (nums, c) = ([1, 2, 3, 4, 5, 6], 6)" in {
      P090.createDices(List(1, 2, 3, 4, 5, 6), 6).toList must beEqualTo(List(List(1, 2, 3, 4, 5, 6)))
    }

    "returns [[1, 2, 3, 4, 5], [1, 2, 3, 4, 6], ...] if (nums, c) = ([1, 2, 3, 4, 5, 6], 5)" in {
      val expected = List(
        List(1, 2, 3, 4, 5),
        List(1, 2, 3, 4, 6),
        List(1, 2, 3, 5, 6),
        List(1, 2, 4, 5, 6),
        List(1, 3, 4, 5, 6),
        List(2, 3, 4, 5, 6)
      )
      P090.createDices(List(1, 2, 3, 4, 5, 6), 5).toList must beEqualTo(expected)
    }
  }

  "P090#checkSquares(Set[Int], Set[Int])" should {
    "returns true if (dice1, dice2) = ([0, 5, 6, 7, 8, 9], [1, 2, 3, 4, 8, 9])" in {
      P090.checkSquares(Set(0, 5, 6, 7, 8, 9), Set(1, 2, 3, 4, 8, 9)) must beTrue
    }

    "returns true if (dice1, dice2) = ([0, 5, 6, 7, 8, 9], [1, 2, 3, 4, 6, 7])" in {
      P090.checkSquares(Set(0, 5, 6, 7, 8, 9), Set(1, 2, 3, 4, 6, 7)) must beTrue
    }

    "returns false if (dice1, dice2) = ([1, 5, 6, 7, 8, 9], [1, 2, 3, 4, 6, 7])" in {
      P090.checkSquares(Set(1, 5, 6, 7, 8, 9), Set(1, 2, 3, 4, 6, 7)) must beFalse
    }
  }

  "P090#solve" should {
    "returns 1217" in {
      P090.solve must beEqualTo(1217)
    }
  }
}
