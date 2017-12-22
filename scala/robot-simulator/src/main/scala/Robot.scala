import Bearing._

object Robot {
  def apply(bearing: Direction, coordinates: (Int, Int)): Robot = new Robot(bearing, coordinates)
}

class Robot(val bearing: Direction, val coordinates: (Int, Int)) {

  def turnRight: Robot = Robot(bearing.turnRight(), coordinates)

  def turnLeft: Robot = Robot(bearing.turnLeft(), coordinates)

  def advance: Robot = bearing match {
    case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
    case Bearing.West => Robot(bearing, (coordinates._1 - 1, coordinates._2))
    case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
    case Bearing.East => Robot(bearing, (coordinates._1 + 1, coordinates._2))
  }

  def simulate(commands: String): Robot = {
    commands.foldLeft(this)((robot: Robot, action: Char) => nextStep(robot, action))
  }

  private def nextStep(robot: Robot, action: Char): Robot = action match {
    case 'L' => robot.turnLeft
    case 'R' => robot.turnRight
    case 'A' => robot.advance
    case _ => robot
  }

  override def equals(other: Any): Boolean = other match {
    case that: Robot =>
      other.isInstanceOf[Robot] &&
        bearing == that.bearing &&
        coordinates == that.coordinates
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(bearing, coordinates)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Robot($bearing, $coordinates)"
}

object Bearing {
  // With thanks to http://exercism.io/devcraftsman for showing how to do this.
  sealed trait Direction {
    def turnLeft() : Direction
    def turnRight() : Direction
  }

  object North extends Direction {
    override def turnLeft(): Direction =  West
    override def turnRight(): Direction =  East
  }

  object South extends Direction {
    override def turnLeft(): Direction =  East
    override def turnRight(): Direction =  West

  }

  object East extends Direction{
    override def turnLeft(): Direction =  North
    override def turnRight(): Direction =  South
  }

  object West extends Direction{
    override def turnLeft(): Direction =  South
    override def turnRight(): Direction =  North
  }

}
