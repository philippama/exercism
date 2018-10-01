object Raindrops {
  def convert(n: Int): String = {
    val factorToSound = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

    factorToSound
      .filter(mapping => n % mapping._1 == 0)
      .values
      .reduceLeftOption(_ + _)
      .getOrElse(n.toString)
  }

  def convert2(n: Int): String = {
    val factorToSound = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

    // This is a partial function: { case (factor, sound) if n % factor == 0 => sound }
    Some(factorToSound.collect({ case (factor, sound) if n % factor == 0 => sound }).mkString(""))
      .filter(_.nonEmpty)
      .getOrElse(n.toString)
  }

  def convert1(n: Int): String = {
    val factorToSound = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")

    Some(factorToSound.foldLeft("")((sounds, element) => {
      if (n % element._1 == 0) {
        sounds + element._2
      } else sounds
    }))
      .filter(_.nonEmpty)
      .getOrElse(n.toString)

    //    n match {
    //    case num if num % 3 == 0 => "Pling"
    //    case num if num % 5 == 0 => "Plang"
    //    case num if num % 7 == 0 => "Plong"
    //    case num => num.toString
    //    }
  }
}

