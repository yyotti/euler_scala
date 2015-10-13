package test.project_euler

import project_euler.P094
import org.specs2.mutable._

class P094Spec extends Specification {
  "P094#solve(Int)" should {
    "returns 16 if n = 20" in {
      P094.solve(20) must beEqualTo(16)
    }

    "returns 518408346 if n = 1,000,000,000" in {
      P094.solve(1000000000) must beEqualTo(518408346)
    }
  }
}
