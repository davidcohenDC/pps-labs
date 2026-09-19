package u02.tasks.Part2b

import org.junit.jupiter.api.Test;
import u02.tasks.Part2b.Composition.*
import org.junit.jupiter.api.Assertions.*
class CompositionTest {

  @Test
  def testComposition() = {
    assertEquals(9, compose[Int](_ - 1, _ * 2)(5));
    assertEquals(8, comp(_ * 2, _ - 1)(5));
    assertEquals(11, compose[Int](_ + 1, _ * 2)(5));
    assertEquals(11, comp(_ + 1, _ * 2)(5));
  }
}
