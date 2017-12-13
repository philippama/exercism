import scala.collection.mutable

object SecretHandshake {
    def commands(number: Int): List[String] = {
        Some(List[String]())
                .map(withBinaryDigit(_, number, 0))
                .map(withBinaryDigit(_, number, 1))
                .map(withBinaryDigit(_, number, 2))
                .map(withBinaryDigit(_, number, 3))
                .map(withBinaryDigit(_, number, 4))
                .get
    }

    def withBinaryDigit(handshake: List[String], number: Int, binaryPower: Int): List[String] = {
        if ((number & 1 << binaryPower) != 0) {
            binaryPower match {
                case 0 => handshake :+ "wink"
                case 1 => handshake :+ "double blink"
                case 2 => handshake :+ "close your eyes"
                case 3 => handshake :+ "jump"
                case 4 => handshake.reverse
            }
        }
        else handshake
    }

}
