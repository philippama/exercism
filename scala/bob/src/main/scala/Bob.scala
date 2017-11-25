import Bob.isShouting

import scala.util.matching.Regex

object Bob {
  def response(statement: String): String = {
    statement.trim match
    {
      case s if isShouting(s) => "Whoa, chill out!"
      case s if isQuestion(s) => "Sure."
      case s if isSilence(s) => "Fine. Be that way!"
      case _ => "Whatever."
    }
  }

  def isShouting(statement: String): Boolean = {
    containsWord(statement) && (statement == statement.toUpperCase)
  }

  def containsWord(statement: String): Boolean = {
      "[A-Za-z]".r.findFirstIn(statement).nonEmpty
  }

  def isQuestion(statement: String): Boolean = {
    statement.endsWith("?")
  }

  def isSilence(statement: String): Boolean = {
    statement.isEmpty
  }
}
