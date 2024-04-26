package Chess

import scala.io.StdIn
import scala.util.matching.Regex

class TUI() {
  def printBoard(b: Board): Unit = {
    print(b.updateField())
    readCoordinates()
  }

  private def readCoordinates(): (String, String) = {
    val inputPattern: Regex = "([a-z])(\\d) ([a-z])(\\d)".r
    print("Gib die Koordinaten im Format Buchstabe-Zahl Buchstabe-Zahl (z.B. a1 b3) ein: ")
    val input = StdIn.readLine().toLowerCase.trim

    input match {
      case inputPattern(letter1, number1, letter2, number2) =>
        val column1 = letter1.head - 'a'
        val row1 = number1.toInt - 1
        val column2 = letter2.head - 'a'
        val row2 = number2.toInt - 1
        (row1, column1, row2, column2)
      case _ =>
        println("Ungültiges Eingabeformat. Bitte gib die Koordinaten im richtigen Format ein (z.B. a1 b3).")
        readCoordinates() // Falls die Eingabe nicht dem erwarteten Format entspricht, erneut lesen
    }
  }
}
