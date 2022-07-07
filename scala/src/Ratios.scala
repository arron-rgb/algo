package src

import scala.util.Try


object Ratios extends App {

  def log(x: Double) = if (x > 0) Math.log(x) else throw new Exception("x must be positive")

  def tryLog(x: Double) = Try(log(x))

  val result = tryLog(-1)
  result foreach (x => println(s"log value is $x"))
  tryLog(math.E) foreach (x => println(s"log value is $x"))

}
