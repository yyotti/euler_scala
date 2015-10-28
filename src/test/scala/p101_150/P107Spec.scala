package test.project_euler

import project_euler.P107
import project_euler.P107.Edge
import org.specs2.mutable._

class P107Spec extends Specification {
  import collection.mutable.PriorityQueue

  "P107#prim(Graph)" should {
    "returns <省略> if graph = <省略>" in {
      val graph = Map(
        0 -> List(Edge(0, 3, 21), Edge(0, 2, 12), Edge(0, 1, 16)),
        1 -> List(Edge(1, 4, 20), Edge(1, 3, 17), Edge(1, 0, 16)),
        2 -> List(Edge(2, 5, 31), Edge(2, 3, 28), Edge(2, 0, 12)),
        3 -> List(Edge(3, 6, 23), Edge(3, 5, 19), Edge(3, 4, 18), Edge(3, 2, 28), Edge(3, 1, 17), Edge(3, 0, 21)),
        4 -> List(Edge(4, 6, 11), Edge(4, 3, 18), Edge(4, 1, 20)),
        5 -> List(Edge(5, 6, 27), Edge(5, 3, 19), Edge(5, 2, 31)),
        6 -> List(Edge(6, 5, 27), Edge(6, 4, 11), Edge(6, 3, 23))
      )

      val expected = List(
        Edge(3, 5, 19),
        Edge(4, 6, 11),
        Edge(3, 4, 18),
        Edge(1, 3, 17),
        Edge(0, 2, 12),
        Edge(1, 0, 16)
      )

      P107.prim(graph) must beEqualTo(expected)
    }
  }

  "P107#toGraph(Array[Array[Int]])" should {
    "returns <省略> if matrix = <省略>" in {
      val matrix = Array(
        Array( 0, 16, 12, 21,  0,  0,  0),
        Array(16,  0,  0, 17, 20,  0,  0),
        Array(12,  0,  0, 28,  0, 31,  0),
        Array(21, 17, 28,  0, 18, 19, 23),
        Array( 0, 20,  0, 18,  0,  0, 11),
        Array( 0,  0, 31, 19,  0,  0, 27),
        Array( 0,  0,  0, 23, 11, 27,  0)
      )

      val expected = Map(
        0 -> List(Edge(0, 3, 21), Edge(0, 2, 12), Edge(0, 1, 16)),
        1 -> List(Edge(1, 4, 20), Edge(1, 3, 17), Edge(1, 0, 16)),
        2 -> List(Edge(2, 5, 31), Edge(2, 3, 28), Edge(2, 0, 12)),
        3 -> List(Edge(3, 6, 23), Edge(3, 5, 19), Edge(3, 4, 18), Edge(3, 2, 28), Edge(3, 1, 17), Edge(3, 0, 21)),
        4 -> List(Edge(4, 6, 11), Edge(4, 3, 18), Edge(4, 1, 20)),
        5 -> List(Edge(5, 6, 27), Edge(5, 3, 19), Edge(5, 2, 31)),
        6 -> List(Edge(6, 5, 27), Edge(6, 4, 11), Edge(6, 3, 23))
      )

      P107.toGraph(matrix) must beEqualTo(expected)
    }
  }

  "P107#solve" should {
    "returns 259679" in {
      P107.solve must beEqualTo(259679)
    }
  }
}
