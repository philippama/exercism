import scala.collection.mutable

object SecretHandshake {
    val digitActions = Map(
        0 -> ((handshake: List[String]) => handshake :+ "wink"),
        1 -> ((handshake: List[String]) => handshake :+ "double blink"),
        2 -> ((handshake: List[String]) => handshake :+ "close your eyes"),
        3 -> ((handshake: List[String]) => handshake :+ "jump"),
        4 -> ((handshake: List[String]) => handshake.reverse)
    )

    def commands(number: Int): List[String] = {
        digitActions.foldLeft(List[String]()) ((actionList, digitAction) => {
            if (containsBinaryPower(number, digitAction._1)) digitAction._2(actionList) else actionList
        })
    }

    private def containsBinaryPower(number: Int, binaryPower: Int) = {
        (number & (1 << binaryPower)) != 0
    }
}
