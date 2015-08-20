package test.project_euler

import project_euler.P002
import org.specs2.mutable._

class P002Spec extends Specification {
  "P002#solve(n)" should {
    "returns 44 if n = 90" in {
      // フィボナッチ数列の最初の10項は90以下
      P002.solve(10) must beEqualTo(44)
    }

    "returns 4613732 if n = 4,000,000" in {
      P002.solve(4000000) must beEqualTo(4613732)
    }
  }
}
