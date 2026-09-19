package u02.tasks.Part2a

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import u02.tasks.Part2a.FunSignAndNeg.Functions.*

class NegTest {

  val empty: String => Boolean = _ == ""

  @Test
  def testSign() = {
    assertEquals("true", sign(1))
    assertEquals("false", sign(-1))
    assertEquals("false", sign(0))
    assertEquals("true", funSign(1))
    assertEquals("false", funSign(-1))
    assertEquals("false", funSign(0))
  }

  @Test
  def testNeg() = {
    val notEmpty: String => Boolean = neg(empty)
    assertTrue(notEmpty("a"))
    assertFalse(notEmpty(""))
  }

}
