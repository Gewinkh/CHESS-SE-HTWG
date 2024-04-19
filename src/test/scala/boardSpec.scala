import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class boardSpec extends AnyWordSpec {

  "A ChessBoard" when {

    "created with size 8" should {
      val chessBoard = new ChessBoard(8)


      "have correct edge length" in {
        val expectedEdge = "\n+----+----+----+----+----+----+----+----+"
        chessBoard.createField() should startWith(expectedEdge)
      }

      "contain correct number of rows" in {
        chessBoard.createField().split("\n").length shouldBe 18
      }

      "contain correct number of columns in each row" in {
        val rows = chessBoard.createField().split("\n")
        assert(rows.forall(row => row.count(_ == '|') == 9 || row.count(_ == '|') == 0))
      }

    }
  }
}
