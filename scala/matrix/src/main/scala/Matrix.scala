object Matrix {
  def apply(string: String): Matrix = {
    new Matrix(string)
  }
}

class Matrix(string: String) {

  private val matrix: Array[Vector[Int]] = {
    string.split("\\n")
      .map(row => {
        row.split(" ")
          .map(element => element.toInt)
          .toVector
      })
  }

  def rows: List[Vector[Int]] = matrix.toList

  def cols: List[Vector[Int]] = {
    val emptyColumns = List.fill(matrix.length)(scala.collection.mutable.MutableList[Int]())

    matrix.foldLeft(emptyColumns) ((columns, row) => {
      for (i <- row.indices) {
        columns(i) += row(i)
      }
      columns
    }).map(_.toVector)
  }

  override def equals(other: Any): Boolean = other match {
    case that: Matrix => that.isInstanceOf[Matrix] && (matrix sameElements that.matrix)
    case _ => false
  }
}
