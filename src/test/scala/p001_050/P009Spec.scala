package test.project_euler

import project_euler.P009
import org.specs2.mutable._

class P009Spec extends Specification {
  "P009#primitivePythagoreanTriprets" should {
    "first 10 terms are [(3, 4, 5), (5, 12, 13), (15, 8, 17), (7, 24, 25), (21, 20, 29), (9, 40, 41), (35, 12, 37), (11, 60, 61), (45, 28, 53), (33, 56, 65)]" in {
      P009.primitivePythagoreanTriprets.take(10).toList must beEqualTo(List((3, 4, 5), (5, 12, 13), (15, 8, 17), (7, 24, 25), (21, 20, 29), (9, 40, 41), (35, 12, 37), (11, 60, 61), (45, 28, 53), (33, 56, 65)))
    }
  }

  "P009#solve" should {
    "returns 31875000" in {
      P009.solve must beEqualTo(31875000)
    }
  }
}
