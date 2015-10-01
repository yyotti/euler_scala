package test.project_euler

import project_euler.P078
import org.specs2.mutable._

class P078Spec extends Specification {
  "P078#pentagonal(Int)" should {
    "returns 0 if n = 0" in {
      P078.pentagonal(0) must beEqualTo(0)
    }

    "returns 1 if n = 1" in {
      P078.pentagonal(1) must beEqualTo(1)
    }

    "returns 2 if n = -1" in {
      P078.pentagonal(-1) must beEqualTo(2)
    }

    "returns 5 if n = 2" in {
      P078.pentagonal(2) must beEqualTo(5)
    }

    "returns 7 if n = -2" in {
      P078.pentagonal(-2) must beEqualTo(7)
    }

    "returns 12 if n = 3" in {
      P078.pentagonal(3) must beEqualTo(12)
    }

    "returns 15 if n = -3" in {
      P078.pentagonal(-3) must beEqualTo(15)
    }
  }

  "P078#pentagonals" should {
    "first 10 terms are [1, 2, 5, 7, 12, 15, 22, 26, 35, 40]" in {
      P078.pentagonals.take(10).toList must beEqualTo(List(1, 2, 5, 7, 12, 15, 22, 26, 35, 40))
    }
  }

  "P078#signs" should {
    "first 10 terms are [1, 1, -1, -1, 1, 1, -1, -1, 1, 1]" in {
      P078.signs.take(10).toList must beEqualTo(List(1, 1, -1, -1, 1, 1, -1, -1, 1, 1))
    }
  }

  "P078#p(Int)" should {
    "returns 0 if n = -1" in {
      P078.p(-1) must beEqualTo(0)
    }

    "returns 1 if n = 0" in {
      P078.p(0) must beEqualTo(1)
    }

    "returns 1 if n = 1" in {
      P078.p(1) must beEqualTo(1)
    }

    "returns 2 if n = 2" in {
      P078.p(2) must beEqualTo(2)
    }

    "returns 3 if n = 3" in {
      P078.p(3) must beEqualTo(3)
    }

    "returns 5 if n = 4" in {
      P078.p(4) must beEqualTo(5)
    }

    "returns 7 if n = 5" in {
      P078.p(5) must beEqualTo(7)
    }

    "returns 11 if n = 6" in {
      P078.p(6) must beEqualTo(11)
    }

    "returns 15 if n = 7" in {
      P078.p(7) must beEqualTo(15)
    }

    "returns 22 if n = 8" in {
      P078.p(8) must beEqualTo(22)
    }

    "returns 569292 if n = 100" in {
      P078.p(100) must beEqualTo(569292)
    }

    "returns 29388 if n = 200" in {
      P078.p(200) must beEqualTo(29388)
    }
  }

  "P078#solve" should {
    "returns 55374" in {
      P078.solve must beEqualTo(55374)
    }
  }
}
