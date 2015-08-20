package test.project_euler

import project_euler.P002
import org.specs2.mutable._

class P002Spec extends Specification {
  "P002#fib(a1, a2, max)" should {
    "returns [] if (a1, a2, max) = (1, 2, 0)" in {
      P002.fib(1, 2, 0) must beEmpty
    }

    "returns [1] if (a1, a2, max) = (1, 2, 1)" in {
      P002.fib(1, 2, 1) must beEqualTo(List(1))
    }

    "returns [1, 2] if (a1, a2, max) = (1, 2, 2)" in {
      P002.fib(1, 2, 2) must beEqualTo(List(1, 2))
    }

    "returns [1, 2, 3] if (a1, a2, max) = (1, 2, 3)" in {
      P002.fib(1, 2, 3) must beEqualTo(List(1, 2, 3))
    }

    "returns [1, 2, 3] if (a1, a2, max) = (1, 2, 4)" in {
      P002.fib(1, 2, 4) must beEqualTo(List(1, 2, 3))
    }

    "returns [1, 2, 3, 5, 8, 13, 21, 34, 55, 89] if (a1, a2, max) = (1, 2, 90)" in {
      P002.fib(1, 2, 90) must beEqualTo(List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
    }
  }

  "P002#solve(n)" should {
    "returns 44 if n = 90" in {
      P002.solve(90) must beEqualTo(44)
    }

    "returns 4613732 if n = 4,000,000" in {
      P002.solve(4000000) must beEqualTo(4613732)
    }
  }
}
