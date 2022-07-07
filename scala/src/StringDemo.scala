import scala.language.postfixOps

object StringDemo {
  def main(args: Array[String]): Unit = {
    val str = "hello"
    str.map(_.toUpper)
    str.foreach(println)
    val upper = for (c <- str) yield c.toUpper
    println(upper)
    assert(upper == str.toUpperCase)
    str.filter(_ != '1').map(_.toUpper)

    assert(str(0) == 'h')

    println(str.increment)

    println(1.increment)

    var r = 1 to 10
    var r1 = 1 to 10 by 2
    r1 = 1 until 3

    val x = (1 to 10) toArray

    // pattern matching
    // guards

    val nieces = List("emily", "hanah")
    val value = for (n <- nieces) yield n.capitalize
    value.foreach(println)

    val a = Array("apple", "banana")
    //    for (e <- a) println(e)

    val strings = for (e <- a) yield {
      val s = e.toUpperCase
      s
    }
    strings.foreach(println)

    // guard sentence
    for (i <- 1 to 10 if i < 4) println(i)

    val names = Map("fname" -> "Robert", "lname" -> "Goren")
    for ((k, v) <- names) println(s"key: $k value: $v")
    // for如何被编译器解释
    // http://www.scala-lang.org/node/198
    // 1. 简单for: collection.foreach
    // 2. for with if(guard): collection.foreach withFilter
    // 3. for with yield: collection.map
    // 4. for with if & yield: collection.withFilter map
    for {
      i <- 0 to 1
      j <- 1 to 5
    } println(s"i $i, j $j")
    for {
      i <- 1 to 10 if i % 2 == 0
    } yield i
  }

  def toLower(c: Char): Char = (c.toByte + 32).toChar

  implicit class StringImprovements(s: String) {
    def increment: String = s.map(c => (c + 1).toChar)

    def plusOne: Int = s.toInt + 1

    def asBoolean: Boolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }

  }

  implicit class IntegerImprovements(num: Int) {
    def increment: Int = num + 1
  }


}
