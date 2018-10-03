object House {

  val phrases = Seq(
    "house that Jack built",
    "malt that lay in",
    "rat that ate",
    "cat that killed",
    "dog that worried",
    "cow with the crumpled horn that tossed",
    "maiden all forlorn that milked",
    "man all tattered and torn that kissed",
    "priest all shaven and shorn that married",
    "rooster that crowed in the morn that woke",
    "farmer sowing his corn that kept",
    "horse and the hound and the horn that belonged to"
  )
  def recite(start: Int, end: Int): String = (start to end).map(reciteLine).mkString + "\n"

  private def reciteLine(lineNumber: Int) = {
    "This is the " +
    (1 to lineNumber)
      .reverse
      .map(i => phrases(i - 1))
      .mkString(" the ") + ".\n"
  }
}
