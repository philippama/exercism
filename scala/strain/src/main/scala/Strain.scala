object Strain {
  def keep[T](sequence: Seq[T], predicate: T => Boolean): Seq[T] = {
    sequence.foldLeft(Seq[T]())((acc, element) => {
      element match {
        case e if predicate(e) => element +: acc
        case _ => acc
      }
    }).reverse
  }

  def discard[T](sequence: Seq[T], predicate: T => Boolean): Seq[T] = keep(sequence, (x: T) => !predicate(x))
}
