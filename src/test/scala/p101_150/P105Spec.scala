package test.project_euler

import project_euler.P105
import org.specs2.mutable._

class P105Spec extends Specification {
  "P105#validate(List[Int])" should {
    "returns true if nums = [1]" in {
      P105.validate(List(1)) must beTrue
    }

    "returns true if nums = [1, 2]" in {
      P105.validate(List(1, 2)) must beTrue
    }

    "returns false if nums = [1, 2, 3]" in {
      P105.validate(List(1, 2, 3)) must beFalse
    }

    "returns true if nums = [2, 3, 4]" in {
      P105.validate(List(2, 3, 4)) must beTrue
    }

    "returns true if nums = [3, 5, 6, 7]" in {
      P105.validate(List(3, 5, 6, 7)) must beTrue
    }

    "returns false if nums = [42, 65, 75, 81, 84, 86, 87, 88]" in {
      P105.validate(List(42, 65, 75, 81, 84, 86, 87, 88)) must beFalse
    }

    "returns true if nums = [79, 119, 139, 150, 157, 158, 159, 161, 164]" in {
      P105.validate(List(79, 119, 139, 150, 157, 158, 159, 161, 164)) must beTrue
    }
  }

  "P105#solve" should {
    "returns 73702" in {
      P105.solve must beEqualTo(73702)
    }
  }
}
