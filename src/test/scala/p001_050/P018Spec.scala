package test.project_euler

import project_euler.P018
import org.specs2.mutable._

class P018Spec extends Specification {
  "P018#solve(List[List[Int]])" should {
    "returns 23 if lines = [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]]" in {
      val lines = List(
        List(3),
        List(7, 4),
        List(2, 4, 6),
        List(8, 5, 9, 3)
      )
      P018.solve(lines) must beEqualTo(23)
    }

    "returns 1074 if lines = [[75], [95, 64], ... , 4, 23]]" in {
      val lines = List(
        List(75),
        List(95, 64),
        List(17, 47, 82),
        List(18, 35, 87, 10),
        List(20,  4, 82, 47, 65),
        List(19,  1, 23, 75,  3, 34),
        List(88,  2, 77, 73,  7, 63, 67),
        List(99, 65,  4, 28,  6, 16, 70, 92),
        List(41, 41, 26, 56, 83, 40, 80, 70, 33),
        List(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
        List(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
        List(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
        List(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
        List(63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
        List( 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23)
      )
      P018.solve(lines) must beEqualTo(1074)
    }
  }
}
