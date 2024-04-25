package Chess

object Pieces {
  def addPiece(chesspiece: Chesspiece, cords: (Int, Int),color: Colors): Pieces = new Pieces(chesspiece, cords, color)
}

class Pieces(val chesspiece: Chesspiece, val cords: (Int, Int), color: Colors) {
  def getColor(): Colors = color
  def getPiece(): Chesspiece = chesspiece
  def getCords(): (Int, Int) = cords
}

enum Colors:
  case WHITE, BLACK

enum Chesspiece:
  case KING, PAWN, QUEEN, BISHOP, KNIGHT, ROOK