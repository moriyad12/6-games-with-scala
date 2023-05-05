object connect {
  def initConnect(): Array[Any] = {
    val size = 8
    val iscircle = true
    val container = Array(Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""))
    val colors = Array(Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"), Array("white", "white", "white", "white", "white", "white", "white", "white"))
    var par = new Array[Any](5)
    par(0) = size
    par(1) = iscircle
    par(2) = container
    par(3) = colors
    par(4) = true
    return par
  }
  def connectController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    //println("done")
    var container = par(2).asInstanceOf[Array[Array[String]]]
    var colors = par(3).asInstanceOf[Array[Array[String]]]
    var turn = par(4).asInstanceOf[Boolean]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4)
    //game logic
    if(!validMove(colors, r1, c1))
      println("not valid move")
    else {
      if (turn == true) {
        colors(r1)(c1) = "red"
      }
      else {
        colors(r1)(c1) = "blue"
      }
      turn = abstractengine.changeTurn(turn)}

    par(2) = container
    par(3) = colors
    par(4)=turn
    return par
  }
  def validMove(colors:Array[Array[String]],r1:Int,c1:Int): Boolean =
  {
    if(colors(r1)(c1)== "blue"||colors(r1)(c1)=="red")
   return false
    else if(r1!=7&&colors(r1+1)(c1)!="blue" &&colors(r1+1)(c1)!="red")
    return false
    return true
  }

}
