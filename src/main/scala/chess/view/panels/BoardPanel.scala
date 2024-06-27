package chess.view.panels

import chess.models.*
import chess.controller.*
import chess.controller.controller.{TurnStateBlack, TurnStateWhite, MovePieceWhite, MovePieceBlack}
import chess.models.game.Colors
import chess.models.IPieces


import scala.swing.*
import scala.swing.event.*
import java.awt.Color
import javax.swing.ImageIcon
import scala.annotation.tailrec


class ChessButton(coords: (Int, Int)) extends Button {
  def getCords: (Int, Int) = coords
}
class BoardPanel(rows: Int, cols: Int, dimensionSize: Int = 50, controller: IController) extends GridPanel(rows, cols) {
  private var clicks: Option[IPieces] = None // Initialisieren der Option mit None

  super.rows = rows
  super.columns = cols
  private val backgroundColor = new Color(200,200,200)
  private val selectedButton = new Color(16,78,139)

  // Initialize the board with labels and numbers
  private val emptyLabel = new Label("") {
    opaque = true
    background = backgroundColor
  }
  contents += emptyLabel
  addLabels(('A' to ('A' + cols - 4).toChar).toList)
  addNumbers(1, cols - 1)
  @tailrec
  private def addEmptyLabels(max:Int, n: Int = 0): Unit = {
    if (n <= max) {
      if (n == (max / 2) && max % 2 != 0) {
        val button = new Button()
        button.border = null
        button.background = backgroundColor
        val path = "/buttons/undo.png"
        val ic = new ImageIcon(getClass.getResource(path))
        val scaledIcon = new ImageIcon(ic.getImage.getScaledInstance(dimensionSize, dimensionSize, java.awt.Image.SCALE_SMOOTH))
        button.icon = scaledIcon
        contents += button
        button.reactions += {
          case ButtonClicked(_) =>
            controller.handleAction(UndoAction())
        }
        addEmptyLabels(max, n + 1)
      } else if (n == (max / 2) - 1 && max % 2 == 0) {
        val button = new Button()
        button.border = null
        button.background = backgroundColor
        val path = "/buttons/undo.png"
        val ic = new ImageIcon(getClass.getResource(path))
        val scaledIcon = new ImageIcon(ic.getImage.getScaledInstance(dimensionSize, dimensionSize, java.awt.Image.SCALE_SMOOTH))
        button.icon = scaledIcon
        contents += button
        button.reactions += {
          case ButtonClicked(_) =>
            controller.handleAction(UndoAction())
        }
        addEmptyLabels(max, n + 1)
      } else if (n == (max/2) +1) {
        val button = new Button()
        button.border = null
        button.background = backgroundColor
        val path = "/buttons/redo.png"
        val ic = new ImageIcon(getClass.getResource(path))
        val scaledIcon = new ImageIcon(ic.getImage.getScaledInstance(dimensionSize, dimensionSize, java.awt.Image.SCALE_SMOOTH))
        button.icon = scaledIcon
        contents += button
        button.reactions += {
          case ButtonClicked(_) =>
            controller.handleAction(RedoAction())
        }
        addEmptyLabels(max, n + 1)
      } else {
        val label = new Label("") {
          opaque = true
          background = backgroundColor
        }
        contents += label
        addEmptyLabels(max, n + 1)
      }
    }
  }
  @tailrec
  private def addLabels(alphabet: List[Char], n: Int = 0): Unit = alphabet match {
    case Nil =>
    case letter :: tail =>
      val label = new Label(letter.toString) {
        opaque = true
        background = backgroundColor
      }
      contents += label
      addLabels(tail, n + 1)
  }
  @tailrec
  private def addNumbers(start: Int, end: Int): Unit = {
    if (start <= end) {
      if (start == 1) {
        contents += new Label("") {
          opaque = true
          background = backgroundColor
        }
        addNumbers(start + 1, end)
      } else if (start == end) {
        addEmptyLabels(end - 1)
      } else {
        contents += new Label("") {
          opaque = true
          background = backgroundColor
        }
        addButtonsRow(start, 1, end)
        val label = new Label((start - 1).toString) {
          opaque = true
          background = backgroundColor
        }

        contents += label
        addNumbers(start + 1, end)
      }
    }
  }
  @tailrec
  private def addButtonsRow(n: Int, i: Int, s: Int): Unit = {
    if (i < s - 1) {
      val button = new ChessButton((i - 1, n - 2)) // Erstellen eines ChessButton mit Koordinaten-Tupel
      val foundPiece = controller.getGame.getBoardList.find(p => p.getCords.equals(button.getCords))
      val path = foundPiece match {
        case Some(piece) => piece.getIconPath
        case None => ""
      }
      if (path.nonEmpty) {
        val ic = new ImageIcon(getClass.getResource(path))
        val scaledIcon = new ImageIcon(ic.getImage.getScaledInstance(dimensionSize, dimensionSize, java.awt.Image.SCALE_SMOOTH))
        button.icon = scaledIcon
      }
      if ((n + i) % 2 == 0) {
        button.background = Color.WHITE
      } else {
        button.background = new Color(99, 176, 199)
      }
      button.reactions += {
        case ButtonClicked(_) =>
          val foundPiece = controller.getGame.getBoardList.find(p => p.getCords.equals(button.getCords))
          val coords = button.getCords
          foundPiece match {
            case Some(piece) =>
              controller.getCurrentState match {
                case _: TurnStateWhite =>
                  if (piece.getColor == Colors.WHITE) {
                    controller.handleAction(StartMovePiecesWhite(coords._1, coords._2))
                  } else {
                    controller.handleAction(InvalidAction("wrong color"))
                  }
                case _: TurnStateBlack =>
                  if (piece.getColor == Colors.BLACK) {
                    controller.handleAction(StartMovePiecesBlack(coords._1, coords._2))
                  } else {
                    controller.handleAction(InvalidAction("wrong color"))
                  }
                case _: MovePieceBlack =>
                  if (coords._1 == controller.getCurrentState.getColumn && coords._2 == controller.getCurrentState.getRow) {
                    controller.handleAction(CancelMoveBlack())
                  } else if (piece.getColor == Colors.WHITE) {
                    controller.handleAction(MovePiecesBlack(controller.getCurrentState.getColumn, controller.getCurrentState.getRow, coords._1, coords._2))
                  } else {
                    controller.handleAction(StartMovePiecesBlack(coords._1,coords._2))
                  }
                case _: MovePieceWhite =>
                  if (coords._1 == controller.getCurrentState.getColumn && coords._2 == controller.getCurrentState.getRow) {
                    controller.handleAction(CancelMoveWhite())
                  } else if (piece.getColor == Colors.BLACK) {
                    controller.handleAction(MovePiecesWhite(controller.getCurrentState.getColumn, controller.getCurrentState.getRow, coords._1, coords._2))
                  } else {
                    controller.handleAction(StartMovePiecesWhite(coords._1,coords._2))
                  }
                case _ =>
                  controller.handleAction(InvalidAction("balls"))
              }
            case None =>
              controller.getCurrentState match {
                case _: MovePieceBlack =>
                  controller.handleAction(MovePiecesBlack(controller.getCurrentState.getColumn, controller.getCurrentState.getRow, coords._1, coords._2))
                case _: MovePieceWhite =>
                  controller.handleAction(MovePiecesWhite(controller.getCurrentState.getColumn, controller.getCurrentState.getRow, coords._1, coords._2))
                case _ =>
                  controller.handleAction(InvalidAction("balls"))
              }
          }
      }
      contents += button
      addButtonsRow(n, i + 1, s)
    }
  }
}
