object Raindrops {
  def convert(n: Int): String = {
    val factorToSound = Map(3 -> "Pling", 5 -> "Plang", 7 -> "Plong")
    val sounds = factorToSound.foldLeft("")((sounds, element) => {
      if (n % element._1 == 0) {
        sounds + element._2
      } else sounds
    })
    if (sounds.isEmpty) n.toString else sounds

    //    n match {
    //    case num if num % 3 == 0 => "Pling"
    //    case num if num % 5 == 0 => "Plang"
    //    case num if num % 7 == 0 => "Plong"
    //    case num => num.toString
    //    }
  }
}

