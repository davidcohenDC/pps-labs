package u02.tasks.Part2b

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import u02.tasks.Part2b.Currying.Fun.*

class CurryingTest {

 @Test
  def testCurrying(): Unit = {
     assertTrue(p1(2)(3)(3))
     assertTrue(p2(2,3,3))
     assertTrue(p3(2)(3)(3))
     assertTrue(p4(2,3,3))
     assertFalse(p1(2)(3)(4))
     assertFalse(p2(2,2,3))
     assertFalse(p3(3)(2)(2))
     assertFalse(p4(2,3,0))
 }


}
