object Hamming {
  def distance(str1: String, str2: String): Option[Int] = {
    Option(str1)
      .filter(_.length == str2.length)
      .map(_.zip(str2).count(t => t._1 != t._2))
  }
}
