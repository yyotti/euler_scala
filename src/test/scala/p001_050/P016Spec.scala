package test.project_euler

import project_euler.P016
import org.specs2.mutable._

class P016Spec extends Specification {
  "P016#pow(Int)" should {
    "returns 1 if n = 0" in {
      P016.pow(0) must beEqualTo(1)
    }

    "returns 2 if n = 1" in {
      P016.pow(1) must beEqualTo(2)
    }

    "returns 4 if n = 2" in {
      P016.pow(2) must beEqualTo(4)
    }

    "returns 1024 if n = 10" in {
      P016.pow(10) must beEqualTo(1024)
    }
  }

  "P016#solve(Int)" should {
    "returns 26 if n = 15" in {
      P016.solve(15) must beEqualTo(26)
    }

    "returns 1366 if n = 1000" in {
      P016.solve(1000) must beEqualTo(1366)
    }
  }
}
