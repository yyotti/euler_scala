package test.project_euler

import project_euler.P093
import project_euler.P093.{Num, Plus, Minus, Times, Div, ParenthesisS, ParenthesisE}
import org.specs2.mutable._

class P093Spec extends Specification {
  "P093#toRPN(List[FormulaElement])" should {
    "returns [4, 1, 3, +, *, 2, /] if formula = [(, 4, *, (, 1, +, 3, ), ), /, 2]" in {
      P093.toRPN(List(ParenthesisS, Num(4), Times, ParenthesisS, Num(1), Plus, Num(3), ParenthesisE, ParenthesisE, Div, Num(2))) must beEqualTo(List(Num(4), Num(1), Num(3), Plus, Times, Num(2), Div))
    }

    "returns [4, 3, 1, 2, /, +, *] if formula = [4, *, (, 3, +, 1, /, 2, )]" in {
      P093.toRPN(List(Num(4), Times, ParenthesisS, Num(3), Plus, Num(1), Div, Num(2), ParenthesisE)) must beEqualTo(List(Num(4), Num(3), Num(1), Num(2), Div, Plus, Times))
    }

    "returns [4, 2, 3, +, *, 1, -] if formula = [4, *, (, 2, +, 3, ), -, 1]" in {
      P093.toRPN(List(Num(4), Times, ParenthesisS, Num(2), Plus, Num(3), ParenthesisE, Minus, Num(1))) must beEqualTo(List(Num(4), Num(2), Num(3), Plus, Times, Num(1), Minus))
    }

    "returns [3, 4, *, 2, 1, +, *] if formula = [3, *, 4, *, (, 2, +, 1, )]" in {
      P093.toRPN(List(Num(3), Times, Num(4), Times, ParenthesisS, Num(2), Plus, Num(1), ParenthesisE)) must beEqualTo(List(Num(3), Num(4), Times, Num(2), Num(1), Plus, Times))
    }
  }

  "P093#calcRPN(List[FormulaElement])" should {
    "returns 8 if formula = [4, 1, 3, +, *, 2, /]" in {
      P093.calcRPN(List(Num(4), Num(1), Num(3), Plus, Times, Num(2), Div)) must beEqualTo(8)
    }

    "returns 14 if formula = [4, 3, 1, 2, /, +, *]" in {
      P093.calcRPN(List(Num(4), Num(3), Num(1), Num(2), Div, Plus, Times)) must beEqualTo(14)
    }

    "returns 19 if formula = [4, 2, 3, +, *, 1, -]" in {
      P093.calcRPN(List(Num(4), Num(2), Num(3), Plus, Times, Num(1), Minus)) must beEqualTo(19)
    }

    "returns 36 if formula = [3, 4, *, 2, 1, +, *]" in {
      P093.calcRPN(List(Num(3), Num(4), Times, Num(2), Num(1), Plus, Times)) must beEqualTo(36)
    }
  }

  "P093#insertOperators(List[Num])" should {
    "returns [[]] if nums = []" in {
      P093.insertOperators(Nil) must beEqualTo(List(Nil))
    }

    "returns [[1]] if nums = [1]" in {
      P093.insertOperators(List(Num(1))) must beEqualTo(List(List(Num(1))))
    }

    "returns [[1, +, 2], [1, -, 2], [1, *, 2], [1, /, 2]] if nums = [1, 2]" in {
      val expected = List(
        List(Num(1), Plus, Num(2)),
        List(Num(1), Minus, Num(2)),
        List(Num(1), Times, Num(2)),
        List(Num(1), Div, Num(2))
      )
      P093.insertOperators(List(Num(1), Num(2))) must beEqualTo(expected)
    }

    "returns [[1, +, 2, +, 3], [1, +, 2, -, 3], ...] if nums = [1, 2, 3]" in {
      val expected = List(
        List(Num(1), Plus, Num(2), Plus, Num(3)),
        List(Num(1), Plus, Num(2), Minus, Num(3)),
        List(Num(1), Plus, Num(2), Times, Num(3)),
        List(Num(1), Plus, Num(2), Div, Num(3)),
        List(Num(1), Minus, Num(2), Plus, Num(3)),
        List(Num(1), Minus, Num(2), Minus, Num(3)),
        List(Num(1), Minus, Num(2), Times, Num(3)),
        List(Num(1), Minus, Num(2), Div, Num(3)),
        List(Num(1), Times, Num(2), Plus, Num(3)),
        List(Num(1), Times, Num(2), Minus, Num(3)),
        List(Num(1), Times, Num(2), Times, Num(3)),
        List(Num(1), Times, Num(2), Div, Num(3)),
        List(Num(1), Div, Num(2), Plus, Num(3)),
        List(Num(1), Div, Num(2), Minus, Num(3)),
        List(Num(1), Div, Num(2), Times, Num(3)),
        List(Num(1), Div, Num(2), Div, Num(3))
      )
      P093.insertOperators(List(Num(1), Num(2), Num(3))) must beEqualTo(expected)
    }
  }

  "P093#addParenthesis(List[FormulaElement])" should {
    "returns [[1, +, 2, -, 3, *, 4], [(, 1, +, 2, ), -, 3, *, 4], ...] if nums = [1, +, 2, -, 3, *, 4]" in {
      val expected = List(
        List(Num(1), Plus, Num(2), Minus, Num(3), Times, Num(4)),
        List(ParenthesisS, Num(1), Plus, Num(2), ParenthesisE, Minus, Num(3), Times, Num(4)),
        List(Num(1), Plus, ParenthesisS, Num(2), Minus, Num(3), ParenthesisE, Times, Num(4)),
        List(Num(1), Plus, Num(2), Minus, ParenthesisS, Num(3), Times, Num(4), ParenthesisE),
        List(ParenthesisS, Num(1), Plus, Num(2), ParenthesisE, Minus, ParenthesisS, Num(3), Times, Num(4), ParenthesisE),
        List(ParenthesisS, Num(1), Plus, Num(2), Minus, Num(3), ParenthesisE, Times, Num(4)),
        List(Num(1), Plus, ParenthesisS, Num(2), Minus, Num(3), Times, Num(4), ParenthesisE),
        List(ParenthesisS, ParenthesisS, Num(1), Plus, Num(2), ParenthesisE, Minus, Num(3), ParenthesisE, Times, Num(4)),
        List(ParenthesisS, Num(1), Plus, ParenthesisS, Num(2), Minus, Num(3), ParenthesisE, ParenthesisE, Times, Num(4)),
        List(Num(1), Plus, ParenthesisS, ParenthesisS, Num(2), Minus, Num(3), ParenthesisE, Times, Num(4), ParenthesisE),
        List(Num(1), Plus, ParenthesisS, Num(2), Minus, ParenthesisS, Num(3), Times, Num(4), ParenthesisE, ParenthesisE)
      )
      P093.addParenthesis(List(Num(1), Plus, Num(2), Minus, Num(3), Times, Num(4))) must beEqualTo(expected)
    }
  }

  "P093#findN(List[Int])" should {
    "returns 28 if nums = [1, 2, 3, 4]" in {
      P093.findN(List(1, 2, 3, 4)) must beEqualTo(28)
    }
  }

  "P093#solve(Int)" should {
    """returns "1258"""" in {
      P093.solve must beEqualTo("1258")
    }
  }
}
