package u02.tasks.Part4

import u02.tasks.Part4.SumAndProductTypes.Shape.Square

object SumAndProductTypes extends App{

  enum Shape:
    case Circle(radius: Double)
    case Rectangle(width: Double, height: Double)
    case Square(side: Double)

  case class Point2D(x: Double, y: Double)
  object Module:
    def perimeter(shape: Shape): Double = shape match
      case Shape.Circle(radius) => 2 * Math.PI * radius
      case Shape.Rectangle(width, height) => 2 * (width + height)
      case Shape.Square(side) => side * side


    def contains(shape: Shape, point: Point2D): Boolean = shape match
      case Shape.Circle(radius) => Math.sqrt(point.x * point.x + point.y * point.y) <= radius
      case Shape.Rectangle(width, height) => point.x >= 0 && point.x <= width && point.y >= 0 && point.y <= height
      case Shape.Square(side) => point.x >= 0 && point.x <= side && point.y >= 0 && point.y <= side

}
