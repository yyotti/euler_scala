package test.project_euler

import project_euler.P088
import org.specs2.mutable._

class P088Spec extends Specification {
  "P088#multiplyOne(Int, List[Int])" should {
    "returns [] if (x, ls) = (2, [])" in {
      P088.multiplyOne(2, Nil) must beEmpty
    }

    "returns [[3]] if (x, ls) = (3, [1])" in {
      P088.multiplyOne(3, List(1)) must beEqualTo(List(List(3)))
    }

    "returns [[3, 2], [1, 6]] if (x, ls) = (3, [1, 2])" in {
      P088.multiplyOne(3, List(1, 2)) must beEqualTo(List(List(3, 2), List(1, 6)))
    }

    "returns [[9, 2, 1], [3, 6, 1], [3, 2, 3]] if (x, ls) = (3, [3, 2, 1])" in {
      P088.multiplyOne(3, List(3, 2, 1)) must beEqualTo(List(List(9, 2, 1), List(3, 6, 1), List(3, 2, 3)))
    }
  }

  "P088#addFactor(Int, List[Int])" should {
    "returns [[2]] if (x, ls) = (2, [])" in {
      P088.addFactor(2, Nil) must beEqualTo(List(List(2)))
    }

    "returns [[1, 3], [3]] if (x, ls) = (3, [1])" in {
      P088.addFactor(3, List(1)) must beEqualTo(List(List(1, 3), List(3)))
    }

    "returns [[1, 2, 3], [2, 3], [1, 6]] if (x, ls) = (3, [1, 2])" in {
      P088.addFactor(3, List(1, 2)) must beEqualTo(List(List(1, 2, 3), List(2, 3), List(1, 6)))
    }

    "returns [[1, 2, 3, 3], [1, 2, 9], [1, 3, 6], [2, 3, 3]] if (x, ls) = (3, [3, 2, 1])" in {
      P088.addFactor(3, List(3, 2, 1)) must beEqualTo(List(List(1, 2, 3, 3), List(1, 2, 9), List(1, 3, 6), List(2, 3, 3)))
    }
  }

  "P088#productLists(List[Int])" should {
    "returns [[]] if fs = []" in {
      P088.productLists(Nil) must beEqualTo(List(Nil))
    }

    "returns [[2]] if fs = [2]" in {
      P088.productLists(List(2)) must beEqualTo(List(List(2)))
    }

    "returns [[2, 3], [6]] if fs = [2, 3]" in {
      P088.productLists(List(2, 3)) must beEqualTo(List(List(2, 3), List(6)))
    }

    "returns [[3, 3], [9]] if fs = [3, 3]" in {
      P088.productLists(List(3, 3)) must beEqualTo(List(List(3, 3), List(9)))
    }

    "returns [[2, 2, 2], [2, 4], [8]] if fs = [2, 2, 2]" in {
      P088.productLists(List(2, 2, 2)) must beEqualTo(List(List(2, 2, 2), List(2, 4), List(8)))
    }
  }

  "P088#findK(Int)" should {
    "returns [1] if n = 1" in {
      P088.findK(1) must beEqualTo(List(1))
    }

    "returns [1] if n = 2" in {
      P088.findK(2) must beEqualTo(List(1))
    }

    "returns [1] if n = 3" in {
      P088.findK(3) must beEqualTo(List(1))
    }

    "returns [1, 2] if n = 4" in {
      P088.findK(4) must beEqualTo(List(1, 2))
    }

    "returns [1, 3] if n = 6" in {
      P088.findK(6) must beEqualTo(List(1, 3))
    }

    "returns [1, 4, 5] if n = 8" in {
      P088.findK(8) must beEqualTo(List(1, 4, 5))
    }

    "returns [1, 5] if n = 9" in {
      P088.findK(9) must beEqualTo(List(1, 5))
    }

    "returns [1, 5] if n = 10" in {
      P088.findK(10) must beEqualTo(List(1, 5))
    }

    "returns [1, 6, 7, 8] if n = 12" in {
      P088.findK(12) must beEqualTo(List(1, 6, 7, 8))
    }
  }

  "P088#solve(Int)" should {
    "returns 30 if n = 6" in {
      P088.solve(6) must beEqualTo(30)
    }

    "returns 61 if n = 12" in {
      P088.solve(12) must beEqualTo(61)
    }

    "returns 7587457 if n = 12000" in {
      P088.solve(12000) must beEqualTo(7587457)
    }
  }
}
