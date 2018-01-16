object Strain {
  def keep[T](sequence: Seq[T], predicate: T => Boolean): Seq[T] = {
    var accumulator = List[T]()
    for (element <- sequence) {
      if (predicate(element)) {
        accumulator = accumulator :+ element
      }
    }
    accumulator
  }

  def discard[T](sequence: Seq[T], predicate: T => Boolean): Seq[T] = keep(sequence, (x: T) => !predicate(x))

}
