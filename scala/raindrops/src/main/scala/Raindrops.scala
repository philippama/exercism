object Raindrops {
  def convert(n: Int): String = {
    val factorToSound = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

    Some(factorToSound.collect({ case (factor, sound) if n % factor == 0 => sound }).mkString(""))
      .filter(_.nonEmpty)
      .getOrElse(n.toString)
  }
}

