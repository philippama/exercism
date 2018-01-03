object BookStore {
  def total(basket: List[Int]): Double = {
    val price = 8

    var unbatchedBooks = basket.groupBy(book => book).values.toList

    batchBooks(unbatchedBooks)
      .map(_.length)
      .map(batchPrice(price, _))
      .sum
  }

  private def batchBooks(unbatchedBooks: List[List[Int]]): List[List[Int]] = {
    if (unbatchedBooks.isEmpty) {
      List[List[Int]]()
    }
    else {
      val newBatch = unbatchedBooks.map(_.head)
      newBatch +: batchBooks(unbatchedBooks.map(_.tail).filter(_.nonEmpty))
    }
  }

  private def batchBooksWithCase(unbatchedBooks: List[List[Int]]): List[List[Int]] = {
    unbatchedBooks match {
      case books if books.nonEmpty => books.map(_.head) +: batchBooksWithCase(books.map(_.tail).filter(_.nonEmpty))
      case _ => List[List[Int]]()
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
}
