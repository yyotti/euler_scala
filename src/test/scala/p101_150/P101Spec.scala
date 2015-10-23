package test.project_euler

import project_euler.P101
import org.specs2.mutable._

class P101Spec extends Specification {
  "P101#u" should {
    "first 10 terms are [1, 683, 44287, 838861, 8138021, 51828151, 247165843, 954437177, 3138105961, 9090909091]" in {
      P101.u.take(10).toList must beEqualTo(List(1, 683, 44287, 838861, 8138021, 51828151, 247165843, 954437177, 3138105961L, 9090909091L))
    }
  }

  "P101#op(Int, Int)" should {
    "returns 1 if (k, n) = (1, 1)" in {
      P101.op(1, 1) must beEqualTo(1)
    }

    "returns 1 if (k, n) = (1, 2)" in {
      P101.op(1, 2) must beEqualTo(1)
    }

    "returns 1 if (k, n) = (2, 1)" in {
      P101.op(2, 1) must beEqualTo(1)
    }

    "returns 683 if (k, n) = (2, 2)" in {
      P101.op(2, 2) must beEqualTo(683)
    }

    "returns 1365 if (k, n) = (2, 3)" in {
      P101.op(2, 3) must beEqualTo(1365)
    }

    "returns 1 if (k, n) = (3, 1)" in {
      P101.op(3, 1) must beEqualTo(1)
    }

    "returns 683 if (k, n) = (3, 2)" in {
      P101.op(3, 2) must beEqualTo(683)
    }

    "returns 44287 if (k, n) = (3, 3)" in {
      P101.op(3, 3) must beEqualTo(44287)
    }

    "returns 130813 if (k, n) = (3, 4)" in {
      P101.op(3, 4) must beEqualTo(130813)
    }

    "returns 1 if (k, n) = (4, 1)" in {
      P101.op(4, 1) must beEqualTo(1)
    }

    "returns 683 if (k, n) = (4, 2)" in {
      P101.op(4, 2) must beEqualTo(683)
    }

    "returns 44287 if (k, n) = (4, 3)" in {
      P101.op(4, 3) must beEqualTo(44287)
    }

    "returns 838861 if (k, n) = (4, 4)" in {
      P101.op(4, 4) must beEqualTo(838861)
    }

    "returns 3092453 if (k, n) = (4, 5)" in {
      P101.op(4, 5) must beEqualTo(3092453)
    }
  }

  "P101#coefficients(Int)" should {
    "returns [1] if k = 1" in {
      P101.coefficients(1) must beEqualTo(List(1))
    }

    "returns [-681, 682] if k = 2" in {
      P101.coefficients(2) must beEqualTo(List(-681, 682))
    }

    "returns [42241, -63701, 21461] if k = 3" in {
      P101.coefficients(3) must beEqualTo(List(42241, -63701, 21461))
    }

    "returns [-665807, 1234387, -686587, 118008] if k = 4" in {
      P101.coefficients(4) must beEqualTo(List(-665807, 1234387, -686587, 118008))
    }
  }

  "P101#gaussJordanElimination(List[List[Long]], List[Long])" should {
    "returns ([[1]], [1]) if (a, b) = ([[1]], [1])" in {
      val a = List(
        List(1L)
      )
      val b = List(1L)

      val expectedA = List(
        List(1)
      )
      val expectedB = List(1)
      P101.gaussJordanElimination(a, b) must beEqualTo(expectedA, expectedB)
    }

    "returns (E, [-681, 682]) if (a, b) = (<省略>, [1, 683])" in {
      val a = List(
        List(1L, 1),
        List(1L, 2)
      )
      val b = List(1L, 683)

      val expectedA = List(
        List(1, 0),
        List(0, 1)
      )
      val expectedB = List(-681, 682)
      P101.gaussJordanElimination(a, b) must beEqualTo(expectedA, expectedB)
    }

    "returns (E, [42241, -63701, 21461]) if (a, b) = (<省略>, [1, 683, 44287])" in {
      val a = List(
        List(1L, 1, 1),
        List(1L, 2, 4),
        List(1L, 3, 9)
      )
      val b = List(1L, 683, 44287)

      val expectedA = List(
        List(1, 0, 0),
        List(0, 1, 0),
        List(0, 0, 1)
      )
      val expectedB = List(42241, -63701, 21461)
      P101.gaussJordanElimination(a, b) must beEqualTo(expectedA, expectedB)
    }
  }

  "P101#fit(Int)" should {
    "returns 1 if k = 1" in {
      P101.fit(1) must beEqualTo(1)
    }

    "returns 1365 if k = 2" in {
      P101.fit(2) must beEqualTo(1365)
    }

    "returns 130813 if k = 3" in {
      P101.fit(3) must beEqualTo(130813)
    }

    "returns 3092453 if k = 4" in {
      P101.fit(4) must beEqualTo(3092453)
    }
  }

  "P101#solve(Int)" should {
    "returns 3224632" in {
      P101.solve(4) must beEqualTo(3224632)
    }

    "returns 37076114526" in {
      P101.solve(10) must beEqualTo(37076114526L)
    }
  }
}
