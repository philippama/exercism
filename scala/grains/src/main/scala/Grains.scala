object Grains {
  private val two = BigInt(2)

  def square(i: Int): Option[BigInt] = {
    Option(i)
      .filter(x => (x >= 1) && (x <= 64))
      .map(x => two.pow(x - 1))
  }

  def total: BigInt = (1 to 64).map(square).map(_.get).sum
}
