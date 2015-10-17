package test.project_euler

import project_euler.P096
import org.specs2.mutable._

class P096Spec extends Specification {
  "P096#rowIndices(Int)" should {
    "returns [0, 1, 2, 3, 4, 5, 6, 7, 8] if index = 0" in {
      P096.rowIndices(0) must beEqualTo(0 to 8)
    }

    "returns [0, 1, 2, 3, 4, 5, 6, 7, 8] if index = 3" in {
      P096.rowIndices(3) must beEqualTo(0 to 8)
    }

    "returns [9, 10, 11, 12, 13, 14, 15, 16, 17] if index = 10" in {
      P096.rowIndices(10) must beEqualTo(9 to 17)
    }
  }

  "P096#colIndices(Int)" should {
    "returns [0, 9, 18, 27, 36, 45, 54, 63, 72] if index = 0" in {
      P096.colIndices(0) must beEqualTo(0 to 72 by 9)
    }

    "returns [3, 12, 21, 30, 39, 48, 57, 66, 75] if index = 3" in {
      P096.colIndices(3) must beEqualTo(3 to 75 by 9)
    }

    "returns [1, 10, 19, 28, 37, 46, 55, 64, 73] if index = 10" in {
      P096.colIndices(10) must beEqualTo(1 to 73 by 9)
    }
  }

  "P096#blockIndices(Int)" should {
    "returns [0, 1, 2, 9, 10, 11, 18, 19, 20] if index = 0" in {
      P096.blockIndices(0) must beEqualTo(Seq(0, 1, 2, 9, 10, 11, 18, 19, 20))
    }

    "returns [0, 1, 2, 9, 10, 11, 18, 19, 20] if index = 10" in {
      P096.blockIndices(10) must beEqualTo(Seq(0, 1, 2, 9, 10, 11, 18, 19, 20))
    }

    "returns [3, 4, 5, 12, 13, 14, 21, 22, 23] if index = 13" in {
      P096.blockIndices(13) must beEqualTo(Seq(3, 4, 5, 12, 13, 14, 21, 22, 23))
    }

    "returns [0, 1, 2, 9, 10, 11, 18, 19, 20] if index = 18" in {
      P096.blockIndices(18) must beEqualTo(Seq(0, 1, 2, 9, 10, 11, 18, 19, 20))
    }

    "returns [27, 28, 29, 36, 37, 38, 45, 46, 47] if index = 29" in {
      P096.blockIndices(29) must beEqualTo(Seq(27, 28, 29, 36, 37, 38, 45, 46, 47))
    }

    "returns [30, 31, 32, 39, 40, 41, 48, 49, 50] if index = 32" in {
      P096.blockIndices(32) must beEqualTo(Seq(30, 31, 32, 39, 40, 41, 48, 49, 50))
    }
  }

  "P096#decide(Array[Either[Set[Int]]], Int, Int)" should {
    val set = Left((1 to 9).toSet)
    val field = Array.fill[Either[Set[Int], Int]](81) { set }

    "returns <省略> if (field, index, n) = (<省略>, 1, 5)" in {
      val expected =
        field
          .zipWithIndex
          .map { case (point, i) =>
            point match {
              case Left(set) =>
                if (i == 1) Right(5)
                else if ((0 to 8).contains(i)) Left(set - 5)
                else if ((1 to 73 by 9).contains(i)) Left(set - 5)
                else if ((0 to 2).contains(i) || (9 to 11).contains(i) || (18 to 20).contains(i)) Left(set - 5)
                else Left(set)
              case _ => point
            }
          }

      P096.decide(field, 1, 5) must beEqualTo(expected)
    }
  }

  "P096#initField(Seq[String])" should {
    "returns <省略> if lines = <省略>" in {
      val set = Left((1 to 9).toSet)
      val lines = List(
        "003020600",
        "900305001",
        "001806400",
        "008102900",
        "700000008",
        "006708200",
        "002609500",
        "800203009",
        "005010300"
      )
      val field = P096.initField(lines)
      field(0) must beEqualTo(Left(Set(4, 5)))
      field(1) must beEqualTo(Left(Set(4, 5, 7, 8)))
      field(18) must beEqualTo(Left(Set(2, 5)))
      field(70) must beEqualTo(Left(Set(1, 4, 6, 7)))
      field(76) must beEqualTo(Right(1))
    }
  }

  "P096#findDecidable(Array[Either[Set[Int]]])" should {
    val set = Left((1 to 9).toSet)
    val field = Array.fill[Either[Set[Int], Int]](81) { set }

    "returns None if field = <省略>" in {
      P096.findDecidable(field) must beNone
    }

    "returns Some(20) if field = <省略>" in {
      P096.findDecidable(field.updated(20, Left(Set(1)))) must beSome(20)
    }

    "returns Some(10) if field = <省略>" in {
      P096.findDecidable(field.updated(20, Left(Set(1))).updated(10, Left(Set(3)))) must beSome(10)
    }
  }

  "P096#isCompleted(Array[Either[Set[Int]]])" should {
    val set = Left((1 to 9).toSet)
    val right = Right(9)

    "returns false if field = <省略>" in {
      P096.isCompleted(Array.fill[Either[Set[Int], Int]](81) { set }) must beFalse
    }

    "returns false if field = <省略>" in {
      P096.isCompleted(Array.fill[Either[Set[Int], Int]](81) { right }.updated(3, set)) must beFalse
    }

    "returns false if field = <省略>" in {
      P096.isCompleted(Array.fill[Either[Set[Int], Int]](81) { right }.updated(6, Left(Set(3)))) must beFalse
    }

    "returns true if field = <省略>" in {
      P096.isCompleted(Array.fill[Either[Set[Int], Int]](81) { right }) must beTrue
    }
  }

