import scala.collection.immutable.ListMap

class School {
  type DB = Map[Int, Seq[String]]

  var db: DB = Map[Int, Seq[String]]()

  def add(name: String, g: Int): Unit = db += (g -> (grade(g) :+ name))

  def grade(g: Int): Seq[String] = db.getOrElse(g, Seq())

  def sorted: DB = {
    val sortedValues = db.mapValues(_.sorted)
    val sortedByKey = ListMap(sortedValues.toSeq.sortBy(_._1): _*)
    sortedByKey
  }
}
