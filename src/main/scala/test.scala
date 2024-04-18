import scala.language.postfixOps
@main def hello(): Unit =
  val h2Line = "__"
  val hLine = "_"
  val vLine = "|"
  val space = " "
  val nextLVLine = "|\n"
  val nextLPlus = "+\n"
  val plus = "+"
  val minus = "-"


  val king = "K"
  val pawn = "P"
  val queen = "Q"
  val bishop = "B"
  val knight = "N"
  val rook = "R"
  val empty = " "
  // a


  val edge = plus + minus * 3


  def createfield(ssize: Int): Unit = {
    val edgefield = edge * ssize + nextLPlus
    val unit = vLine + space * 3
    val unitline = unit * ssize + nextLVLine
    print("\n" + (edgefield + unitline) * ssize + edgefield)
  }

  def field(player:String): Unit = {
    val edgefield = edge + nextLPlus
    val unit = vLine + space + player + space + nextLVLine
    print("\n" + edgefield + unit + edgefield)
  }

  createfield(8)
  print(field(queen))
  print(field(king))
  print(field(pawn))
  print(field(knight))
  print(field(bishop))
  print(field(rook))
  print(field(empty))