object BookStore {
  def total(basket: List[Int]): Int = {
    val price = 8
    val discount2 = 0.05 // saving = 0.10 ; saving for 60 books =  3.0
    val discount3 = 0.10 // saving = 0.30 ; saving for 60 books =  6.0
    val discount4 = 0.20 // saving = 0.80 ; saving for 60 books = 12.0
    val discount5 = 0.25 // saving = 1.25 ; saving for 60 books = 15.0

    basket.length * price
  }

}
