object Series {
  def slices(size: Int, digits: String): List[List[Int]] = {
    (0 to digits.length - size)
      .map(i => digits.substring(i, i + size).map(_.asDigit).toList)
      .toList
  }
}
