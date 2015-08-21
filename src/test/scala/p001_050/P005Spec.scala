package test.project_euler

import project_euler.P005
import org.specs2.mutable._

class P005Spec extends Specification {
  "P005#primeFactors(Long)" should {
    "returns [] if n = 1" in {
      P005.primeFactors(1) must beEmpty
    }

    "returns [2] if n = 2" in {
      P005.primeFactors(2) must beEqualTo(List(2))
    }

    "returns [3] if n = 3" in {
      P005.primeFactors(3) must beEqualTo(List(3))
    }

    "returns [2] if n = 4" in {
      P005.primeFactors(4) must beEqualTo(List(2, 2))
    }

    "returns [2, 3] if n = 6" in {
      P005.primeFactors(6) must beEqualTo(List(2, 3))
    }

    "returns [2, 2, 3] if n = 12" in {
      P005.primeFactors(12) must beEqualTo(List(2, 2, 3))
    }

    "returns [5, 7, 13, 29] if n = 13195" in {
      P005.primeFactors(13195) must beEqualTo(List(5, 7, 13, 29))
    }
  }

  "P005#countNumbers(List[Long])" should {
    "returns [] if list = []" in {
      P005.countNumbers(Nil) must beEmpty
    }

    "returns [2 -> 1] if list = [2]" in {
      P005.countNumbers(List(2)) must beEqualTo(Map(2 -> 1))
    }

    "returns [2 -> 1, 3 -> 1] if list = [2, 3]" in {
      P005.countNumbers(List(2, 3)) must beEqualTo(Map(2 -> 1, 3 -> 1))
    }

    "returns [2 -> 2, 3 -> 1] if list = [2, 2, 3]" in {
      P005.countNumbers(List(2, 2, 3)) must beEqualTo(Map(2 -> 2, 3 -> 1))
    }

    "returns [2 -> 3, 3 -> 2, 4 -> 1] if list = [2, 3, 4, 2, 3, 2]" in {
      P005.countNumbers(List(2, 3, 4, 2, 3, 2)) must beEqualTo(Map(2 -> 3, 3 -> 2, 4 -> 1))
    }
  }

  "P005#merge(Map[Long, Int], Map[Long, Int])" should {
    "returns [1 -> 2] if (map1, map2) = (Empty, [1 -> 2])" in {
      P005.merge(Map.empty, Map(1L -> 2)) must beEqualTo(Map(1L -> 2))
    }

    "returns [2 -> 1] if (map1, map2) = ([2 -> 1], Empty)" in {
      P005.merge(Map(2L -> 1), Map.empty) must beEqualTo(Map(2L -> 1))
    }

    "returns [2 -> 1, 3 -> 1] if (map1, map2) = ([2 -> 1], [3 -> 1])" in {
      P005.merge(Map(2L -> 1), Map(3L -> 1)) must beEqualTo(Map(2L -> 1, 3L -> 1))
    }

    "returns [2 -> 2, 3 -> 1] if (map1, map2) = ([2 -> 2], [2 -> 1, 3 -> 1])" in {
      P005.merge(Map(2L -> 2), Map(2L -> 1, 3L -> 1)) must beEqualTo(Map(2L -> 2, 3L -> 1))
    }

    "returns [2 -> 3, 3 -> 2, 4 -> 1] if (map1, map2) = ([2 -> 1, 3 -> 2], [2 -> 3, 3 -> 1, 4 -> 1])" in {
      P005.merge(Map(2L -> 1, 3L -> 2), Map(2L -> 3, 3L -> 1, 4L -> 1)) must beEqualTo(Map(2L -> 3, 3L -> 2, 4L -> 1))
    }
  }

  "P005#solve(Int)" should {
    "returns 2520 if n = 10" in {
      P005.solve(10) must beEqualTo(2520)
    }

    "returns 232792560 if n = 20" in {
      P005.solve(20) must beEqualTo(232792560)
    }
  }
}
