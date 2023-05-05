import jdk.internal.platform.Container

object tic {
 def initTic(): Array[Any] = {
  val size = 3
  val iscircle = false
  val container = Array(Array("", "", ""), Array("", "", ""), Array("", "", ""))
  val colors = Array(Array("white", "gray", "white"), Array("gray", "white", "gray"), Array("white", "gray", "white"))
  var par = new Array[Any](5)
  par(0) = size
  par(1) = iscircle
  par(2) = container
  par(3) = colors
  par(4) = true
  return par
 }
  def ticController(par :Array[Any], Input :Array[Int]):  Array[Any] ={
   var container=par(2).asInstanceOf[Array[Array[String]]]
    var colors= par(3).asInstanceOf[Array[Array[String]]]
   var turn = par(4).asInstanceOf[Boolean]
    val r1 =Input(0)
    val c1 =Input(1)
    val  r2 =Input(2)
    val c2 =Input(3)
    val value=Input(4)
    //game logic
   if (!validMove(container, r1, c1))
    println("not valid move")
   else {
    if (turn==true) {
     container(r1)(c1) = "X"
    }
    else {
     container(r1)(c1) = "O"
    }
   turn = abstractengine.changeTurn(turn)
   }

   par(2)=container
    par(3)=colors
    par(4)=turn
    return par
  }

 def validMove(container: Array[Array[String]], r1: Int, c1: Int): Boolean = {
  if (container(r1)(c1) == "X" || container(r1)(c1) == "O")
   return false
  return true
 }

}
