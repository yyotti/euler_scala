package project_euler

/**
 * Problem 54:
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
 *
 * High Card: Highest value card.
 * One Pair: Two cards of the same value.
 * Two Pairs: Two different pairs.
 * Three of a Kind: Three cards of the same value.
 * Straight: All cards are consecutive values.
 * Flush: All cards of the same suit.
 * Full House: Three of a kind and a pair.
 * Four of a Kind: Four cards of the same value.
 * Straight Flush: All cards are consecutive values of same suit.
 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 *
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 *
 * If two players have the same ranked hands then the rank made up of the highest value wins;
 * for example, a pair of eights beats a pair of fives (see example 1 below).
 * But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below);
 * if the highest cards tie then the next highest cards are compared, and so on.
 *
 * Consider the following five hands dealt to two players:
 *
 * Hand|Player 1|Player 2|Winner
 * 1|5H 5C 6S 7S KD|2C 3S 8S 8D TD|Player 2
 *  |Pair of Fives|Pair of Eights|
 * 2|5D 8C 9S JS AC|2C 5C 7D 8S QH|Player 1
 *  |Highest card Ace|Highest card Queen|
 * 3|2D 9C AS AH AC|3D 6D 7D TD QD|Player 2
 *  |Three Aces|Flush with Diamonds|
 * 4|4D 6S 9H QH QC|3D 6D 7H QD QS|Player 1
 *  |Pair of Queens|Pair of Queens|
 *  |Highest card Nine|Highest card Seven|
 * 5|2H 2D 4C 4D 4S|3C 3D 3S 9S 9D|Player 1
 *  |Full House|Full House|
 *  |With Three Fours|with Three Threes|
 *
 * The file, poker.txt, contains one-thousand random hands dealt to two players.
 * Each line of the file contains ten cards (separated by a single space):
 * the first five are Player 1's cards and the last five are Player 2's cards.
 * You can assume that all hands are valid (no invalid characters or repeated cards),
 * each player's hand is in no specific order, and in each hand there is a clear winner.
 *
 * How many hands does Player 1 win?
 *
 * 問題 54:
 * カードゲームのポーカーでは, 手札は5枚のカードからなりランク付けされている. 役を低い方から高い方へ順に並べると以下である.
 *
 * 役無し(ハイカード): 一番値が大きいカード
 * ワン・ペア: 同じ値のカードが2枚
 * ツー・ペア: 2つの異なる値のペア
 * スリーカード: 同じ値のカードが3枚
 * ストレート: 5枚の連続する値のカード
 * フラッシュ: 全てのカードが同じスート (注: スートとはダイヤ・ハート・クラブ/スペードというカードの絵柄のこと)
 * フルハウス: スリーカードとペア
 * フォーカード: 同じ値のカードが4枚
 * ストレートフラッシュ: ストレートかつフラッシュ
 * ロイヤルフラッシュ: 同じスートの10, J, Q, K, A
 * ここでカードの値は小さい方から2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, Aである. (訳注：データ中で10は'T'と表される)
 *
 * もし2人のプレイヤーが同じ役の場合には, 役を構成する中で値が最も大きいカードによってランクが決まる: 例えば, 8のペアは5のペアより強い (下の例1を見よ). それでも同じランクの場合には (例えば, 両者ともQのペアの場合), 一番値が大きいカードによってランクが決まる (下の例4を見よ). 一番値が大きいカードが同じ場合には, 次に値が大きいカードが比べれられ, 以下同様にランクを決定する.
 *
 * 例:
 *
 * 試合|プレイヤー1|プレイヤー2|勝者
 * 1|5H 5C 6S 7S KD|2C 3S 8S 8D TD|プレイヤー2
 *  |5のペア|8のペア|
 * 2|5D 8C 9S JS AC|2C 5C 7D 8S QH|プレイヤー1
 *  |役無し, A|役無し, Q|
 * 3|2D 9C AS AH AC|3D 6D 7D TD QD|プレイヤー2
 *  |Aのスリーカード|ダイヤのフラッシュ|
 * 4|4D 6S 9H QH QC|3D 6D 7H QD QS|プレイヤー1
 *  |Qのペア, 9|Qのペア, 7|
 * 5|2H 2D 4C 4D 4S|3C 3D 3S 9S 9D|プレイヤー1
 *  |4-2のフルハウス|3-9のフルハウス|
 *
 * poker.txtには1000個のランダムな手札の組が含まれている. 各行は10枚のカードからなる (スペースで区切られている):
 * 最初の5枚がプレイヤー1の手札であり, 残りの5枚がプレイヤー2の手札である. 以下のことを仮定してよい
 *
 * 全ての手札は正しい (使われない文字が出現しない. 同じカードは繰り返されない)
 * 各プレイヤーの手札は特に決まった順に並んでいるわけではない
 * 各勝負で勝敗は必ず決まる
 * 1000回中プレイヤー1が勝つのは何回か? (訳注 : この問題に置いてA 2 3 4 5というストレートは考えなくてもよい)
 */
