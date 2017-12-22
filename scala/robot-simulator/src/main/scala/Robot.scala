object Robot {
  def apply(bearing: Bearing.Value, coordinates: (Int, Int)): Robot = new Robot(bearing, coordinates)
}

class Robot(val bearing: Bearing.Value, val coordinates: (Int, Int)) {

  def turnRight: Robot = bearing match {
    case Bearing.North => Robot(Bearing.East, coordinates)
    case Bearing.East => Robot(Bearing.South, coordinates)
    case Bearing.South => Robot(Bearing.West, coordinates)
    case Bearing.West => Robot(Bearing.North, coordinates)
  }

  def turnLeft: Robot = bearing match {
    case Bearing.North => Robot(Bearing.West, coordinates)
    case Bearing.West => Robot(Bearing.South, coordinates)
    case Bearing.South => Robot(Bearing.East, coordinates)
    case Bearing.East => Robot(Bearing.North, coordinates)
  }

  def advance: Robot = bearing match {
    case Bearing.North => Robot(bearing, (coordinates._1, coordinates._2 + 1))
    case Bearing.West => Robot(bearing, (coordinates._1 - 1, coordinates._2))
    case Bearing.South => Robot(bearing, (coordinates._1, coordinates._2 - 1))
    case Bearing.East => Robot(bearing, (coordinates._1 + 1, coordinates._2))
  }

  def simulate(commands: String): Robot = {
    commands.foldLeft(this)((robot: Robot, action: Char) => nextStep(robot, action))
  }

  def nextStep(robot: Robot, action: Char): Robot = action match {
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

object Bearing extends Enumeration {
  type Bearing = Value
  val North, East, South, West = Value
}