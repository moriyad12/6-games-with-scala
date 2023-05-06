import org.example.menu

object abstractengine {

  def chooseGame(name :String): Array[Any] = {
   if(name=="chess") return chess.initChess()
   else if(name=="connect") return connect.initConnect()
   else if(name=="tic") return tic.initTic()
   else if(name=="checkers") return checker.initChecker()
   else if(name=="sudko") return sudko.initSudko()
   else return quuen.initQueen()
  }

  def Controller(name: String,pra :Array[Any], Input :Array[Int]):Array[Any] ={
    if (name == "chess") return chess.chessController(pra, Input)
    else if (name == "connect") return connect.connectController(pra, Input)
    else if (name == "tic") return tic.ticController(pra, Input)
    else if (name == "checkers") return checker.checkerController(pra, Input)
    else if (name == "sudko") return sudko.sudkoController(pra,Input)
    else return quuen.quuenController(pra,Input)
  }
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
    while(frame.gamename()=="")
      {
        print("")
      }
      //create game
      val pra =chooseGame(frame.gamename())
    val game=frame.creategame(pra)
    //game loop
    while (true) {
      while(game.inputReady()!=2)
        {
          print("")
        }
        game.drawer(Controller(frame.gamename,pra,game.input))

    }

  }

}
