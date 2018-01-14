object PhoneNumber {
  private val countryCode = "[\\+1]?"
  private val whitespace = "\\s*"
  private val areaCode = "" //TIDO: WIP
//  private val areaCode = "\\(?[2-9][0-9]{2}\\)?" //TIDO: WIP
//    private val validPhoneNumber = "[\\+0-9\\(\\)\\s\\.-]*" //TODO: find better regex
  private val validPhoneNumber = countryCode + whitespace + areaCode + whitespace +
    "[0-9\\(\\)\\s*\\.-]*" //TODO: find better regex
  private val digit = "[0-9]".r

  def clean(phoneNumber: String): Option[String] = {
    cleanWithCollectionFunctions(phoneNumber)
//    cleanWithRegex(phoneNumber)
  }

  private def cleanWithCollectionFunctions(phoneNumber: String) = Some(phoneNumber)
    .map(_.filter(c => "0123456789".contains(c)))
    .map {
      case s if s.length == 11 && s.startsWith("1") => s.substring(1)
      case s => s
    }
    .filter(_.length == 10)
    .filter(s => "23456789".contains(s(0)))
    .filter(s => "23456789".contains(s(3)))

  private def cleanWithRegex(phoneNumber: String) = {
    println(s"Input: $phoneNumber")
    val maybeString = Some(phoneNumber)
      .filter(_.matches(validPhoneNumber)) //TODO: find better way of doing this
      .map(_.filter(c => digit.findAllIn(c.toString).nonEmpty))
      .filterNot(number => number.length == 11 && !number.startsWith("1"))
      .map {
        case s if s.length == 11 && s.startsWith("1") => s.substring(1)
        case s => s
      }
      .filter(_.length == 10)
    //    println("Output: " + maybeString.getOrElse("None"))
    maybeString
  }
}