  "P096#findAnswers(Array[Either[Set[Int]]])" should {
    val set = (1 to 9).toSet
    def l(ns: Int*) = Left(set -- ns)
    def r(n: Int) = Right(n)

    val field = Array[Either[Set[Int], Int]](
      Left(Set(5, 4)), Left(Set(5, 7, 8, 4)), Right(3), Left(Set(9, 4)), Right(2), Left(Set(1, 7, 4)), Right(6), Left(Set(5, 9, 7, 8)), Left(Set(5, 7)),
      Right(9), Left(Set(6, 2, 7, 8, 4)), Left(Set(7, 4)), Right(3), Left(Set(7, 4)), Right(5), Left(Set(7, 8)), Left(Set(2, 7, 8)), Right(1),
      Left(Set(5, 2)), Left(Set(5, 2, 7)), Right(1), Right(8), Left(Set(9, 7)), Right(6), Right(4), Left(Set(5, 9, 2, 7, 3)), Left(Set(5, 2, 7, 3)),
      Left(Set(5, 3, 4)), Left(Set(5, 3, 4)), Right(8), Right(1), Left(Set(5, 6, 3, 4)), Right(2), Right(9), Left(Set(5, 6, 7, 3, 4)), Left(Set(5, 6, 7, 3, 4)),
      Right(7), Left(Set(5, 1, 9, 2, 3, 4)), Left(Set(9, 4)), Left(Set(5, 9, 4)), Left(Set(5, 6, 9, 3, 4)), Left(Set(4)), Left(Set(1)), Left(Set(5, 1, 6, 3, 4)), Right(8),
      Left(Set(5, 1, 3, 4)), Left(Set(5, 1, 9, 3, 4)), Right(6), Right(7), Left(Set(5, 9, 3, 4)), Right(8), Right(2), Left(Set(5, 1, 3, 4)), Left(Set(5, 3, 4)),
      Left(Set(1, 3, 4)), Left(Set(1, 7, 3, 4)), Right(2), Right(6), Left(Set(7, 8, 4)), Right(9), Right(5), Left(Set(1, 7, 8, 4)), Left(Set(7, 4)),
      Right(8), Left(Set(1, 6, 7, 4)), Left(Set(7, 4)), Right(2), Left(Set(5, 7, 4)), Right(3), Left(Set(1, 7)), Left(Set(1, 6, 7, 4)), Right(9),
      Left(Set(6, 4)), Left(Set(6, 9, 7, 4)), Right(5), Left(Set(4)), Right(1), Left(Set(7, 4)), Right(3), Left(Set(6, 2, 7, 8, 4)), Left(Set(6, 2, 7, 4))
    )

    "returns <省略> if field = <省略>" in {
      val expected = List(
        Right(4), Right(8), Right(3), Right(9), Right(2), Right(1), Right(6), Right(5), Right(7),
        Right(9), Right(6), Right(7), Right(3), Right(4), Right(5), Right(8), Right(2), Right(1),
        Right(2), Right(5), Right(1), Right(8), Right(7), Right(6), Right(4), Right(9), Right(3),
        Right(5), Right(4), Right(8), Right(1), Right(3), Right(2), Right(9), Right(7), Right(6),
        Right(7), Right(2), Right(9), Right(5), Right(6), Right(4), Right(1), Right(3), Right(8),
        Right(1), Right(3), Right(6), Right(7), Right(9), Right(8), Right(2), Right(4), Right(5),
        Right(3), Right(7), Right(2), Right(6), Right(8), Right(9), Right(5), Right(1), Right(4),
        Right(8), Right(1), Right(4), Right(2), Right(5), Right(3), Right(7), Right(6), Right(9),
        Right(6), Right(9), Right(5), Right(4), Right(1), Right(7), Right(3), Right(8), Right(2)
      )
      P096.findAnswers(field).map { _.toList } must beEqualTo(Set(expected))
    }
  }

  "P096#solveNPs(Seq[Seq[String]])" should {
    val lines = Seq(
      Seq("003020600", "900305001", "001806400", "008102900", "700000008", "006708200", "002609500", "800203009", "005010300"),
      Seq("200080300", "060070084", "030500209", "000105408", "000000000", "402706000", "301007040", "720040060", "004010003"),
      Seq("000000907", "000420180", "000705026", "100904000", "050000040", "000507009", "920108000", "034059000", "507000000")
    )

    "returns <省略> if lines = <省略>" in {
      val expected = List(
        4, 8, 3, 9, 2, 1, 6, 5, 7,
        9, 6, 7, 3, 4, 5, 8, 2, 1,
        2, 5, 1, 8, 7, 6, 4, 9, 3,
        5, 4, 8, 1, 3, 2, 9, 7, 6,
        7, 2, 9, 5, 6, 4, 1, 3, 8,
        1, 3, 6, 7, 9, 8, 2, 4, 5,
        3, 7, 2, 6, 8, 9, 5, 1, 4,
        8, 1, 4, 2, 5, 3, 7, 6, 9,
        6, 9, 5, 4, 1, 7, 3, 8, 2
      )

      val answers = P096.solveNPs(lines)
      answers.size must beEqualTo(3)
      answers.head.toList must beEqualTo(expected)
    }
  }

  "P096#solve" should {
    "returns 24702" in {
      P096.solve must beEqualTo(24702)
    }
  }
}
