import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec

class gameSpec extends AnyWordSpec {
  "A ChessBoard" when {
    "created with size 8" should {
      val chessBoard = new ChessBoard(8)
      val pieces = ChessPieces

      "have correct edge length" in {
        val expectedEdge = "+----+----+----+----+----+----+----+----+"
        chessBoard.createField().linesIterator.drop(1).take(1).toList.head shouldBe expectedEdge
      }
    }
  }
}