object P054 {
  import commons._

  case class Card(suit: Int, number: Int) extends Ordered[Card] {
    def compare(that: Card): Int = if (number == that.number) suit - that.suit else number - that.number
  }
  object Card {
    import math.Ordered._

    def apply(value: String): Card = {
      val number = value(0) match {
        case 'T' => 10
        case 'J' => 11
        case 'Q' => 12
        case 'K' => 13
        case 'A' => 14
        case c => c.asDigit
      }
      val suit = value(1) match {
        case 'D' => 0
        case 'C' => 1
        case 'H' => 2
        case 'S' => 3
      }

      Card(suit, number)
    }
  }

  case class Hand(c1: Card, c2: Card, c3: Card, c4: Card, c5: Card) extends Ordered[Hand] {
    import math.Ordered._

    val cards = List(c1, c2, c3, c4, c5).sorted

    val rank =
      if (cards.tail.forall { _.suit == cards.head.suit }) {
        // フラッシュ系
        if (cards.map { _.number }.sliding(2).forall { ls => ls(0) + 1 == ls(1) }) {
          // ストレートフラッシュ系
          if (cards.head.number == 10) Hand.RoyalFlush
          else Hand.StraightFlush
        } else {
          // フラッシュ
          Hand.Flush
        }
      } else {
        val groups = cards.groupBy { _.number }
        if (groups.size == 5) {
          // ストレート系
          if (cards.map { _.number }.sliding(2).forall { ls => ls(0) + 1 == ls(1) }) Hand.Straight
          else Hand.HighCard
        } else if (groups.size == 2) {
          // フォーカード or フルハウス
          if (groups.exists { case (_, ls) => ls.size == 4 }) Hand.FourOfAKind
          else Hand.FullHouse
        } else if (groups.size == 3) {
          // ツーペア or スリーカード
          if (groups.exists { case (_, ls) => ls.size == 3 }) Hand.ThreeOfAKind
          else Hand.TwoPairs
        } else {
          // ワンペア
          Hand.OnePair
        }
      }

    val rankedCards = rank match {
      case Hand.HighCard | Hand.Straight | Hand.Flush | Hand.StraightFlush | Hand.RoyalFlush => // 全てのカードの数字が異なる
        cards.reverse
      case Hand.FullHouse | Hand.FourOfAKind => // 枚数が多いカードの大小で決められる
        cards.groupBy { _.number }.toList.sortBy { case (_, ls) => ls.size }.reverse.map { case (_, ls) => ls.sorted.reverse }.flatten
      case _ =>
        val (ls1, ls2) = cards.groupBy { _.number }.toList.partition { case (_, ls) => ls.size > 1 }
        ls1.flatMap { _._2 }.sorted.reverse ::: ls2.flatMap { _._2 }.sorted.reverse
    }

    def compare(that: Hand) =
      if (rank != that.rank) rank - that.rank
      else rankedCards.zip(that.rankedCards).dropWhile { case (c1, c2) => c1.number == c2.number } match {
        case Nil => 0
        case (c1, c2) :: _ => c1.number - c2.number
      }
  }
  object Hand {
    def apply(values: String): Hand = {
      val cards = values.split(" ").map { v => Card(v) }
      Hand(cards(0), cards(1), cards(2), cards(3), cards(4))
    }

    val HighCard = 0
    val OnePair = 1
    val TwoPairs = 2
    val ThreeOfAKind = 3
    val Straight = 4
    val Flush = 5
    val FullHouse = 6
    val FourOfAKind = 7
    val StraightFlush = 8
    val RoyalFlush = 9
  }

  def solve: Long =
    withSource(io.Source.fromFile("src/main/resources/p054_poker.txt")) { src => src.getLines.toList }
      .map { s => val cs = s.split(" ").map { Card(_) }; (Hand(cs(0), cs(1), cs(2), cs(3), cs(4)), Hand(cs(5), cs(6), cs(7), cs(8), cs(9))) }
      .count { case (h1, h2) => h1 > h2 }
}
