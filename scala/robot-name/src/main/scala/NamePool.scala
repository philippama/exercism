import UniqueNameGenerator.{generateName, names}

import scala.annotation.tailrec
import scala.collection.{immutable, mutable}
import scala.util.Random

object NamePool {

  private def allPossibleNames = ('A' to 'Z').map(c => c.toString)
    .flatMap(name => ('A' to 'Z').map(c => name + c))
    .flatMap(name => (0 to 999).map(n => "%s%03d".format(name, n)))

  private var pool = Random.shuffle(allPossibleNames)
  private var taken = mutable.Set[String]()

  private val random = new Random()

  def uniqueName: String = this.synchronized(nextRandomName)

  def newName(name: String): String = this.synchronized({
    if (taken.contains(name)) {
      taken.remove(name)
      pool :+ name
    }
    uniqueName
  })

  def nextRandomName: String = {
    val next = pool.head
    pool = pool.tail
    taken.add(next)
    next
  }
}
