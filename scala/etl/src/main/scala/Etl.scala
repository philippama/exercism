object Etl {
    def transform(legacyMapping: Map[Int, Seq[String]]): Map[String, Int] = {
        legacyMapping.flatMap(element => {
            val score = element._1
            val letters = element._2
            letters.map(letter => (letter.toLowerCase(), score))
        })
    }
}
