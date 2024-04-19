import scala.language.postfixOps


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
    val boardSize = 8 // Beispiel-Brettgröße
    val chessBoard = new Board(boardSize)
    val pieces = ChessPieces

    println(chessBoard.createField())
    println(chessBoard.field(pieces.queen))
    println(chessBoard.field(pieces.king))
    println(chessBoard.field(pieces.pawn))
    println(chessBoard.field(pieces.knight))
    println(chessBoard.field(pieces.bishop))
    println(chessBoard.field(pieces.rook))
    println(chessBoard.field(pieces.empty))
  }
}
