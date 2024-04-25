package Chess

object Board {

}

val setupBoard: List[Chess.Pieces] = {
  val startingPositions = List(
    Pieces(Chesspiece.ROOK, (0,0), Colors.WHITE),
    Pieces(Chesspiece.KNIGHT, (0, 1), Colors.WHITE),
    Pieces(Chesspiece.BISHOP, (0, 2), Colors.WHITE),
    Pieces(Chesspiece.QUEEN, (0, 3), Colors.WHITE),
    Pieces(Chesspiece.KING, (0, 4), Colors.WHITE),
    Pieces(Chesspiece.BISHOP, (0, 5), Colors.WHITE),
    Pieces(Chesspiece.KNIGHT, (0, 6), Colors.WHITE),
    Pieces(Chesspiece.ROOK, (0, 7), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 0), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 1), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 2), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 3), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 4), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 5), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 6), Colors.WHITE),
    Pieces(Chesspiece.PAWN, (1, 7), Colors.WHITE),
    Pieces(Chesspiece.ROOK, (7, 0), Colors.BLACK),
    Pieces(Chesspiece.KNIGHT, (7, 1), Colors.BLACK),
    Pieces(Chesspiece.BISHOP, (7, 2), Colors.BLACK),
    Pieces(Chesspiece.QUEEN, (7, 3), Colors.BLACK),
    Pieces(Chesspiece.KING, (7, 4), Colors.BLACK),
    Pieces(Chesspiece.BISHOP, (7, 5), Colors.BLACK),
    Pieces(Chesspiece.KNIGHT, (7, 6), Colors.BLACK),
    Pieces(Chesspiece.ROOK, (7, 7), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 0), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 1), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 2), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 3), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 4), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 5), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 6), Colors.BLACK),
    Pieces(Chesspiece.PAWN, (6, 7), Colors.BLACK)
  )
  startingPositions
}



def printPieces(): Unit = {
  setupBoard.foreach { piece =>
    val colorText = if (piece.getColor() == Colors.WHITE) "Weiß" else "Schwarz"
    val pieceTypeText = piece.getPiece() match {
      case Chesspiece.ROOK   => "♖"
      case Chesspiece.KNIGHT => "♘"
      case Chesspiece.BISHOP => "♗"
      case Chesspiece.QUEEN  => "♕"
      case Chesspiece.KING   => "♔"
      case Chesspiece.PAWN   => "♙"
    }
    println(s"$colorText $pieceTypeText auf Position (${piece.getCords()}")
  }
}
