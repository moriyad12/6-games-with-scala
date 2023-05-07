object checker {
  def initChecker(): Array[Any] = {
    val container = Array(Array("", "♝", "", "♝", "", "♝", "", "♝", ""), Array("♝", "", "♝", "", "♝", "", "♝", "", "♝"), Array("", "♝", "", "♝", "", "♝", "", "♝", ""), Array("", "", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", "", ""), Array("♟", "", "♟", "", "♟", "", "♟", "", "♟"), Array("", "♟", "", "♟", "", "♟", "", "♟", ""), Array("♟", "", "♟", "", "♟", "", "♟", "", "♟"))
    var par = new Array[Any](2)
    par(0) = container
    par(1) = true
    return par
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
