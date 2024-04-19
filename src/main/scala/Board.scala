package

class Board(size : Int) {
  val h2Line = "__"
  val hLine = "_"
  val vLine = "|"
  val space = " "
  val nextLVLine = "|\n"
  val nextLPlus = "+\n"
  val plus = "+"
  val minus = "-"
  val edge = plus + minus * 3
}

def createField(): String = {
  val edgeField = edge * size + nextLPlus
  val unit = vLine + space * 3
  val unitLine = unit * size + nextLVLine
  "\n" + (edgeField + unitLine) * size + edgeField
}
def field(piece: ChessPiece): String = {
  val edgeField = edge + nextLPlus
  val unit = vLine + space + piece.symbol + space + nextLVLine
  edgeField + unit + edgeField
}