package quiz

import scala.annotation.tailrec

object Midterm {

  case class Point(a: Int, b: Int) {
    def move1: Point = Point(a + b, b)

    def move2: Point = Point(a, b + a)
  }

  object Point {
    def parse(u: String, w: String): Option[Point] = for (x <- u.toIntOption; y <- w.toIntOption) yield Point(x, y)
  }

  def isPossible(a: String, b: String, c: String, d: String): String = {
    def inRange(s: Point, t: Point): Boolean = s.a <= t.a && s.b <= t.b

    def reach(s: Point, t: Point): Boolean = s == t || (inRange(s, t) && (reach(s.move1, t) || reach(s.move2, t)))

    (for (s <- Point.parse(a, b); t <- Point.parse(c, d)) yield reach(s, t)) match {
      case None => "Invalid"
      case Some(true) => "Yes"
      case Some(false) => "No"
    }

  }

  def mySqrt(x: Int): Int = {
    def goodEnough(guess: Double, x: Double): Boolean =
      Math.abs(guess * guess - x) < 1e-3

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) * 0.5

    @tailrec
    def sqrtIter(guess: Double, x: Double): Double = {
      if (goodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    }

    var pair = ("Scala", 3)
    pair._2
    var (_, second) = pair

    sqrtIter(0.001, x).toInt
  }

  def isUgly(num: Int): Boolean = {
    //    if (num <= 0)
    //      return false
    //    num match {
    //      case 1 => true
    //      case num % 2 == 0 => isUgly(num / 2)
    //      case num % 3 == 0 => isUgly(num / 3)
    //      case num % 5 == 0 => isUgly(num / 5)
    //      case _ => false
    //    }
    //    false
    if (num <= 0) {
      return false
    }
    if (num == 1) {
      return true
    }
    List(2, 3, 5).exists(x => num % x == 0 && isUgly(num / x))

    //    //    if (num <= 0) false
    //    //    else if (num == 1) true
    //    //    else if (num % 2 == 0) isUgly(num / 2)
    //    //    else if (num % 3 == 0) isUgly(num / 3)
    //    //    else if (num % 5 == 0) isUgly(num / 5)
    //    //    else false
  }

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    p.value == q.value && isSameTree(q.left, p.left) && isSameTree(q.right, p.right)
  }

  def isSymmetric(root: TreeNode): Boolean = {
    if (root == null) true
    else isMirrored(root.left, root.right)
  }

  def isMirrored(tree1: TreeNode, tree2: TreeNode): Boolean =
    if (tree1 == null && tree2 == null) true
    else if (tree1 == null || tree2 == null) false
    else tree1.value == tree2.value && isMirrored(tree1.left, tree2.right) &&
      isMirrored(tree1.right, tree2.left)

  def findPermutation(s: String): Array[Int] = {
    @tailrec
    def doFind(s: List[Char], stack: List[Int], nums: List[Int], output: List[Int]): List[Int] =
      s match {
        case 'D' :: xs => doFind(xs, nums.head :: stack, nums.tail, output)
        case 'I' :: xs => doFind(xs, Nil, nums.tail, stack.reverse ++ List(nums.head) ++ output)
        case _ => stack.reverse ++ nums ++ output
      }

    doFind(s.toList, Nil, (1 to s.length + 1).toList, Nil).reverse.toArray
  }

  def f(ls: List[Int]): Int = ls.foldRight(0)((_, acc) => acc + 1)

}

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
