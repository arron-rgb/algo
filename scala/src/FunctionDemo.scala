object FunctionDemo {

  class Flight(x: Int) {
    def apply(n: Int) = n + 1
  }


  // normal
  // def add(x:Int, y:Int) = x+y
  // currying
  //  val add: (Int, Int) => Int = (x, y) => x + y
  def add(x: Int)(y: Int) = x + y

  def apply(n: Int) = n + 1

  def main(args: Array[String]): Unit = {
    add(1)(2)
    this.apply(1)
    apply(1)
    //    import FunctionDemo.apply
    //    (1)
    val x = List.range(1, 10)
    val evens = x.filter(i => i % 2 == 0)
    val odds = x.filter(_ % 2 == 1)

    odds.foreach((i: Int) => print(i + " "))
    odds.foreach((i) => print(i + " "))
    odds.foreach(i => print(i + " "))
    odds.foreach(print(_))
    odds.foreach(print)


    val double = (i: Int) => {
      i * 2
    }

    println(double(2))
    val list = List.range(1, 5)
    println(list.map(double))

    //    val f: (Int) => Boolean = i => {i%2 == 0}
    //    val f: Int => Boolean = i => {i%2 == 0}
    //    val f: Int => Boolean = i=> i%2 == 0
    val f: Int => Boolean = _ % 2 == 0


    list.filter(modMethod)

    // partially applied function
    //    val c = scala.math.cos _
    val c = scala.math.cos _
    val p = scala.math.pow _
    //    val p = scala.math.pow(_, _)

    val plusOne = (i: Int) => {
      println(i + 1)
    }
    execute(plusOne)

    execute((i: Int) => {
      println(i + 10)
    })

    execute(println)
  }


  def execute(callback: Int => Unit): Unit = {
    callback(1)
  }

  // 函数作为参数的语法
  // functionName: (parameterType(s)) => returnType

  def modMethod(i: Int) = i % 2 == 0

  def test(x: Int)(y: Int): Int = {
    x + y
  }


  object demo {
    val words = Seq("a", "sequence", "of", "words")
    words
      .view
      .map(_.length)
      .filter(_ > 3)
      .toSeq
      .distinct
      .headOption
      .getOrElse(0)
  }
}
