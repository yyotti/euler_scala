package test.project_euler

import project_euler.P083
import org.specs2.mutable._

class P083Spec extends Specification {
  import collection.mutable.PriorityQueue

  val matrix = Array(
    Array(131, 673, 234, 103, 18),
    Array(201, 96, 342, 965, 150),
    Array(630, 803, 746, 422, 111),
    Array(537, 699, 497, 121, 956),
    Array(805, 732, 524, 37, 331)
  )

  "P083#init(Array[Array[Int]])" should {
    "returns [(131, (0, 0)), (Int.MaxValue, (0, 1)), ...] if matrix = <省略>" in {
      val expected = PriorityQueue(
        (131, (0, 0)), (Int.MaxValue, (0, 1)), (Int.MaxValue, (0, 2)), (Int.MaxValue, (0, 3)), (Int.MaxValue, (0, 4)),
        (Int.MaxValue, (1, 0)), (Int.MaxValue, (1, 1)), (Int.MaxValue, (1, 2)), (Int.MaxValue, (1, 3)), (Int.MaxValue, (1, 4)),
        (Int.MaxValue, (2, 0)), (Int.MaxValue, (2, 1)), (Int.MaxValue, (2, 2)), (Int.MaxValue, (2, 3)), (Int.MaxValue, (2, 4)),
        (Int.MaxValue, (3, 0)), (Int.MaxValue, (3, 1)), (Int.MaxValue, (3, 2)), (Int.MaxValue, (3, 3)), (Int.MaxValue, (3, 4)),
        (Int.MaxValue, (4, 0)), (Int.MaxValue, (4, 1)), (Int.MaxValue, (4, 2)), (Int.MaxValue, (4, 3)), (Int.MaxValue, (4, 4))
      )(Ordering.by[(Int, (Int, Int)), Int] { _._1 }.reverse)

      P083.init(matrix) must beEqualTo(expected)
    }
  }

  "P083#findMinRoute(Array[Array[Int]], PriorityQueue[(Int, Vertex)])" should {
    "returns 2297 if (matrix, queue) = (<省略>, <省略>)" in {
      val queue = PriorityQueue(
        (131, (0, 0)), (Int.MaxValue, (0, 1)), (Int.MaxValue, (0, 2)), (Int.MaxValue, (0, 3)), (Int.MaxValue, (0, 4)),
        (Int.MaxValue, (1, 0)), (Int.MaxValue, (1, 1)), (Int.MaxValue, (1, 2)), (Int.MaxValue, (1, 3)), (Int.MaxValue, (1, 4)),
        (Int.MaxValue, (2, 0)), (Int.MaxValue, (2, 1)), (Int.MaxValue, (2, 2)), (Int.MaxValue, (2, 3)), (Int.MaxValue, (2, 4)),
        (Int.MaxValue, (3, 0)), (Int.MaxValue, (3, 1)), (Int.MaxValue, (3, 2)), (Int.MaxValue, (3, 3)), (Int.MaxValue, (3, 4)),
        (Int.MaxValue, (4, 0)), (Int.MaxValue, (4, 1)), (Int.MaxValue, (4, 2)), (Int.MaxValue, (4, 3)), (Int.MaxValue, (4, 4))
      )(Ordering.by[(Int, (Int, Int)), Int] { _._1 }.reverse)

      P083.findMinRoute(matrix, queue) must beEqualTo(2297)
    }
  }

  "P083#solve" should {
    "returns 425185" in {
      P083.solve must beEqualTo(425185)
    }
  }
}
