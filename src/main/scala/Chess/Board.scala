package Chess

object Board {

}

def setupBoard(): List[Pieces] = {
  val startingPositions = List(
    addPiece(ROOK, Coordinates(0,0), WHITE),
    addPiece(KNIGHT, Coordinates(0, 1), WHITE),
    addPiece(BISHOP, Coordinates(0, 2), WHITE),
    addPiece(QUEEN, Coordinates(0, 3), WHITE),
    addPiece(KING, Coordinates(0, 4), WHITE),
    addPiece(BISHOP, Coordinates(0, 5), WHITE),
    addPiece(KNIGHT, Coordinates(0, 6), WHITE),
    addPiece(ROOK, Coordinates(0, 7), WHITE),
    addPiece(PAWN, Coordinates(1, 0), WHITE),
    addPiece(PAWN, Coordinates(1, 1), WHITE),
    addPiece(PAWN, Coordinates(1, 2), WHITE),
    addPiece(PAWN, Coordinates(1, 3), WHITE),
    addPiece(PAWN, Coordinates(1, 4), WHITE),
    addPiece(PAWN, Coordinates(1, 5), WHITE),
    addPiece(PAWN, Coordinates(1, 6), WHITE),
    addPiece(PAWN, Coordinates(1, 7), WHITE),
    addPiece(ROOK, Coordinates(7, 0), BLACK),
    addPiece(KNIGHT, Coordinates(7, 1), BLACK),
    addPiece(BISHOP, Coordinates(7, 2), BLACK),
    addPiece(QUEEN, Coordinates(7, 3), BLACK),
    addPiece(KING, Coordinates(7, 4), BLACK),
    addPiece(BISHOP, Coordinates(7, 5), BLACK),
    addPiece(KNIGHT, Coordinates(7, 6), BLACK),
    addPiece(ROOK, Coordinates(7, 7), BLACK),
    addPiece(PAWN, Coordinates(6, 0), BLACK),
    addPiece(PAWN, Coordinates(6, 1), BLACK),
    addPiece(PAWN, Coordinates(6, 2), BLACK),
    addPiece(PAWN, Coordinates(6, 3), BLACK),
    addPiece(PAWN, Coordinates(6, 4), BLACK),
    addPiece(PAWN, Coordinates(6, 5), BLACK),
    addPiece(PAWN, Coordinates(6, 6), BLACK),
    addPiece(PAWN, Coordinates(6, 7), BLACK)
  )

  startingPositions.map { case (piece, position) =>
    Chess.Pieces.addPiece(piece, position)
  }
}


def printPieces(pieces: List[ChessPiece]): Unit = {
  pieces.foreach { piece =>
    val colorText = if (piece.color == WHITE) "Weiß" else "Schwarz"
    val pieceTypeText = piece.pieceType match {
      case ROOK   => "Turm"
      case KNIGHT => "Springer"
      case BISHOP => "Läufer"
      case QUEEN  => "Dame"
      case KING   => "König"
      case PAWN   => "Bauer"
    }
    println(s"$colorText $pieceTypeText auf Position (${piece.coordinates.x}, ${piece.coordinates.y})")
  }
}
