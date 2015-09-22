package test.project_euler

import project_euler.P068
import org.specs2.mutable._

class P068Spec extends Specification {
  "P068#solve(Int)" should {
    "returns 432621513 if n = 3" in {
      P068.solve(3) must beEqualTo(432621513)
    }

    "returns 6531031914842725 if n = 5" in {
      P068.solve(5) must beEqualTo(6531031914842725L)
    }
  }
}
