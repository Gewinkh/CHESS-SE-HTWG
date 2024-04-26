package Chess

object Board {
  def Board(size: Int): Unit = new Board(size)
}

  val h2Line = "__"
  val hLine = "_"
  val vLine = "|"
  val space = " "
  val nextLVLine = "|\n"
  val nextLPlus = "+\n"
  val plus = "+"
  val minus = "-"
  val edge = plus + minus * 4
  
class Board(size: Int) {
  val edgefield = edge * size + nextLPlus
  def checkFieldR(x: Int, y: Int): String = {
    val sr = new StringBuilder
    sr.append(vLine + space)
    setupBoard.find(piece => piece.getCords() == (x, y)) match {
      case Some(foundPiece) => sr.append(foundPiece.getText() + space)
      case None => sr.append(space * 3)
    }
    if(x < size - 1){
      sr.append(checkFieldR(x+1,y))
    } else if(y < size - 1) {
      sr.append(nextLVLine + edgefield)
      sr.append(checkFieldR(0,y+1))
    }
    sr.toString()
  }
  def updateField(): String = {
    val sr = new StringBuilder
    /*sr.append(space*2 + "A" + space * 2 +
              space*2 + "B" + space * 2 +
              space*2 + "C" + space * 2 +
              space*2 + "D" + space * 2 +
              space*2 + "E" + space * 2 +
              space*2 + "F" + space * 2 +)
    */
    sr.append(edgefield)
    sr.append(checkFieldR(0,0))
    sr.toString()
  }
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
    val pieceTypeText = piece.getText()
    println(s"$colorText $pieceTypeText auf Position (${piece.getCords()}")
  }
}
