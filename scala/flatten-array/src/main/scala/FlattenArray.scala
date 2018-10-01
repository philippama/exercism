object FlattenArray {

  def flatten(list: List[Any]): List[Any] = {
    list
      .filter(_ != null)
      .flatMap(element => {
        element match {
          case l: List[Any] =>
            flatten(l)
          case _ => List(element)
        }
      })
  }
}
