object SecretHandshake {
  val digitActions = Map(
    0 -> ((handshake: List[String]) => handshake :+ "wink"),
    1 -> ((handshake: List[String]) => handshake :+ "double blink"),
    2 -> ((handshake: List[String]) => handshake :+ "close your eyes"),
    3 -> ((handshake: List[String]) => handshake :+ "jump"),
    4 -> ((handshake: List[String]) => handshake.reverse)
  )

  def commands(number: Int): List[String] = {
    digitActions.foldLeft(List[String]()) ((handshake, digitAction) => {
      val digit: Int = digitAction._1
      val action: List[String] => List[String] = digitAction._2
      if (containsBinaryPower(number, digit)) action(handshake) else handshake
    })
  }

  private def containsBinaryPower(number: Int, binaryPower: Int) = (number & (1 << binaryPower)) != 0
}
