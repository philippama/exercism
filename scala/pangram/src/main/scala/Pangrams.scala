object Pangrams {
  private val alphabet = "[a-z]".r

  def isPangram(sentence: String): Boolean = sentence
    .toLowerCase
    .filter(c => alphabet.findFirstIn(c.toString).nonEmpty)
    .distinct.length == 26
}

