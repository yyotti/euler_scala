package test.project_euler

import project_euler.P096
import org.specs2.mutable._

class P096Spec extends Specification {
  "P096#solve" should {
    "returns 24702" in {
      P096.solve must beEqualTo(24702)
    }
  }
}
