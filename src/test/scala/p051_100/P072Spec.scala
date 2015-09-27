package test.project_euler

import project_euler.P072
import org.specs2.mutable._

class P072Spec extends Specification {
  "P072#solve(Int)" should {
    "returns 21 if d = 8" in {
      P072.solve(8) must beEqualTo(21)
    }

    "returns 303963552391 if d = 1000000" in {
      P072.solve(1000000) must beEqualTo(303963552391L)
    }
  }
}
