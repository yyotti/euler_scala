package test.project_euler

import project_euler.P010
import org.specs2.mutable._

class P010Spec extends Specification {
  "P010#sieve(List[Int])" should {
    "returns [] if nums = []" in {
      P010.sieve(Nil) must beEmpty
    }

    "returns [2, 3, 5, 7] if nums = [2, 3, 4, 5, 6, 7, 8, 9, 10]" in {
      P010.sieve(List(2, 3, 4, 5, 6, 7, 8, 9, 10)) must beEqualTo(List(2, 3, 5, 7))
    }
  }

  "P010#solve(Int)" should {
    "returns 17 if max = 10" in {
      P010.solve(10) must beEqualTo(17)
    }

    "returns 142913828922 if max = 2000000" in {
      P010.solve(2000000) must beEqualTo(142913828922L)
    }
  }
}
