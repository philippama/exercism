import scala.annotation.tailrec

object BookStore {
  def total(list: List[Int]) = {
    if (list.size > 0) {
      list
        .zipWithIndex
        .flatMap { case (_, i) => computeDeals(list, i + 1) }
        .min
    } else 0.0
  }

  private def computeDeals(list: List[Int], i: Int) = {
    list
      .combinations(i)
      .map(_.toList)
      .toList
      .map { case subList: List[Int] =>
        price(subList) + price(list.diff(subList))
      }
  }

  private def price(list: List[Int]) = {
    @tailrec
    def price(list: List[Int], sum: Double): Double = {
      list match {
        case Nil => sum
        case _   =>
          val distinct = list.distinct
          price(list.diff(distinct), sum + catalogue(distinct.size))
      }
    }

    price(list, 0.0)
  }

  val catalogue = Map(
    0 -> 0.0,
    1 -> 8.0,
    2 -> 2 * 8.0 * 0.95,
    3 -> 3 * 8.0 * 0.9,
    4 -> 4 * 8.0 * 0.8,
    5 -> 5 * 8.0 * 0.75
  )

  //---------------------------

  def totalX(basket: List[Int]): Double = {
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
