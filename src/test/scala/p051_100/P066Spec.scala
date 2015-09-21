package test.project_euler

import project_euler.P066
import org.specs2.mutable._

class P066Spec extends Specification {
  "P066#solve(Int)" should {
    "returns 5 if n = 7" in {
      P066.solve(7) must beEqualTo(5)
    }

    "returns 661 if n = 1000" in {
      P066.solve(1000) must beEqualTo(661)
    }
  }
}
