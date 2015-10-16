package test.project_euler

import project_euler.P095
import org.specs2.mutable._

class P095Spec extends Specification {
  "P095#sums(Int)" should {
    "returns [] if limit = 1" in {
      P095.sums(1) must beEmpty
    }

    "returns [1 -> 0, 2 -> 1, ...] if limit = 10" in {
      val expected = Map(
        1 -> 0,
        2 -> 1,
        3 -> 1,
        4 -> 3,
        5 -> 1,
        6 -> 6,
        7 -> 1,
        8 -> 7,
        9 -> 4
      )
      P095.sums(10) must beEqualTo(expected)
    }
  }

  "P095#chainCount(Int, Map[Int, Int])" should {
    val map = Map(
      1 -> 0,
      2 -> 1,
      3 -> 1,
      4 -> 3,
      5 -> 1,
      6 -> 6,
      7 -> 1,
      8 -> 7,
      9 -> 4
    )
    "returns 0 if (start, nums) = (1, [])" in {
      P095.chainCount(1, Map.empty) must beEqualTo(0)
    }

    "returns 0 if (start, nums) = (1, [1 -> 0, 2 -> 1, ...])" in {
      P095.chainCount(1, map) must beEqualTo(0)
    }

    "returns 1 if (start, nums) = (6, [1 -> 0, 2 -> 1, ...])" in {
      P095.chainCount(6, map) must beEqualTo(1)
    }

    "returns 5 if (start, nums) = (12496, <省略>)" in {
      val map2 = map ++ Map(
        12496 -> 14288,
        14288 -> 15472,
        15472 -> 14536,
        14536 -> 14264,
        14264 -> 12496
      )
      P095.chainCount(12496, map2) must beEqualTo(5)
    }
  }

  "P095#solve" should {
    "returns 14316" in {
      P095.solve must beEqualTo(14316)
    }
  }
}
