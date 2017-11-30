import scala.collection.immutable.ListMap

class School {
  type DB = Map[Int, Seq[String]]

  var db: DB = Map[Int, Seq[String]]()

  def add(name: String, grade: Int): Unit = {
    val studentsWithGrade: Seq[String] = db.get(grade)
            .map(_ :+ name)
            .getOrElse(List(name))
    db = db + (grade -> studentsWithGrade)
  }

  def grade(g: Int): Seq[String] = db.getOrElse(g, List())

  def sorted: DB = {
    val sortedValues = db.mapValues(_.sorted)
    val sortedByKey = ListMap(sortedValues.toSeq.sortBy(_._1): _*)
    sortedByKey
  }
}
