import scala.collection.mutable

class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] = {
    val accumulator: mutable.ArrayBuffer[B] = mutable.ArrayBuffer()
    list.foreach(accumulator += f(_))
    accumulator.toList
  }
}
