object Matrix {
  def apply(string: String): Matrix = {
    new Matrix(string)
  }
}

class Matrix(string: String) {

  // With thanks to http://exercism.io/zkxs

  def rows: Vector[Vector[Int]] = {
    string.split("\\n")
      .map(row => {
        row.split(" ")
          .map(element => element.toInt)
          .toVector
      })
      .toVector
  }

  def cols: Vector[Vector[Int]] = rows.transpose

  override def equals(other: Any): Boolean = other match {
    case that: Matrix => rows == that.rows
    case _ => false
  }
}
