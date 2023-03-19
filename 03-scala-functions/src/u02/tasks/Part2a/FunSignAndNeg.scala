package u02.tasks.Part2a

object FunSignAndNeg extends App {
  
  object Functions:
  
    val sign: Int => String = x => x match
      case x if x > 0 => "true"
      case _ => "false"
  
    def funSign(x: Int): String = x match
      case x if x > 0 => "true"
      case _ => "false"
    
    def neg[A](p1: A => Boolean): A => Boolean = !p1(_)
  
}


