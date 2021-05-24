import Color.Colour

class Connect(playLines: List[String]) {

  case class Coordinates(row: Int, col: Int)

  private def buildBoard = {
    val lines = playLines.map(_.filter(!_.isSpaceChar))
    val neighbours = (0 to lines.size - 1)
      .map(rowNum => {
        rowNum match {
          case row if lines(row).length <= 1 => Seq()
          case row if row == 0 => (0 until lines(row).length).map(col => {
            Seq(
              Coordinates(row, col + 1),
              Coordinates(row + 1, col)
            )
          })
          case row if row == lines.size - 1 => (0 until lines(row).length).map(col => {
            Seq(
              Coordinates(row - 1, col),
              Coordinates(row - 1, col + 1),
              Coordinates(row, col + 1)
            )
          })
          case row => (0 until lines(row).length).map(col => {
            Seq(
              Coordinates(row - 1, col),
              Coordinates(row - 1, col + 1),
              Coordinates(row, col + 1),
              Coordinates(row + 1, col)
            )
          })
        }
      })

  }

  def winner: Option[Colour] = None
}

object Connect {
  def apply(boardLines: List[String]) = new Connect(boardLines)
}

object Color {

  sealed trait Colour

  case object Black extends Colour

  case object White extends Colour

}