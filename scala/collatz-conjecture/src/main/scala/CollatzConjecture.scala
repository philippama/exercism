import scala.annotation.tailrec

case class Iteration(stepNumber: Int, value: Int)

object CollatzConjecture {

    def steps(number: Int): Option[Int] = {
        Option(number)
            .filter(_ > 0)
            .map(n => doCollatzIteration(Iteration(0, n)))
            .map(i => i.stepNumber)
    }

    @tailrec
    def doCollatzIteration(iteration: Iteration): Iteration = {
        iteration.value match {
            case 1 => Iteration(iteration.stepNumber, 1)
            case value if value % 2 == 0 => doCollatzIteration(Iteration(iteration.stepNumber + 1, value / 2))
            case value => doCollatzIteration(Iteration(iteration.stepNumber + 1, value * 3 + 1))
        }
    }
}
