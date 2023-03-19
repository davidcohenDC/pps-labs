package u02.tasks.Part3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import u02.tasks.Part3.Recursion.Fun.*
class RecursionTest {

  @Test
  def testGcd() = {
    assertEquals(4,gcd(12,8))
    assertEquals(7,gcd(14,7))
    assertEquals(4, gcdTail(12, 8))
    assertEquals(7, gcdTail(14, 7))
  }

}
