import Color.Colour

class Connect(boardLines: List[String]) {
  def winner: Option[Colour] = None
}

object Connect {
  def apply(boardLines: List[String]) = new Connect(boardLines)
}

case class Color()

object Color {
  sealed trait Colour
  case object Black extends Colour
  case object White extends Colour
}