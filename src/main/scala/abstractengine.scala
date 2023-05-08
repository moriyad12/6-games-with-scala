import org.example.{boarddrawer, menu}

import java.awt.Window
import javax.swing.JFrame

object abstractengine {
  def delete() = {
    val openWindows: Array[Window] = Window.getWindows
    for (window <- openWindows) {
      window.dispose()
    }
  }

  def chooseGame(name: String): Array[Any] = {
    name match {
      case "chess" => chess.initChess()
      case "connect" => connect.initConnect()
      case "tic" => tic.initTic()
      case "checkers" => checker.initChecker()
      case "sudko" => sudko.initSudko()
      case _ => quuen.initQueen()
    }

  }

  def Controller(name: String,pra :Array[Any], Input :Array[Int]):Array[Any] ={
    val result = name match {
      case "chess" => chess.chessController(pra, Input)
      case "connect" => connect.connectController(pra, Input)
      case "tic" => tic.ticController(pra, Input)
      case "checkers" => checker.checkerController(pra, Input)
      case "sudko" => sudko.sudkoController(pra, Input)
      case _ => quuen.quuenController(pra, Input)
    }
    return result
  }

  def Create(name: String, pra: Array[Any]): boarddrawer = {
    val result = name match {
      case "chess" => chess.create(pra)
      case "connect" => connect.create(pra)
      case "tic" => tic.create(pra)
      case "checkers" => checker.create(pra)
      case "sudko" => sudko.create(pra)
      case _ => quuen.create(pra)
    }
    return result
  }
  def Drawer( par :Array[Any],name:String,game:boarddrawer): Unit ={
    name match {
      case "chess" => chess.chessdrawer(par,game)
      case "connect" => connect.connectdrawer(par,game)
      case "tic" => tic.ticdrawer(par,game)
      case "checkers" => checker.checkerdrawer(par,game)
      case "sudko" => sudko.sudkodrawer(par,game)
      case _ => quuen.queendrawer(par,game)
    }}
  def changeTurn(turn:Boolean):Boolean={
    return !turn
  }

  def main(args: Array[String]): Unit = {
    //create menu
    val frame = new menu
    frame.pack()
    frame.setResizable(true)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)
    while (frame.gamename() == "") {
      print("")
    }
    //create game
    val pra = chooseGame(frame.gamename())
    val game = Create(frame.gamename,pra)
    //game loop
    while (true) {
      while (game.inputReady() != 2) {
        print("")
      }
      Drawer(Controller(frame.gamename, pra, game.input), frame.gamename,game)

    }

  }

}
