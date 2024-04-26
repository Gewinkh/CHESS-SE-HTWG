package Chess

import scala.io.StdIn
import scala.util.matching.Regex

class TUI() {
  def initializeBoard(b: Board): Unit={
    printBoard(b, b.setupBoard)
  }
  def printBoard(b: Board, list: List[Chess.Pieces]): Unit = {
    print(b.updateField(list))
    val coordinates = readCoordinates()
    if (coordinates != null) {
      val (x1, y1, x2, y2) = coordinates // Tupel entpacken
      val RList =  b.movePieces(x1, y1, x2, y2, list)
      if (RList != null) {
        println("succes")
        printBoard(b, RList)
      } else {
        println("Ungültige Position!")
        print(b.updateField(list))
      }
    }
  }

  private def readCoordinates(): (Int,Int,Int,Int) = {
    val inputPattern: Regex = "([a-z])(\\d) ([a-z])(\\d)".r
    println("\nGib die Koordinaten im Format Buchstabe-Zahl Buchstabe-Zahl (z.B. a1 b3) ein: ")
    val input = StdIn.readLine().toLowerCase.trim

    input match {
      case inputPattern(letter1, number1, letter2, number2) =>
        val column1 = letter1.head - 'a'
        val row1 = number1.toInt - 1
        val column2 = letter2.head - 'a'
        val row2 = number2.toInt - 1
        (column1, row1, column2, row2)

      case _ =>
        println("Ungültiges Eingabeformat. Bitte gib die Koordinaten im richtigen Format ein (z.B. a1 b3).")
        readCoordinates() // Falls die Eingabe nicht dem erwarteten Format entspricht, erneut lesen
    }
  }
}
