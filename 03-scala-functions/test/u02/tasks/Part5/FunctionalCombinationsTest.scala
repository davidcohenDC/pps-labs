package u02.tasks.Part5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import u02.tasks.Part5.FunctionalCombinations.*
import u02.tasks.Part5.FunctionalCombinations.Option.*
class FunctionalCombinationsTest {

  val s1: Option[Int] = Option.Of(1)
  val s2: Option[Int] = Option.Of(2)
  val s3: Option[Int] = Option.None()

  @Test def testOptional() = {
    assertEquals(Option.Of(2), s2)
    assertEquals(Option.None(),s3)
    assertEquals(Option.Of(1),s1)
  }

  @Test def testOrElse() = {
    assertEquals(1, orErse(s1,0))
    assertEquals(0, orErse(s3,0))
  }

  @Test def testFlatMap() = {
    assertEquals(Option.Of(2), flatMap(s1)(i => Option.Of(i + 1)))
    assertEquals(Option.None(), flatMap(s1)(i => flatMap(s3)(j => Option.Of(i + j))))
  }

  @Test def testFilter() = {
    assertEquals(Option.Of(5),filter(Option.Of(5))(_ > 2))
    assertEquals(Option.None(),filter(Option.Of(5))(_ > 8))
    assertEquals(Option.None(),filter(Option.None[Int]())(_ > 2))
  }

  @Test def testMap() = {
    assertEquals(Option.Of(true),map(Option.Of(5))(_ > 2)) //Of(true)
    assertEquals(Option.Of(false),map(Option.Of(5))(_ > 8)) //None
    assertEquals(Option.None(),map(Option.None[Int]())(_ > 2)) //None
  }

  @Test def testFold()= {
    assertEquals(6,fold(Of(5))(1)(_ + 1)) //1
    assertEquals(1,fold(None[Int]())(1)(_ + 1)) //6
  }

}
