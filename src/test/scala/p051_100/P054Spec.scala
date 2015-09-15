package test.project_euler

import project_euler.P054
import project_euler.P054.{Card, Hand}
import org.specs2.mutable._

class P054Spec extends Specification {
  "Card->apply(String)" should {
    "returns Card(4S)" in {
      Card("4S") must beEqualTo(Card(3, 4))
    }

    "returns Card(AD)" in {
      Card("AD") must beEqualTo(Card(0, 14))
    }

    "returns Card(TC)" in {
      Card("TC") must beEqualTo(Card(1, 10))
    }

    "returns Card(JH)" in {
      Card("JH") must beEqualTo(Card(2, 11))
    }

    "returns Card(QH)" in {
      Card("QH") must beEqualTo(Card(2, 12))
    }

    "returns Card(KC)" in {
      Card("KC") must beEqualTo(Card(1, 13))
    }
  }

  "Card->compare(Card)" should {
    "returns true if (Card(4S) < Card(AD))" in {
      (Card("4S") < Card("AD")) must beTrue
    }

    "returns true if (Card(4S) > Card(4D))" in {
      (Card("4S") > Card("4D")) must beTrue
    }

    "returns false if (Card(4S) > Card(5S))" in {
      (Card("4S") > Card("5S")) must beFalse
    }

    "returns true if (Card(4S) == Card(4S))" in {
      (Card("4S") == Card("4S")) must beTrue
    }
  }

  "Hand->apply(String)" should {
    "returns Hand(8C TS KC 9H 4S)" in {
      Hand("8C TS KC 9H 4S") must beEqualTo(Hand(Card("8C"), Card("TS"), Card("KC"), Card("9H"), Card("4S")))
    }
  }

  "Hand#cards" should {
    "returns [4S 8C 9H TS KC] if cards = [8C TS KC 9H 4S]" in {
      Hand("8C TS KC 9H 4S").cards must beEqualTo(List(Card("4S"), Card("8C"), Card("9H"), Card("TS"), Card("KC")))
    }
  }

  "Hand#rank" should {
    "returns HighCard if cards = [8C TS KC 9H 4S]" in {
      Hand("8C TS KC 9H 4S").rank must beEqualTo(Hand.HighCard)
    }

    "returns OnePair if cards = [5H KS 9C 7D 9H]" in {
      Hand("5H KS 9C 7D 9H").rank must beEqualTo(Hand.OnePair)
    }

    "returns TwoPairs if cards = [5C AD 5D AC 9C]" in {
      Hand("5C AD 5D AC 9C").rank must beEqualTo(Hand.TwoPairs)
    }

    "returns ThreeOfAKind if cards = [5C AD 5D 5S 9C]" in {
      Hand("5C AD 5D 5S 9C").rank must beEqualTo(Hand.ThreeOfAKind)
    }

    "returns Straight if cards = [5C 8D 6D 7S 9C]" in {
      Hand("5C 8D 6D 7S 9C").rank must beEqualTo(Hand.Straight)
    }

    "returns Flush if cards = [8C TC KC 9C 4C]" in {
      Hand("8C TC KC 9C 4C").rank must beEqualTo(Hand.Flush)
    }

    "returns FullHouse if cards = [5C AD 5D AC 5H]" in {
      Hand("5C AD 5D AC 5H").rank must beEqualTo(Hand.FullHouse)
    }

    "returns FourOfAKind if cards = [5C AD 5D 5S 5H]" in {
      Hand("5C AD 5D 5S 5H").rank must beEqualTo(Hand.FourOfAKind)
    }

    "returns StraightFlush if cards = [5D 8D 6D 7D 9D]" in {
      Hand("5D 8D 6D 7D 9D").rank must beEqualTo(Hand.StraightFlush)
    }

    "returns RoyalFlush if cards = [KH TH AH QH JH]" in {
      Hand("KH TH AH QH JH").rank must beEqualTo(Hand.RoyalFlush)
    }
  }

  "Hand#rankedCards" should {
    "returns [KC TS 9H 8C 4S] if cards = [8C TS KC 9H 4S]" in {
      Hand("8C TS KC 9H 4S").rankedCards must beEqualTo(List(Card("KC"), Card("TS"), Card("9H"), Card("8C"), Card("4S")))
    }

    "returns [9H 9C KS 7D 5H] if cards = [5H KS 9C 7D 9H]" in {
      Hand("5H KS 9C 7D 9H").rankedCards must beEqualTo(List(Card("9H"), Card("9C"), Card("KS"), Card("7D"), Card("5H")))
    }

    "returns [AC AD 5C 5D 9C] if cards = [5C AD 5D AC 9C]" in {
      Hand("5C AD 5D AC 9C").rankedCards must beEqualTo(List(Card("AC"), Card("AD"), Card("5C"), Card("5D"), Card("9C")))
    }

    "returns [5S 5C 5D AD 9C] if cards = [5C AD 5D 5S 9C]" in {
      Hand("5C AD 5D 5S 9C").rankedCards must beEqualTo(List(Card("5S"), Card("5C"), Card("5D"), Card("AD"), Card("9C")))
    }

    "returns [9C 8D 7S 6D 5C] if cards = [5C 8D 6D 7S 9C]" in {
      Hand("5C 8D 6D 7S 9C").rankedCards must beEqualTo(List(Card("9C"), Card("8D"), Card("7S"), Card("6D"), Card("5C")))
    }

    "returns [KC TC 9C 8C 4C] if cards = [8C TC KC 9C 4C]" in {
      Hand("8C TC KC 9C 4C").rankedCards must beEqualTo(List(Card("KC"), Card("TC"), Card("9C"), Card("8C"), Card("4C")))
    }

    "returns [5H 5C 5D AC AD] if cards = [5C AD 5D AC 5H]" in {
      Hand("5C AD 5D AC 5H").rankedCards must beEqualTo(List(Card("5H"), Card("5C"), Card("5D"), Card("AC"), Card("AD")))
    }

    "returns [5S 5H 5C 5D AD] if cards = [5C AD 5D 5S 5H]" in {
      Hand("5C AD 5D 5S 5H").rankedCards must beEqualTo(List(Card("5S"), Card("5H"), Card("5C"), Card("5D"), Card("AD")))
    }

    "returns [9D 8D 7D 6D 5D] if cards = [5D 8D 6D 7D 9D]" in {
      Hand("5D 8D 6D 7D 9D").rankedCards must beEqualTo(List(Card("9D"), Card("8D"), Card("7D"), Card("6D"), Card("5D")))
    }

    "returns [AH KH QH JH TH] if cards = [KH TH AH QH JH]" in {
      Hand("KH TH AH QH JH").rankedCards must beEqualTo(List(Card("AH"), Card("KH"), Card("QH"), Card("JH"), Card("TH")))
    }
  }

  "P054#solve" should {
    "returns 376" in {
      P054.solve must beEqualTo(376)
    }
  }
}
