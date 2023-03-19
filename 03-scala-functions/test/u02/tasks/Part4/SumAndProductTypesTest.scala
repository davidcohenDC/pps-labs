package u02.tasks.Part4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import u02.tasks.Part4.SumAndProductTypes.*
import u02.tasks.Part4.SumAndProductTypes.Module.*
class SumAndProductTypesTest {

  private val circle = Shape.Circle(3.0)
  private val rectangle = Shape.Rectangle(2.0, 5.0)
  private val square = Shape.Square(2.0)

  private val pointA = Point2D(0.0, 3.0)
  private val pointB = Point2D(1.0, 5.0)
  private val pointC = Point2D(1.0, 2.0)

  @Test def testPerimeter() = {
    assertEquals(18.84955592153876, perimeter(circle))
    assertEquals(14.0, perimeter(rectangle))
    assertEquals(4.0, perimeter(square))
  }

  @Test def testContains() = {
    assertTrue(contains(circle, pointA))
    assertFalse(contains(circle, pointB))
    assertTrue(contains(circle, pointC))
    assertTrue(contains(rectangle, pointA))
    assertTrue(contains(rectangle, pointB))
    assertTrue(contains(rectangle, pointC))
    assertFalse(contains(square, pointA))
    assertFalse(contains(square, pointB))
    assertTrue(contains(square, pointC))
  }

}
