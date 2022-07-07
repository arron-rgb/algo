package quiz

import scala.util.Random

object Quiz1 {

  private val option: Option[BigInt] = bigInts(5).filter(isPrime).headOption

  def isPrime(x: BigInt): Boolean = (24 | (x * x - 1)) == 0

  def bigInts(x: BigInt): LazyList[BigInt] = x #:: bigInts(x + 1)

  def next(p: BigInt): Option[BigInt] = {
    val ys: LazyList[BigInt] = bigInts(p + 1).filter({ x =>
      val r = x % 10;
      x == 2 || x == 5 | r == 1 || r == 3 || r == 7 || r == 9
    })
    val xs = ys.filter(_.isProbablePrime(40))
    xs.headOption
  }

  def optionalPrimes(x: BigInt): Option[(BigInt, BigInt)] = for (a <- next(x); b <- next(a)) yield a -> b

  //  (1) Option is a trait which allows for zero or one elements of the underlying type.
  //  Which of the following method types is not a method of Option[X]?
  //  length: Int
  //  (2) Which of the following statements about a lazy list are true?
  //  (T) An instance of LazyList does not always have a definite length.
  //  (T) The apply method of LazyList is defined such that the tail is call-by-name.
  //  (F) You cannot invoke the filter method on a LazyList.
  //  (T) A LazyList can be declared to contain an infinite number of elements, but if you try to evaluate all of them at run-time, you will get an exception (such as OutOfMemory).
}


case class Quiz2(random: Random) {
  //  val convert: (Double, Double) => Complex = boxMuller // TODO using boxMuller
  //  val randomUniform: LazyList[Double] = LazyList.continually(random.nextDouble())
  //  val randomPairs: LazyList[(Double, Double)] = LazyList.continually((randomUniform.head, randomUniform.head)) // TODO using randomUniform, grouped into pairs.
  //  val randomComplex: LazyList[Complex] = for ((x, y) <- randomPairs) yield convert(x, y) // TODO using randomPairs and convert function
}
