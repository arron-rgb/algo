import scala.language.implicitConversions

object ImplicitDemo {

  def main(args: Array[String]): Unit = {
    //    StringOps
    List(1, 3, 2).sortWith(_ < _)
  }

  def add(x: Int, y: Int)(implicit z: Int): Int = x + y + z

  implicit def stringToInt(x: String) = x.toInt

  implicit val z: Int = 4
  add("1", "2")
  //  "1".stringtoInt()
  val r = add("1", "2")

  implicit class Rep(n: String) {
    def stringToInt(): Int = {
      println(n)
      n.toInt
    }
  }

}


// rm -f coursier
