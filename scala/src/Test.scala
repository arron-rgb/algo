package src

object Test extends App {

  private val option: Option[BigInt] = bigInts(5).filter(x => (x * x - 1) % 24 == 0).drop(99).headOption

  def isPrime(x: BigInt): Boolean = ???

  def bigInts(x: BigInt): LazyList[BigInt] = x #:: bigInts(x + 1)


}
