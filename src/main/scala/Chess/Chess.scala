package Chess
import scala.language.postfixOps
object ChessGame {
  def main(args: Array[String]): Unit = {
    val b : Board = new Board(8)
    
    TUI().initializeBoard(b)
  }
}