import scala.annotation.tailrec

object CollatzConjecture {
    @tailrec
    def steps(number: Int, stepCount: Int = 0): Any =
        number match {
            case x if x < 1 => None
            case 1 => Some(stepCount)
            case x if x % 2 == 0 => steps(x / 2, stepCount + 1)
            case x => steps(3 * x + 1, stepCount + 1)
        }
}