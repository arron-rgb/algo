

object Smells {
  // indentation
  class Foo {
    def twospaces(): Unit = {
      val x = 2
    }
  }

  // line wrapping
  // semicolon 分号
  val result = 1 + 2 + 3 + 4 + 5 + 6 +
    7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 +
    15 + 16 + 17 + 18 + 19 + 20

  val format =
    foo(1,
      2,
      3,
      4)
  //  val wrongFormat = foo(1,
  //    2,
  //    3,
  //    4)

  def foo(a: Int, b: Int, c: Int, d: Int): Int = {
    a + b + c + d
  }

  // mimic 模拟 acronyms 首字母缩写词
  // class 大驼峰命名


  // 泛型
  //  class List[A] {
  //    def map[B](f: A => B): List[B] = ???
  //  }

  abstract class Map[Key, Value] {
    def get(key: Key): Value

    def put(key: Key, value: Value): Unit
  }

  var k = 0
  var n = 0
  var ways = 0
  var edges: List[List[Int]] = List()

  def numWays(n: Int, relation: Array[Array[Int]], k: Int): Int = {
    this.n = n
    this.k = k
    for (_ <- 0 until n) edges = edges :+ List()
    for (edge <- relation) {
      val src = edge(0)
      val dest = edge(1)
      var list = edges.apply(src)
      list ::= dest
      edges = edges.updated(src, list)
    }
    dfs(0, 0)
    ways
  }

  def dfs(index: Int, steps: Int): Unit = {
    if (steps == k) {
      if (index == n - 1) {
        ways += 1;
      }
      return
    }
    val list = edges.apply(index)
    for (n <- list) dfs(n, steps + 1)
  }

  for (i <- "10".toIntOption; j <- "42".toIntOption) yield i * j
  //  map and
  "10".toIntOption.flatMap(i =>
    "42".toIntOption.map(j =>
      i * j
    )
  )
  // flatMap
  //    "10".toIntOption.flatMap(i => i)

  def bigInts(x: BigInt): LazyList[BigInt] = x #:: bigInts(x + 1)

  def isPrime(x: BigInt): Boolean = (24 | (x * x - 1)) == 0

  bigInts(5).filter(isPrime).take(100).head
}
