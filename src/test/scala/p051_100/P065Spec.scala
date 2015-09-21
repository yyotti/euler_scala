package test.project_euler

import project_euler.P065
import org.specs2.mutable._

class P065Spec extends Specification {
  "P065#solve(Int)" should {
    "returns 17 if n = 10" in {
      P065.solve(10) must beEqualTo(17)
    }

    "returns 272 if n = 100" in {
      P065.solve(100) must beEqualTo(272)
    }
  }
}
