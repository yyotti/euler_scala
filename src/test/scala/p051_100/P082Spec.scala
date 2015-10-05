package test.project_euler

import project_euler.P082
import org.specs2.mutable._

class P082Spec extends Specification {
  import collection.mutable.PriorityQueue

  val matrix = Array(
    Array(131, 673, 234, 103, 18),
    Array(201, 96, 342, 965, 150),
    Array(630, 803, 746, 422, 111),
    Array(537, 699, 497, 121, 956),
    Array(805, 732, 524, 37, 331)
  )

  "P082#init(Array[Array[Int]])" should {
    "returns [(131, (0, 0)), (Int.MaxValue, (0, 1)), ...] if matrix = <省略>" in {
      val expected = PriorityQueue(
        (131, (0, 0)), (Int.MaxValue, (0, 1)), (Int.MaxValue, (0, 2)), (Int.MaxValue, (0, 3)), (Int.MaxValue, (0, 4)),
        (201, (1, 0)), (Int.MaxValue, (1, 1)), (Int.MaxValue, (1, 2)), (Int.MaxValue, (1, 3)), (Int.MaxValue, (1, 4)),
        (630, (2, 0)), (Int.MaxValue, (2, 1)), (Int.MaxValue, (2, 2)), (Int.MaxValue, (2, 3)), (Int.MaxValue, (2, 4)),
        (537, (3, 0)), (Int.MaxValue, (3, 1)), (Int.MaxValue, (3, 2)), (Int.MaxValue, (3, 3)), (Int.MaxValue, (3, 4)),
        (805, (4, 0)), (Int.MaxValue, (4, 1)), (Int.MaxValue, (4, 2)), (Int.MaxValue, (4, 3)), (Int.MaxValue, (4, 4))
      )(Ordering.by[(Int, (Int, Int)), Int] { _._1 }.reverse)

      P082.init(matrix) must beEqualTo(expected)
    }
  }

  "P082#findMinRoute(Array[Array[Int]], PriorityQueue[(Int, Vertex)])" should {
    "returns 994 if (matrix, queue) = (<省略>, <省略>)" in {
      val queue = PriorityQueue(
        (131, (0, 0)), (Int.MaxValue, (0, 1)), (Int.MaxValue, (0, 2)), (Int.MaxValue, (0, 3)), (Int.MaxValue, (0, 4)),
        (201, (1, 0)), (Int.MaxValue, (1, 1)), (Int.MaxValue, (1, 2)), (Int.MaxValue, (1, 3)), (Int.MaxValue, (1, 4)),
        (630, (2, 0)), (Int.MaxValue, (2, 1)), (Int.MaxValue, (2, 2)), (Int.MaxValue, (2, 3)), (Int.MaxValue, (2, 4)),
        (537, (3, 0)), (Int.MaxValue, (3, 1)), (Int.MaxValue, (3, 2)), (Int.MaxValue, (3, 3)), (Int.MaxValue, (3, 4)),
        (805, (4, 0)), (Int.MaxValue, (4, 1)), (Int.MaxValue, (4, 2)), (Int.MaxValue, (4, 3)), (Int.MaxValue, (4, 4))
      )(Ordering.by[(Int, (Int, Int)), Int] { _._1 }.reverse)

      P082.findMinRoute(matrix, queue) must beEqualTo(994)
    }
  }

  "P082#solve" should {
    "returns 260324" in {
      P082.solve must beEqualTo(260324)
    }
  }
}
