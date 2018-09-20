import org.scalatest.{Matchers, FunSuite}

/** @version 1.0.0 */
class RobotSimulatorTest extends FunSuite with Matchers {

  test(
    "A robot is created with a position and a direction - Robots are created with a position and direction") {
    RobotSimulator(Bearing.North, (0, 0)) should be(RobotSimulator(Bearing.North, (0, 0)))
  }

  test(
    "A robot is created with a position and a direction - Negative positions are allowed") {
    RobotSimulator(Bearing.South, (-1, -1)) should be(RobotSimulator(Bearing.South, (-1, -1)))
  }

  test(
    "rotates the robot's direction 90 degrees clockwise - does not change the position") {
    RobotSimulator(Bearing.North, (0, 0)).turnRight.coordinates should be((0, 0))
  }

  test(
    "rotates the robot's direction 90 degrees clockwise - changes the direction from north to east") {
    RobotSimulator(Bearing.North, (0, 0)).turnRight.bearing should be(Bearing.East)
  }

  test(
    "rotates the robot's direction 90 degrees clockwise - changes the direction from east to south") {
    RobotSimulator(Bearing.East, (0, 0)).turnRight.bearing should be(Bearing.South)
  }

  test(
    "rotates the robot's direction 90 degrees clockwise - changes the direction from south to west") {
    RobotSimulator(Bearing.South, (0, 0)).turnRight.bearing should be(Bearing.West)
  }

  test(
    "rotates the robot's direction 90 degrees clockwise - changes the direction from west to north") {
    RobotSimulator(Bearing.West, (0, 0)).turnRight.bearing should be(Bearing.North)
  }

  test(
    "rotates the robot's direction 90 degrees counter-clockwise - does not change the position") {
    RobotSimulator(Bearing.North, (0, 0)).turnLeft.coordinates should be((0, 0))
  }

  test(
    "rotates the robot's direction 90 degrees counter-clockwise - changes the direction from north to west") {
    RobotSimulator(Bearing.North, (0, 0)).turnLeft.bearing should be(Bearing.West)
  }

  test(
    "rotates the robot's direction 90 degrees counter-clockwise - changes the direction from west to south") {
    RobotSimulator(Bearing.West, (0, 0)).turnLeft.bearing should be(Bearing.South)
  }

  test(
    "rotates the robot's direction 90 degrees counter-clockwise - changes the direction from south to east") {
    RobotSimulator(Bearing.South, (0, 0)).turnLeft.bearing should be(Bearing.East)
  }

  test(
    "rotates the robot's direction 90 degrees counter-clockwise - changes the direction from east to north") {
    RobotSimulator(Bearing.East, (0, 0)).turnLeft.bearing should be(Bearing.North)
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - does not change the direction") {
    RobotSimulator(Bearing.North, (0, 0)).advance.bearing should be(Bearing.North)
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - increases the y coordinate one when facing north") {
    RobotSimulator(Bearing.North, (0, 0)).advance.coordinates should be((0, 1))
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - decreases the y coordinate by one when facing south") {
    RobotSimulator(Bearing.South, (0, 0)).advance.coordinates should be((0, -1))
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - increases the x coordinate by one when facing east") {
    RobotSimulator(Bearing.East, (0, 0)).advance.coordinates should be((1, 0))
  }

  test(
    "moves the robot forward 1 space in the direction it is pointing - decreases the x coordinate by one when facing west") {
    RobotSimulator(Bearing.West, (0, 0)).advance.coordinates should be((-1, 0))
  }

  test(
    "Where R = Turn Right, L = Turn Left and A = Advance, the robot can follow a series of instructions and end up with the correct position and direction - instructions to move west and north") {
    RobotSimulator(Bearing.North, (0, 0)).simulate("LAAARALA") should be(
      RobotSimulator(Bearing.West, (-4, 1)))
  }

  test(
    "Where R = Turn Right, L = Turn Left and A = Advance, the robot can follow a series of instructions and end up with the correct position and direction - instructions to move west and south") {
    RobotSimulator(Bearing.East, (2, -7)).simulate("RRAAAAALA") should be(
      RobotSimulator(Bearing.South, (-3, -8)))
  }

  test(
    "Where R = Turn Right, L = Turn Left and A = Advance, the robot can follow a series of instructions and end up with the correct position and direction - instructions to move east and north") {
    RobotSimulator(Bearing.South, (8, 4)).simulate("LAAARRRALLLL") should be(
      RobotSimulator(Bearing.North, (11, 5)))
  }
}
