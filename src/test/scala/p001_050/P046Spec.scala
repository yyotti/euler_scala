package test.project_euler

import project_euler.P046
import org.specs2.mutable._

class P046Spec extends Specification {
  "P046#squares" should {
    "first 10 terms are [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]" in {
      P046.squares.take(10).toList must beEqualTo(List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100))
    }
  }

  "P046#solve" should {
    "returns 5777" in {
      P046.solve must beEqualTo(5777)
    }
  }
}
