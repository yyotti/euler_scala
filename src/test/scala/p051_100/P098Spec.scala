package test.project_euler

import project_euler.P098
import org.specs2.mutable._

class P098Spec extends Specification {
  "P098#squares" should {
    "first 10 terms are [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]" in {
      P098.squares.take(10).toList must beEqualTo(List(Seq(1), Seq(4), Seq(9), Seq(1, 6), Seq(2, 5), Seq(3, 6), Seq(4, 9), Seq(6, 4), Seq(8, 1), Seq(1, 0, 0)))
    }
  }

  "P098#findMaxSquareNums(List[String])" should {
    """returns [] if words = []""" in {
      P098.findMaxSquareNums(Nil) must beEmpty
    }

    """returns [] if words = ["A"]""" in {
      P098.findMaxSquareNums(List("A")) must beEmpty
    }

    """returns [] if words = ["IDEA", "DIAE"]""" in {
      P098.findMaxSquareNums(List("IDEA", "DIAE")) must beEmpty
    }

    """returns [9216] if words = ["CARE", "RACE"]""" in {
      P098.findMaxSquareNums(List("CARE", "RACE")) must beEqualTo(List(9216))
    }
  }

  "P098#solve" should {
    "returns 18769" in {
      P098.solve must beEqualTo(18769)
    }
  }
}
