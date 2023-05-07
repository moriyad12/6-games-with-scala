import jdk.internal.platform.Container

object tic {
 def initTic(): Array[Any] = {
  val container = Array(Array("", "", ""), Array("", "", ""), Array("", "", ""))
  var par = new Array[Any](2)
  par(0) = container
  par(1) = true
  return par
 }
  def ticController(par :Array[Any], Input :Array[Int]):  Array[Any] ={
   var container = par(0).asInstanceOf[Array[Array[String]]]
   var turn = par(1).asInstanceOf[Boolean]
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

   par(0) = container
   par(1) = turn
    return par
  }

 def validMove(container: Array[Array[String]], r1: Int, c1: Int): Boolean = {
  if (container(r1)(c1) == "X" || container(r1)(c1) == "O")
   return false
  return true
 }

}
