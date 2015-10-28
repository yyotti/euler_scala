package project_euler

/**
 * Problem 101:
 * If we are presented with the first k terms of a sequence it is impossible to say with certainty the value of the next term,
 * as there are infinitely many polynomial functions that can model the sequence.
 *
 * As an example, let us consider the sequence of cube numbers. This is defined by the generating function,
 * un = n^3: 1, 8, 27, 64, 125, 216, ...
 *
 * Suppose we were only given the first two terms of this sequence.
 * Working on the principle that "simple is best" we should assume a linear relationship and predict the next term to be 15 (common difference 7).
 * Even if we were presented with the first three terms, by the same principle of simplicity, a quadratic relationship should be assumed.
 *
 * We shall define OP(k, n) to be the nth term of the optimum polynomial generating function for the first k terms of a sequence.
 * It should be clear that OP(k, n) will accurately generate the terms of the sequence for n ≤ k,
 * and potentially the first incorrect term (FIT) will be OP(k, k+1); in which case we shall call it a bad OP (BOP).
 *
 * As a basis, if we were only given the first term of sequence, it would be most sensible to assume constancy;
 * that is, for n ≥ 2, OP(1, n) = u1.
 *
 * Hence we obtain the following OPs for the cubic sequence:
 *
 * OP(1, n) = 1              1, 1, 1, 1, ...
 * OP(2, n) = 7n−6           1, 8, 15, ...
 * OP(3, n) = 6n^2−11n+6     1, 8, 27, 58, ...
 * OP(4, n) = n^3            1, 8, 27, 64, 125, ...
 *
 * Clearly no BOPs exist for k ≥ 4.
 *
 * By considering the sum of FITs generated by the BOPs (indicated in red above), we obtain 1 + 15 + 58 = 74.
 *
 * Consider the following tenth degree polynomial generating function:
 *
 * un = 1 − n + n^2 − n^3 + n^4 − n^5 + n^6 − n^7 + n^8 − n^9 + n^10
 *
 * Find the sum of FITs for the BOPs.
 *
 * 問題 101:
 * 数列のk個の項を与えられたときに, 次の項を確実に求めることは不可能である.
 * その数列に合うような多項式が無限個存在するからである.
 *
 * 例として, 立方数の数列を考えよう. これは生成関数 un = n^3 で定義され, 1, 8, 27, 64, 125, 216, ...となる.
 *
 * この数列の最初の2項のみが与えられているとしよう.
 * "Simple is best"の法則にのっとり, 線形の関係があると仮定し, 3つ目の項が15であると予想する (差分が7).
 * もし最初の3項のみが与えられていたとしても, 同じ原則により, 二次の関係があると仮定して次の項を予測する.
 *
 * 数列の最初のk項を生成できる最適な多項式のn項を OP(k, n) で表すことにする.
 * 明らかに, n ≤ k について OP(k, n) は正しい.
 * 最初の異なる項 (First Incorrect Term, FIT) は OP(k, k+1) であろう. これを bad OP (BOP) と呼ぶことにする.
 *
 * 原則より, 最初の項しか与えられていない場合には, 定数項とするのが理に適っているだろう;
 * 即ち, n ≥ 2, OP(1, n) = u1.
 *
 * 従って, 立方数の数列について以下のOPを得る.
 *
 * OP(1, n) = 1             1, 1, 1, 1, ...
 * OP(2, n) = 7n−6          1, 8, 15, ...
 * OP(3, n) = 6n^2−11n+6    1, 8, 27, 58, ...
 * OP(4, n) = n^3           1, 8, 27, 64, 125, ...
 *
 * 明らかに, k ≥ 4 のときにはBOPは存在しない.
 *
 * BOPのFIT (上の例では赤で示されている) の和は, 1 + 15 + 58 = 74 である.
 *
 * 以下の10次多項式からなる生成関数を考える:
 *
 * un = 1 − n + n^2 − n^3 + n^4 − n^5 + n^6 − n^7 + n^8 − n^9 + n^10
 *
 * BOPのFITの総和を求めよ.
 */
object P101 {

  val u = Stream.from(1).map { n => (1 - math.pow(-n, 11).toLong) / (1 + n) }

  def op(k: Int, n: Int) =
    (0 until k)
      .zip(coefficients(k))
      .map { case (i, a) => a * math.pow(n, i).toLong }
      .sum

  def coefficients(k: Int): List[Long] = {
    val coefMatrix =
      (1 to k)
        .map { n => (0 until k).map { i => math.pow(n, i).toLong }.toList }
        .toList

    gaussJordanElimination(coefMatrix, u.take(k).toList)._2
  }

  def gaussJordanElimination(a: List[List[Long]], b: List[Long]): (List[List[Long]], List[Long]) = {
    def loop(a: List[List[Long]], b: List[Long], i: Int): (List[List[Long]], List[Long]) =
      if (i == a.size) (a, b)
      else if (a(i)(i) != 1) {
        val x = a(i)(i)
        loop(a.updated(i, a(i).map { _ / x }), b.updated(i, b(i) / x), i)
      } else {
        val ls = a(i)
        val (newA, newB) =
          (0 until a.size)
            .filter { j => j != i }
            .foldLeft((a, b)) { case ((a, b), j) =>
              val s = a(j)(i)
              (a.updated(j, a(j).zip(ls).map { case (aj, ai) => aj - ai * s }), b.updated(j, b(j) - b(i) * s))
            }

        loop(newA, newB, i + 1)
      }

    loop(a, b, 0)
  }

  def fit(k: Int) = {
    val f = op(k, _: Int)
    u
      .zipWithIndex
      .map { case (un, i) => (un, f(i + 1)) }
      .find { case (un, t) => un != t }
      .map { _._2 }
      .get
  }

  /**
   * OP(k, n)は下記のように記述できる。
   *   OP(k, n) = Σ(i = 0 → k - 1) { a(i)n^i }  (a(i)は実数)
   *
   * OP(k, n)の係数列 a(n) を考える。
   * k = 1のとき
   *   OP(1, n) = Σ(i = 0 → 0) { a(i)n^i } = a(0)
   * k = 2のとき
   *   OP(2, n) = Σ(i = 0 → 1) { a(i)n^i } = a(0) + a(1)n
   * k = 3のとき
   *   OP(3, n) = Σ(i = 0 → 2) { a(i)n^i } = a(0) + a(1)n + a(2)n^2
   * と続いていく。
   * あるkについて、1 &le; n &le; k の全ての場合を列挙するとk元一次連立方程式となり、係数列 a(n) の
   * 全ての項を特定することができる。
   *
   * a(n) を特定できればOP(k, n)の値を計算できるようになるので、BOPのFITを列挙して総和をとればよい。
   *
   * 連立方程式は行列式で解くことができる。
   * 方法としては、逆行列を用いる正攻法やクラメルの定理などあるようだが、今回は対象とする連立方程式
   * の性質上、ガウス-ジョルダンの消去法を採用する。
   *
   * u(n)自体は、初項が1、公比が-nの等比数列の第11項までの和なので、
   *   u(n) = (1 - (-n)^10)/(1 + n)
   * で求められる。
   */
  def solve(n: Int): Long = (1 to n).map { k => fit(k) }.sum
}