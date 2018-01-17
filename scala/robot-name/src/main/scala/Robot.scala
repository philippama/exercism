import scala.collection.immutable
import scala.util.Random

class Robot {

  private val random = new Random()

  var name: String = uniqueName

  private def uniqueName = randomLetters(2) + randomDigits(3)

  def reset(): Unit = name = uniqueName

  private def randomLetters(n: Int) = (1 to n).map(x => ('A' + random.nextInt(26)).toChar).mkString("")
  private def randomDigits(n: Int) = (1 to n).map(x => random.nextInt(10).toString).mkString("")

}
