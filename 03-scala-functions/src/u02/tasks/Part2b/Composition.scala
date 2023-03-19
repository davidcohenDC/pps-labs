package u02.tasks.Part2b

object Composition extends App {

  def compose[X](f:X => X, g: X => X): X => X = x => f(g(x))

  val comp: (Int => Int,Int => Int) => Int => Int = (f,g)=>x => f(g(x))
  
}
