import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ChessboardSpec extends AnyWordSpec {
  "The Chessboard" when {
    "created" should {
      "generate the correct layout" in {
        val expectedOutput =
          """+---+---+---+---+---+---+---+---+
            || K |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            || Q |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            || P |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            || N |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            || B |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            || R |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            ||   |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+
            ||   |   |   |   |   |   |   |   |
            |+---+---+---+---+---+---+---+---+"""

        val outputStream = new java.io.ByteArrayOutputStream()
        Console.withOut(outputStream) {
          Chessboard.main(Array.empty)
        }
        val generatedOutput = outputStream.toString.stripMargin

        generatedOutput shouldEqual expectedOutput
      }
    }
  }
}
