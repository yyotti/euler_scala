package test.project_euler

import project_euler.P068
import org.specs2.mutable._

class P068Spec extends Specification {
  "P068#findNgonRings(Int)" should {
    "returns [[(4, 2, 3), (5, 3, 1), (6, 1, 2)], ... ] if n = 3" in {
      val expected = Set(
        List((4, 2, 3), (5, 3, 1), (6, 1, 2)),
        List((4, 3, 2), (6, 2, 1), (5, 1, 3)),
        List((2, 3, 5), (4, 5, 1), (6, 1, 3)),
        List((2, 5, 3), (6, 3, 1), (4, 1, 5)),
        List((1, 4, 6), (3, 6, 2), (5, 2, 4)),
        List((1, 6, 4), (5, 4, 2), (3, 2, 6)),
        List((1, 5, 6), (2, 6, 4), (3, 4, 5)),
        List((1, 6, 5), (3, 5, 4), (2, 4, 6))
      )
      P068.findNgonRings(3).toSet must beEqualTo(expected)
    }
  }

  "P068#solve(Int, Int)" should {
    "returns 432621513 if (n, d) = (3, 9)" in {
      P068.solve(3, 9) must beEqualTo(432621513)
    }

    "returns 6531031914842725 if (n, d) = (5, 16)" in {
      P068.solve(5, 16) must beEqualTo(6531031914842725L)
    }
  }
}
