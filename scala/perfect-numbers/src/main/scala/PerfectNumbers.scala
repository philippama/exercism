import scala.math.sqrt

object NumberType extends Enumeration {
    val Perfect, Abundant, Deficient = Value
}

object PerfectNumbers {
    def classify(number: Int): Either[String, NumberType.Value] = {
        Option(number)
                .filter(_ > 0)
                .map(toAliquotNumber)
                .map {
                    case n if n == number => NumberType.Perfect
                    case n if n > number => NumberType.Abundant
                    case _ => NumberType.Deficient
                }
                .toRight("Classification is only possible for natural numbers.")
    }

    def toAliquotNumber(number: Int): Int = {
        (1 to number / 2).filter(number % _ == 0).sum
    }

}
