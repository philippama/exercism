import scala.annotation.tailrec
import scala.collection.mutable

class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
    usingSimpleAccumulator(f, list)
//    usingTailRecursion(f, list, List[B]())
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
