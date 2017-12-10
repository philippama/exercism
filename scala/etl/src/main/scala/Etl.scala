object Etl {
    def transform(legacyMapping: Map[Int, Seq[String]]): Map[String, Int] = {
        legacyMapping.flatMap(element => {
            val score = element._1
            val letters = element._2
            letters.map(letter => (letter.toLowerCase(), score))
        })
    }

// After seeing other people's solutions:
//
//        legacyMapping.flatMap{case (score, letters) => letters.map(letter => (letter.toLowerCase(), score))}
//
// The above works because it is really:
//        legacyMapping.flatMap(element => element match {
//            case (score, letters) => letters.map(letter => (letter.toLowerCase(), score))
//        })
//
//        legacyMapping.keys.flatMap(score => legacyMapping(score).map(letter => letter.toLowerCase -> score)).toMap
}
