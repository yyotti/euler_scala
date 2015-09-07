package project_euler

/**
 * Problem 37:
 * The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 *
 * 問題 37:
 * 3797は面白い性質を持っている.
 * まずそれ自身が素数であり, 左から右に桁を除いたときに全て素数になっている (3797, 797, 97, 7).
 * 同様に右から左に桁を除いたときも全て素数である (3797, 379, 37, 3).
 *
 * 右から切り詰めても左から切り詰めても素数になるような素数は11個しかない. 総和を求めよ.
 *
 * 注: 2, 3, 5, 7を切り詰め可能な素数とは考えない.
 */
object P037 {
  import commons._

  /**
   * 左から右に桁を除いたときに全て素数になっている数を「左切り詰め素数」、右から左に桁を除いたときに
   * 全て素数になっている数を「右切り詰め素数」と定義する。
   *
   * 下記の手順で全ての切り詰め素数が生成できる。
   * 1. 1桁の素数を列挙する。(psとする)
   * 2. LTS = ps, RTS = ps とする。
   * 3. LTSに含まれる数の左に1～9の数字をそれぞれ付加した数を生成し、そこから素数を抽出する。
   *    抽出した数をあらためてLTSとする。
   * 4. RTSに含まれる数の右に1～9の数字をそれぞれ付加した数を生成し、そこから素数を抽出する。
   *    抽出した数をあらためてRTSとする。
   * 5. LTS、RTSの少なくとも一方が空であれば、それまでに抽出された切り詰め素数が全てなので、処理を終了する。
   * 6. LTSとRTSの共通部分をとり、切り詰め素数列に追加する。手順3に戻り、さらに大きな切り詰め素数を生成する。
   */
  def solve: Long = {
    val basePrimes = primes.takeWhile { _ < 10 }
    createTruncatablePrimes(basePrimes, basePrimes).sum
  }

  def createTruncatablePrimes(lps: Seq[Long], rps: Seq[Long]): Seq[Long] = {
    val nextLps = lps.flatMap { p => (1 to 9).map { n => (n.toString + p).toLong } }.filter { n => isPrime(n) }
    val nextRps = rps.flatMap { p => (1 to 9).map { p * 10 + _ } }.filter { n => isPrime(n) }

    if (nextLps.isEmpty || nextRps.isEmpty) Seq.empty
    else nextLps.intersect(nextRps) ++ createTruncatablePrimes(nextLps, nextRps)
  }
}
