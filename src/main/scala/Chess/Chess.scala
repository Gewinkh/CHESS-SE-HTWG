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
    "\n" + (edgeField + unitLine) * size + edgeField
  }

  def field(piece: ChessPiece): String = {
    val edgeField = edge + nextLPlus
    val unit = vLine + space + piece.symbol + space * 2 + nextLVLine
    edgeField + unit + edgeField
  }
}

class ChessPiece(val symbol: String)

object ChessPieces {
  val king = new ChessPiece("K")
  val pawn = new ChessPiece("P")
  val queen = new ChessPiece("Q")
  val bishop = new ChessPiece("B")
  val knight = new ChessPiece("N")
  val rook = new ChessPiece("R")
  val empty = new ChessPiece(" ")
}

object ChessGame {
  def main(args: Array[String]): Unit = {
    val boardSize = 8
    val chessBoard = new ChessBoard(boardSize)
    val pieces = ChessPieces

  }
}
