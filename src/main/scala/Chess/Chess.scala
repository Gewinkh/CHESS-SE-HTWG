package Chess
import scala.language.postfixOps

class ChessBoard(size: Int) {
  val h2Line = "__"
  val hLine = "_"
  val vLine = "|"
  val space = " "
  val nextLVLine = "|\n"
  val nextLPlus = "+\n"
  val plus = "+"
  val minus = "-"

  val edge = plus + minus * 4

  def createField(): String = {
    val edgeField = edge * size + nextLPlus
    val unit = vLine + space * 4
    val unitLine = unit * size + nextLVLine
    "\n" +edgeField + unitLine* size + edgeField
  }
}


object ChessGame {
  def main(args: Array[String]): Unit = {
    print("halo")
    printPieces()
  }
}