object DifferenceOfSquares {

  def square(x: Int): Int = x * x

  def sumOfSquares(n: Int): Int = (1 to n).map(square).sum

  def squareOfSum(n: Int): Int = square((1 to n).sum)

  def differenceOfSquares(n: Int): Int = squareOfSum(n) - sumOfSquares(n)
}
