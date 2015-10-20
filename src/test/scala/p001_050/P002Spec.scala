package test.project_euler

import project_euler.P002
import org.specs2.mutable._

class P002Spec extends Specification {
  "P002#fib" should {
    "first 10 terms are [1, 2, 3, 5, 8, 13, 21, 34, 55, 89]" in {
      P002.fib.take(10).toList must beEqualTo(List(1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
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
