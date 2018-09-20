import Bearing._

object RobotSimulator {
  def apply(bearing: Direction, coordinates: (Int, Int)): RobotSimulator = new RobotSimulator(bearing, coordinates)
}

class RobotSimulator(val bearing: Direction, val coordinates: (Int, Int)) {

  def turnRight: RobotSimulator = RobotSimulator(bearing.turnRight(), coordinates)

  def turnLeft: RobotSimulator = RobotSimulator(bearing.turnLeft(), coordinates)

  def advance: RobotSimulator = bearing match {
    case Bearing.North => RobotSimulator(bearing, (coordinates._1, coordinates._2 + 1))
    case Bearing.West => RobotSimulator(bearing, (coordinates._1 - 1, coordinates._2))
    case Bearing.South => RobotSimulator(bearing, (coordinates._1, coordinates._2 - 1))
    case Bearing.East => RobotSimulator(bearing, (coordinates._1 + 1, coordinates._2))
  }

  def simulate(commands: String): RobotSimulator = {
    commands.foldLeft(this)((robot: RobotSimulator, action: Char) => nextStep(robot, action))
  }

  private def nextStep(robot: RobotSimulator, action: Char): RobotSimulator = action match {
    case 'L' => robot.turnLeft
    case 'R' => robot.turnRight
    case 'A' => robot.advance
    case _ => robot
  }

  override def equals(other: Any): Boolean = other match {
    case that: RobotSimulator =>
      other.isInstanceOf[RobotSimulator] &&
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
  // With thanks to http://exercism.io/bloomonkey for the trait using a Seq of directions.
  sealed trait Direction {
    val cardinalPoints = Seq(North, East, South, West)

    def turnRight(): Direction = rotate(1)
    def turnLeft(): Direction = rotate(-1)

    def rotate(numPoints: Int): Direction = cardinalPoints((cardinalPoints.indexOf(this) + cardinalPoints.size + numPoints) % cardinalPoints.size)
  }

  case object North extends Direction
  case object East extends Direction
  case object South extends Direction
  case object West extends Direction
}
