import org.scalatest.wordspec.AnyWordSpec

class test1 extends AnyWordSpec {
  "createfield" should {
    "return a string representing a chessboard of given size" in {
      val expected =
        """
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           |    |    |    |    |    |    |    |    |
           +----+----+----+----+----+----+----+----+
           """.stripMargin.trim

      assert(test1.createfield(8) === expected)
    }
  }

  "field" should {
    "return a string representing a chessboard field with a player piece" in {
      assert(test1.field("Q") === "+----+\n| Q  |\n+----+")
      assert(test1.field("K") === "+----+\n| K  |\n+----+")
      assert(test1.field("P") === "+----+\n| P  |\n+----+")
      assert(test1.field("N") === "+----+\n| N  |\n+----+")
      assert(test1.field("B") === "+----+\n| B  |\n+----+")
      assert(test1.field("R") === "+----+\n| R  |\n+----+")
      assert(test1.field("") === "+----+\n|    |\n+----+")
    }
  }
}
