object SecretHandshake {
    def commands(binary: Int): List[String] = {
        val list1 = if ((binary & 1) != 0) List("wink") else List[String]()
        val list10 = if ((binary & 2) != 0)  list1 :+ "double blink" else list1
        val list100 = if ((binary & 4) != 0)  list10 :+ "close your eyes" else list10
        val list1000 = if ((binary & 8) != 0)  list100 :+ "jump" else list100
        val list10000 = if ((binary & 16) != 0)  list1000.reverse else list1000

        list10000
    }

}
