package project_euler

/**
 * Problem 84:
 * In the game, Monopoly, the standard board is set up in the following way:
 *
 * GO  A1  CC1 A2  T1  R1  B1  CH1 B2  B3  JAIL
 * H2                                      C1
 * T2                                      U1
 * H1                                      C2
 * CH3                                     C3
 * R4                                      R2
 * G3                                      D1
 * CC3                                     CC2
 * G2                                      D2
 * G1                                      D3
 * G2J F3  U2  F2  F1  R3  E3  E2  CH2 E1  FP
 *
 * A player starts on the GO square and adds the scores on two 6-sided dice to determine the number of squares they advance in a clockwise direction.
 * Without any further rules we would expect to visit each square with equal probability: 2.5%.
 * However, landing on G2J (Go To Jail), CC (community chest), and CH (chance) changes this distribution.
 *
 * In addition to G2J, and one card from each of CC and CH, that orders the player to go directly to jail, if a player rolls three consecutive doubles,
 * they do not advance the result of their 3rd roll. Instead they proceed directly to jail.
 *
 * At the beginning of the game, the CC and CH cards are shuffled. When a player lands on CC or CH they take a card from the top of the respective pile and,
 * after following the instructions, it is returned to the bottom of the pile.
 * There are sixteen cards in each pile, but for the purpose of this problem we are only concerned with cards that order a movement;
 * any instruction not concerned with movement will be ignored and the player will remain on the CC/CH square.
 *
 * ・Community Chest (2/16 cards):
 *     1. Advance to GO
 *     2. Go to JAIL
 * ・Chance (10/16 cards):
 *     1. Advance to GO
 *     2. Go to JAIL
 *     3. Go to C1
 *     4. Go to E3
 *     5. Go to H2
 *     6. Go to R1
 *     7. Go to next R (railway company)
 *     8. Go to next R
 *     9. Go to next U (utility company)
 *    10. Go back 3 squares.
 *
 * The heart of this problem concerns the likelihood of visiting a particular square.
 * That is, the probability of finishing at that square after a roll.
 * For this reason it should be clear that, with the exception of G2J for which the probability of finishing on it is zero,
 * the CH squares will have the lowest probabilities, as 5/8 request a movement to another square,
 * and it is the final square that the player finishes at on each roll that we are interested in.
 * We shall make no distinction between "Just Visiting" and being sent to JAIL, and we shall also ignore the rule about requiring a double to "get out of jail",
 * assuming that they pay to get out on their next turn.
 *
 * By starting at GO and numbering the squares sequentially from 00 to 39 we can concatenate these two-digit numbers to produce strings that correspond with sets of squares.
 *
 * Statistically it can be shown that the three most popular squares, in order, are JAIL (6.24%) = Square 10, E3 (3.18%) = Square 24,
 * and GO (3.09%) = Square 00. So these three most popular squares can be listed with the six-digit modal string: 102400.
 *
 * If, instead of using two 6-sided dice, two 4-sided dice are used, find the six-digit modal string.
 *
 * 問題 84:
 * モノポリーの標準的な盤面は以下である:
 *
 * GO  A1  CC1 A2  T1  R1  B1  CH1 B2  B3  JAIL
 * H2                                      C1
 * T2                                      U1
 * H1                                      C2
 * CH3                                     C3
 * R4                                      R2
 * G3                                      D1
 * CC3                                     CC2
 * G2                                      D2
 * G1                                      D3
 * G2J F3  U2  F2  F1  R3  E3  E2  CH2 E1  FP
 *
 * 各プレイヤーはGOのマスから開始し, 2個の6面サイコロを用いて時計回りに進む.
 * 他のルールが無いとすれば, 各マスに止まる確率は全て等しく, 2.5%である.
 * しかし, G2J (Go To Jail), CC (Community Chest, 共同基金), CH (Chance, チャンス) のマスによってこの確率は変えられてしまう.
 *
 * G2Jに止まる, または, CCやCHのマスに止まると引くカードのうちそれぞれ1枚によって, プレイヤーはJAILのマスに飛ばされる.
 * またプレイヤーが連続して3回ゾロ目を出すと, 3投目の結果のマスに進むのではなく, 直接JAILのマスに飛ばされる.
 * (訳注: モノポリーではゾロ目が出るともう1回サイコロをふる. 6,6→2,1の場合は合計15マス進む. 4,4→2,2→1,2の場合は合計15マス進む.
 *        3,3→4,4→2,2の場合は6マス目, 14マス目に止まったのちJAILに飛ばされる.)
 *
 * ゲーム開始前にCCカードとCHカードはシャッフルされる.
 * プレイヤーがCCまたはCHマスに止まった場合, プレイヤーはCCカードまたはCHカードの山の一番上からカードを1枚引く.
 * カードの指示に従ったのち, そのカードは山の一番下に戻される.
 * それぞれのカードは16枚あるが, 今回は問題を進み方に限定するので, 移動の指示があるカードのみを考える.
 * 移動の指示が無いカードに関しては何もせずカードをそのまま山の下に戻す. プレイヤーはそのままCC/CHマスに残るものとする.
 *
 * ・Community Chest (16枚中2枚が移動カード)
 *     1. GOへ進め
 *     2. JAILへ進め
 * ・Chance (16枚中10枚が移動カード)
 *     1. GOへ進め
 *     2. JAILへ進め
 *     3. C1へ進め
 *     4. E3へ進め
 *     5. H2へ進め
 *     6. R1へ進め
 *     7. 次のRへ進め (Rはrailway company, 鉄道会社の意)
 *     8. 次のRへ進め
 *     9. 次のUへ進め (Uはutility company, 公共事業会社の意)
 *    10. 3マス戻れ
 *
 * 今回考えるのは, どのマスに止まりやすいかである. 即ち, サイコロを投げた後に止まる確率である.
 * より正確には, サイコロを1回振ってカードやマスによる移動を終えた後に各マスに止まる確率を求めたい.
 * 従って, G2Jに止まる確率は0であり, CHマスに止まる確率はその次に少ない(16枚中10枚が移動カードなので).
 * またJAILマスにたまたま止まることとJAILマスに送られることを区別しない.
 * またJAILマスから抜けるルール (自分のターンにゾロ目を2回出す) を無視する. つまり必ず保釈金を払ってJAILマスから進むものとする.
 *
 * GOマスを00とし番号を00-39と順番に振る. これにより各マスを2桁の数で表すことが出来る.
 *
 * 統計的には, 3つのマスに止まりやすいことを示せる. JAIL (6.24%) = 10番目, E3 (3.18%) = 24番目, GO (3.09%) = 00番目である.
 * 従ってもっとも止まりやすいマスを6桁で表せて102400となる.
 *
 * 2つの6面サイコロではなくて, 2つの4面サイコロを用いた場合の, もっとも止まりやすいマスを6桁で表せ.
 *
 * （翻訳ヒント、サイコロを振りぞろ目だろうがでなかろうが止まったマス目の指示に従う。カードマスならカードを引く。
 *   これを繰り返す。繰り返す途中で三連続でぞろ目が出たら強制的に刑務所行き）
 */
object P084 {
  def solve(n: Int): String = ???
}
