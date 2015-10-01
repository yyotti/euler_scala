package test.project_euler

import project_euler.P079
import org.specs2.mutable._

class P079Spec extends Specification {
  "P079#init(List[List[Int]])" should {
    "returns [0 -> (0, 1, 2, 3, 4, 5, 6), 1 -> ...] if lines = [319, 680, 180, 690, 129]" in {
      val lines = List(
        List(3, 1, 9),
        List(6, 8, 0),
        List(1, 8, 0),
        List(6, 9, 0),
        List(1, 2, 9)
      )
      val set = List.range(0, 7).toSet
      val expected = Map(
        0 -> set,
        1 -> set,
        2 -> set,
        3 -> set,
        6 -> set,
        8 -> set,
        9 -> set
      )
      P079.init(lines)  must beEqualTo(expected)
    }
  }

  "P079#dropHead(Int, Int, Map[Int, Set[Int]])" should {
    "returns <省略> if (c, pos, nums) = <省略>" in {
      val set = List.range(0, 4).toSet
      val map = Map(
        0 -> set,
        1 -> set,
        2 -> set,
        3 -> set
      )

      val expected = Map(
        0 -> set,
        1 -> set,
        2 -> set,
        3 -> (set -- Set(0, 1, 2))
      )
      P079.dropHead(3, 2, map) must beEqualTo(expected)
    }
  }

  "P079#dropTail(Int, Int, Map[Int, Set[Int]])" should {
    "returns <省略> if (c, nums) = <省略>" in {
      val set = List.range(0, 4).toSet
      val map = Map(
        0 -> set,
        1 -> set,
        2 -> set
      )

      val expected = Map(
        0 -> set,
        1 -> (set -- Set(2, 3, 4)),
        2 -> set
      )
      P079.dropTail(1, 2, map) must beEqualTo(expected)
    }
  }

  "P079#dropBoth(Int, Map[Int, Set[Int]])" should {
    "returns <省略> if (c, nums) = <省略>" in {
      val set = List.range(0, 4).toSet
      val map = Map(
        0 -> set,
        1 -> set,
        2 -> set
      )

      val expected = Map(
        0 -> set,
        1 -> set,
        2 -> (set -- Set(0, 3))
      )
      P079.dropBoth(2, 0, 3, map) must beEqualTo(expected)
    }
  }

  "P079#apply(Int, Map[Int, Set[Int]])" should {
    "returns <省略> if (c, nums) = <省略>" in {
      val set = List.range(0, 4).toSet
      val map = Map(
        0 -> set,
        1 -> Set(3),
        2 -> set
      )

      val expected = Map(
        0 -> (set - 3),
        1 -> Set(3),
        2 -> (set - 3)
      )
      P079.apply(1, map) must beEqualTo(expected)
    }
  }

  "P079#squeezeHead(List[Int], Map[Int, Set[Int]])" should {
    "returns <省略> if (c, nums) = <省略>" in {
      val map = Map(
        0 -> Set(0, 1, 2, 3),
        1 -> Set(   1, 2),
        2 -> Set(0, 1, 2, 3)
      )

      val expected = Map(
        0 -> Set(         3),
        1 -> Set(   1, 2),
        2 -> Set(      2, 3)
      )
      P079.squeezeHead(List(1, 2, 0), map) must beEqualTo(expected)
    }
  }

  "P079#squeezeTail(List[Int], Map[Int, Set[Int]])" should {
    "returns <省略> if (c, nums) = <省略>" in {
      val map = Map(
        0 -> Set(0, 1, 2, 3),
        1 -> Set(   1, 2),
        2 -> Set(0, 1, 2, 3)
      )

      val expected = Map(
        0 -> Set(0, 1, 2, 3),
        1 -> Set(   1),
        2 -> Set(0, 1, 2)
      )
      P079.squeezeTail(List(1, 2, 0), map) must beEqualTo(expected)
    }
  }

  "P079#solve" should {
    "returns 73162890" in {
      P079.solve must beEqualTo(73162890)
    }
  }
}
