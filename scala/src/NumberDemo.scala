
import scala.Console.println
import scala.language.postfixOps


object NumberDemo {

  def main(args: Array[String]): Unit = {
    // 所有数值均为对象
    // Byte Char Double Float Int Long Short
    // 继承扩展自AnyVal
    //
    // 日期类型
    //    println(DateTime.now)
    //    println((2.hours + 45.minutes + 10.seconds).millis)

    // String toInt
    "100".toInt
    try {
      "a".toInt
    } catch {
      case _: NumberFormatException => println("error")
    }

    val bigInt = BigInt(1)

    // 没有必要在scala方法上声明可能抛出异常
    @throws(classOf[NumberFormatException])
    def myToInt(s: String) = s.toInt

    def formalToInt(s: String): Option[Int] = {
      try {
        Some(s.toInt)
      } catch {
        case e: NumberFormatException => None
      }
    }

    println(formalToInt("1").getOrElse(0))
    val res = formalToInt("s") match {
      case Some(x) => x
      case None => 0
    }
    // 声明格式
    // val [name]:[Type] = [initial value]

    // scala把基本操作符实现为方法
    // scala的模式
    val x = 1
    //    x += 1 // error

    val a = 0.3
    val b = 0.1 + 0.2

    println(MathUtils.~=(a, b, 1.0E-4))
    println(a ~= b)
    // 生成随机数

    val r = scala.util.Random
    // 设定随机数范围
    r.nextInt(100)
    r.nextFloat()
    r.nextDouble()
    (0 to r.nextInt(10)).foreach(println)
    for (i <- 0 to r.nextInt(10)) yield i * 2


    (1 to 10 by 2).foreach(x => {
      print(x)
      print(" ")
    })

    1 to 10 toArray
  }

  implicit class Number(x: Double) {

    def ~=(y: Double): Boolean = {
      if ((x - y).abs < 1E-4) true else false
    }
  }

  object MathUtils {
    def ~=(x: Double, y: Double, precision: Double): Boolean = {
      if ((x - y).abs < precision) true else false
    }
  }


}
