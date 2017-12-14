object Robot {
    def apply(direction: Bearing.Value, position: (Int, Int)): Robot = {
        new Robot(direction, position)
    }

}

class Robot(direction: Bearing.Value, position: (Int, Int)) {

    //TODO: Use    type Position = (Int, Int) ?
    val bearing: Bearing.Value = direction
    val coordinates: (Int, Int) = position

    def turnRight: Robot = this
    def turnLeft: Robot = this
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