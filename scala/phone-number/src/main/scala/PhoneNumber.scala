object PhoneNumber {
  private val validStrippedPhoneNumber = "[2-9][0-9]{2}[2-9][0-9]{6}"

  def clean(input: String): Option[String] = {
    Some(input)
      .map(_.filter(c => "0123456789".contains(c)))
      .map {
        case s if s.length == 11 && s.startsWith("1") => s.substring(1)
        case s => s
      }
      .filter(_.matches(validStrippedPhoneNumber))
  }
}
