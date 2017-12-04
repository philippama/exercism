import scala.annotation.tailrec
import scala.collection.mutable

class Accumulate {
  // Trying two different ways
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
//    usingSimpleAccumulator(f, list)
//    usingTailRecursion(f, list, List[B]())
    other(f, list)
  }

  def other[A, B](f: (A) => B, list : List[A]): List[B] = {
    for(a <- list) yield f(a)
  }

  def other1[A, B](f: (A) => B, list : List[A]): List[B] = {
    list match {
      case List() => List()
      case head::tail => f(head) :: accumulate(f, tail)
    }
  }

  def usingSimpleAccumulator[A, B](f: (A) => B, list : List[A]): List[B] = {
    val accumulator: mutable.ArrayBuffer[B] = mutable.ArrayBuffer()
    list.foreach(accumulator += f(_))
    accumulator.toList
  }

  @tailrec
  final def usingTailRecursion[A, B](f: (A) => B, sourceList : List[A], destList : List[B]): List[B] = {
    if (sourceList.isEmpty) {
       destList
    }
    else usingTailRecursion(f, sourceList.tail, destList :+ f(sourceList.head))
  }
}
