package u02.tasks.Part3

object Recursion extends App {

  object Fun:
    @annotation.tailrec
    def gcdTail(a: Int, b: Int): Int = b match
      case 0 => a
      case _ => gcdTail(b, a % b)

    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)
  

}
