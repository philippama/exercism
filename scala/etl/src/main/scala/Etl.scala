object Etl {
    def transform(legacyMapping: Map[Int, Seq[String]]): Map[String, Int] = {
        legacyMapping.keys
                .flatMap(
                    key => {
                        legacyMapping(key)
                                .map(_.toLowerCase)
                                .map((_, key))
                    }
                )
                .toMap
    }

}
