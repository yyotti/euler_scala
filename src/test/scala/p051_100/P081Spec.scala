package test.project_euler

import project_euler.P081
import org.specs2.mutable._

class P081Spec extends Specification {
  "P081#findMinRoute(Array[Array[Int]], Int, Int)" should {
    val matrix = Array(
      Array(131, 673, 234, 103, 18),
      Array(201, 96, 342, 965, 150),
      Array(630, 803, 746, 422, 111),
      Array(537, 699, 497, 121, 956),
      Array(805, 732, 524, 37, 331)
    )

    "returns 331 if (matrix, i, j) = (<省略>, 4, 4)" in {
      P081.findMinRoute(matrix, 4, 4) must beEqualTo(331)
    }

    "returns 1287 if (matrix, i, j) = (<省略>, 3, 4)" in {
      P081.findMinRoute(matrix, 3, 4) must beEqualTo(1287)
    }

    "returns 368 if (matrix, i, j) = (<省略>, 4, 3)" in {
      P081.findMinRoute(matrix, 4, 3) must beEqualTo(368)
    }

    "returns 489 if (matrix, i, j) = (<省略>, 3, 3)" in {
      P081.findMinRoute(matrix, 3, 3) must beEqualTo(489)
    }

    "returns 2427 if (matrix, i, j) = (<省略>, 0, 0)" in {
      P081.findMinRoute(matrix, 0, 0) must beEqualTo(2427)
    }
  }

  "P081#solve" should {
    "returns 427337" in {
      P081.solve must beEqualTo(427337)
    }
  }
}
