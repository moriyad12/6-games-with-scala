object chess {
  def initChess(): Array[Any] = {
    val container = Array(Array("♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"), Array("♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"), Array("♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"))
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))
    var par = new Array[Any](2)
    par(0) = container
    par(1)=true
    return par
  }
  def chessController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    var container = par(0).asInstanceOf[Array[Array[String]]]
    var turn = par(1).asInstanceOf[Boolean]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4)
    //game logic





    par(0) = container
    par(1) = turn
    return par
  }
  }


