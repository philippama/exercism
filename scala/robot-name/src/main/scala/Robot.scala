import scala.collection.immutable
import scala.util.Random

class Robot {

  var name: String = UniqueNameGenerator.uniqueName

  def reset(): Unit = name = UniqueNameGenerator.newName(name)
}
