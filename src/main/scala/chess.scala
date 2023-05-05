object chess {
  def initChess(): Array[Any] = {
    val size = 8
    val iscircle = false
    val container = Array(Array("♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"), Array("♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"), Array("♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"))
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))
    var par = new Array[Any](5)
    par(0) = size
    par(1) = iscircle
    par(2) = container
    par(3) = colors
    par(4)=true
    return par
  }
  def chessController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    var container = par(2).asInstanceOf[Array[Array[String]]]
    var colors = par(3).asInstanceOf[Array[Array[String]]]
    var turn = par(4).asInstanceOf[Boolean]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4)
    //game logic





    par(2) = container
    par(3) = colors
    par(4)=turn
    return par
  }
  }


