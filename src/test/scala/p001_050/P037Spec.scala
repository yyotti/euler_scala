package test.project_euler

import project_euler.P037
import org.specs2.mutable._

class P037Spec extends Specification {
  "P037#solve" should {
    "returns 748317" in {
      P037.solve must beEqualTo(748317)
    }
  }
}
