package test.project_euler

import project_euler.P074
import org.specs2.mutable._

class P074Spec extends Specification {
  "P074#findNonRepeatingPart(Int)" should {
    "returns [145] if start = 145" in {
      P074.findNonRepeatingPart(145, collection.mutable.Map()) must beEqualTo(List(145))
    }

    "returns [169, 363601, 1454] if start = 169" in {
      P074.findNonRepeatingPart(169, collection.mutable.Map()) must beEqualTo(List(169, 363601, 1454))
    }

    "returns [871, 45361] if start = 871" in {
      P074.findNonRepeatingPart(871, collection.mutable.Map()) must beEqualTo(List(871, 45361))
    }

    "returns [872, 45362] if start = 872" in {
      P074.findNonRepeatingPart(872, collection.mutable.Map()) must beEqualTo(List(872, 45362))
    }

    "returns [69, 363600, 1454, 169, 363601] if start = 69" in {
      P074.findNonRepeatingPart(69, collection.mutable.Map()) must beEqualTo(List(69, 363600, 1454, 169, 363601))
    }

    "returns [78, 45360, 871, 45361] if start = 78" in {
      P074.findNonRepeatingPart(78, collection.mutable.Map()) must beEqualTo(List(78, 45360, 871, 45361))
    }

    "returns [540, 145] if start = 540" in {
      P074.findNonRepeatingPart(540, collection.mutable.Map()) must beEqualTo(List(540, 145))
    }
  }

  "P074#solve" should {
    "returns 402" in {
      P074.solve must beEqualTo(402)
    }
  }
}
