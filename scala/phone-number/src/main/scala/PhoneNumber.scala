object PhoneNumber {
  private val validStrippedPhoneNumber = "[2-9][0-9]{2}[2-9][0-9]{6}"

  def clean(input: String): Option[String] = {
    Some(input)
      .map(_.filter(_.isDigit))
      .map {
        case s if s.length == 11 && s.head == '1' => s.tail
        case s => s
      }
      .filter(_.matches(validStrippedPhoneNumber))
  }
}
