import scala.annotation.tailrec
import scala.util.Random

object UniqueNameGenerator {
  private val random = new Random()

  private var names = scala.collection.mutable.Set[String]()


  def uniqueName: String = this.synchronized { nextUniqueName }


  def newName(name: String): String = this.synchronized {
    if (names.contains(name)) {
      names.remove(name)
    }
    nextUniqueName
  }

  @tailrec
  def nextUniqueName: String = {
    val name = generateName
    if (!names.contains(name)) {
      names = names + name
//      if (names.size % 1000 == 0) println(names.size)
      name
    }
    else nextUniqueName
  }

  private def generateName = randomLetters(2) + randomDigits(3)

  private def randomLetters(n: Int) = (1 to n).map(x => ('A' + random.nextInt(26)).toChar).mkString("")
  private def randomDigits(n: Int) = (1 to n).map(x => random.nextInt(10).toString).mkString("")

}
