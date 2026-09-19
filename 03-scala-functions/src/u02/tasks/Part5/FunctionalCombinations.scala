package u02.tasks.Part5

object FunctionalCombinations extends App:

  enum Option[A]:
    case Of(a: A)
    case None()

  object Option:

    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false

    def orErse[A, B >: A](opt: Option[A], orErse: B): B = opt match
      case Of(a) => a
      case _ => orErse

    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Of(a) => f(a)
      case _ => None()

    def filter[A](opt: Option[A])(f: A => Boolean): Option[A] = opt match
      case Of(a) if f(a) => Of(a)
      case _ => None()
    
    def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt match
      case Of(a) => Of(f(a))
      case _ => None()

    def fold[A, B](opt: Option[A])(default: B)(f: A => B): B = opt match
      case Of(a) => f(a)
      case _ => default





