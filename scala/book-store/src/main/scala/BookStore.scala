object BookStore {
  def total(basket: List[Int]): Double = {
    val price = 8
    val groupedByBook: Map[Int, List[Int]] = basket.groupBy(book => book)
    var bookBatchSizes = List[Int]()

    var unbatchedBookCounts: Map[Int, Int] = groupedByBook.map(book => (book._1, book._2.length)) // TODO: a tuple of (book ID, count)
    if (unbatchedBookCounts.nonEmpty) {
      bookBatchSizes = bookBatchSizes :+ unbatchedBookCounts.size
    }
    unbatchedBookCounts = unbatchedBookCounts.map((bookCount: (Int, Int)) => (bookCount._1, bookCount._2 - 1)).filter(_._2 > 0)
    if (unbatchedBookCounts.nonEmpty) {
      bookBatchSizes = bookBatchSizes :+ unbatchedBookCounts.size
    }

    println(unbatchedBookCounts)

    bookBatchSizes.map(batchPrice(price, _)).sum
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
