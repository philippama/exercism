object BookStore {
  def total(basket: List[Int]): Double = {
    val price = 8

    var unbatchedBooks = basket.groupBy(book => book).values.toList
    var bookBatches = List[List[Int]]()

    while (unbatchedBooks.nonEmpty) {
      bookBatches = bookBatches :+ unbatchedBooks.map(_.head)
      unbatchedBooks = unbatchedBooks.map(_.tail).filter(_.nonEmpty)
    }

    bookBatches.map(_.length).map(batchPrice(price, _)).sum
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
}
