package test.project_euler

import project_euler.P043
import org.specs2.mutable._

class P043Spec extends Specification {
  "P043#solve" should {
    "returns 16695334890" in {
      P043.solve must beEqualTo(16695334890L)
    }
  }
}
