object Robot {
    def apply(bearing: Bearing.Value, coordinates: (Int, Int)): Robot = {
        new Robot(bearing, coordinates)
    }

}

class Robot(val bearing: Bearing.Value, val coordinates: (Int, Int)) {

    def turnRight: Robot = {
        bearing match {
            case Bearing.North => new Robot(Bearing.East, coordinates)
            case Bearing.East => new Robot(Bearing.South, coordinates)
            case Bearing.South => new Robot(Bearing.West, coordinates)
            case Bearing.West => new Robot(Bearing.North, coordinates)
        }
    }

    def turnLeft: Robot = {
        bearing match {
            case Bearing.North => new Robot(Bearing.West, coordinates)
            case Bearing.West => new Robot(Bearing.South, coordinates)
            case Bearing.South => new Robot(Bearing.East, coordinates)
            case Bearing.East => new Robot(Bearing.North, coordinates)
        }
    }

    def advance: Robot = this

    def simulate(str: String): Robot = this


    def canEqual(other: Any): Boolean = other.isInstanceOf[Robot]

    override def equals(other: Any): Boolean = other match {
        case that: Robot =>
            (that canEqual this) &&
                    bearing == that.bearing &&
                    coordinates == that.coordinates
        case _ => false
    }

    override def hashCode(): Int = {
        val state = Seq(bearing, coordinates)
        state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }
}

object Bearing extends Enumeration {
    type Bearing = Value
    val North, East, South, West = Value
}