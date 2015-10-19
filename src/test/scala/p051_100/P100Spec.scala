package test.project_euler

import project_euler.P100
import org.specs2.mutable._

class P100Spec extends Specification {
  "P100#pell" should {
    "first 10 terms are [(1, 1), (7, 5), (41, 29), (239, 169), (1393, 985), (8119, 5741), (47321, 33461), (275807, 195025), (1607521, 1136689), (9369319, 6625109)]" in {
      P100.pell.take(10).toList must beEqualTo(List((1, 1), (7, 5), (41, 29), (239, 169), (1393, 985), (8119, 5741), (47321, 33461), (275807, 195025), (1607521, 1136689), (9369319, 6625109)))
    }
  }

  "P100#solve(Int)" should {
    "returns 85" in {
      P100.solve(100) must beEqualTo(85)
    }

    "returns 756872327473" in {
      P100.solve(1000000000000L) must beEqualTo(756872327473L)
    }
  }
}
