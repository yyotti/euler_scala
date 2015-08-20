package test.project_euler

import project_euler.P003
import org.specs2.mutable._

class P003Spec extends Specification {
  "P003#solve(n)" should {
    "returns 29 if n = 13195" in {
      P003.solve(13195) must beEqualTo(29)
    }

    "returns 6857 if n = 600851475143" in {
      P003.solve(600851475143L) must beEqualTo(6857)
    }
  }
}
