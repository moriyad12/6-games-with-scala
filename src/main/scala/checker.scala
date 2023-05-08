import org.example.boarddrawer

object checker {
  def initChecker(): Array[Any] = {
    val container = Array(Array("", "♝", "", "♝", "", "♝", "", "♝", ""), Array("♝", "", "♝", "", "♝", "", "♝", "", "♝"), Array("", "♝", "", "♝", "", "♝", "", "♝", ""), Array("", "", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", "", ""), Array("♟", "", "♟", "", "♟", "", "♟", "", "♟"), Array("", "♟", "", "♟", "", "♟", "", "♟", ""), Array("♟", "", "♟", "", "♟", "", "♟", "", "♟"))
    var par = new Array[Any](2)
    par(0) = container
    par(1) = true
    return par
  }

  def create(par: Array[Any]): boarddrawer = {
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))

    val frame = new boarddrawer(8, false, par(0).asInstanceOf[Array[Array[String]]], colors)
    frame.pack()
    frame.setResizable(true)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)
    return frame
  }
  def checkerdrawer(par: Array[Any],game:boarddrawer): Unit = {
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))
    game.updategrid(8, false, par(0).asInstanceOf[Array[Array[String]]], colors)
  }
  def checkerController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    var container = par(0).asInstanceOf[Array[Array[String]]]
    var turn = par(1).asInstanceOf[Boolean]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4)
    //game logic





    par(0) = container
    par(1)=turn
    return par
  }

}
