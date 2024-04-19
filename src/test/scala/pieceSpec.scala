import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class pieceSpec extends AnyWordSpec {

  "A ChessBoard" when {

    "created with size 8" should {
      val chessBoard = new ChessBoard(8)
      val pieces = ChessPieces

      "create correct field for a queen" in {
        chessBoard.field(pieces.queen) shouldBe
          "+----+\n" +
            "| Q  |\n" +
            "+----+\n"
      }

      "create correct field for a king" in {
        chessBoard.field(pieces.king) shouldBe
          "+----+\n" +
            "| K  |\n" +
            "+----+\n"
      }

      "create correct field for a pawn" in {
        chessBoard.field(pieces.pawn) shouldBe
          "+----+\n" +
            "| P  |\n" +
            "+----+\n"
      }

      "create correct field for a knight" in {
        chessBoard.field(pieces.knight) shouldBe
          "+----+\n" +
            "| N  |\n" +
            "+----+\n"
      }

      "create correct field for a bishop" in {
        chessBoard.field(pieces.bishop) shouldBe
          "+----+\n" +
            "| B  |\n" +
            "+----+\n"
      }

      "create correct field for a rook" in {
        chessBoard.field(pieces.rook) shouldBe
          "+----+\n" +
            "| R  |\n" +
            "+----+\n"
      }

      "create correct field for an empty space" in {
        chessBoard.field(pieces.empty) shouldBe
          "+----+\n" +
            "|    |\n" +
            "+----+\n"
      }
    }
  }
}
