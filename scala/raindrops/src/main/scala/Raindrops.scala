object Raindrops {
  def convert(n: Int): String = {
    val factorToSound = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

    factorToSound
      .filter(mapping => n % mapping._1 == 0)
      .values
      .reduceLeftOption(_ + _)
      .getOrElse(n.toString)
  }
}

