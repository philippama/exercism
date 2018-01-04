object BookStore {
  def total(basket: List[Int]): Double = {
    val price = 8
    val unbatchedBooks = basket.groupBy(book => book).values.toList

    val batches = OptimiseBatches(batchBooks(unbatchedBooks))
    val total = batches
      .map(_.length)
      .map(batchPrice(price, _))
      .sum

    toTwoDecimalPlaces(total)
  }

  private def batchBooks(unbatchedBooks: List[List[Int]]): List[List[Int]] = {
    if (unbatchedBooks.isEmpty) {
      List[List[Int]]()
    }
    else {
      unbatchedBooks.map(_.head) +: batchBooks(unbatchedBooks.map(_.tail).filter(_.nonEmpty))
    }
  }

  private def batchPrice(basicPrice: Int, batchSize: Int) = {
    (batchSize match {
      case 2 => (1 - 0.05) * 2
      case 3 => (1 - 0.10) * 3
      case 4 => (1 - 0.20) * 4
      case 5 => (1 - 0.25) * 5
      case _ => 1
    }) * basicPrice
  }

  private def toTwoDecimalPlaces(total: Double) = {
    (total * 100).round.toDouble / 100
  }
}
