import org.example.boarddrawer

object quuen {
  def initQueen(): Array[Any] = {
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))
    val container = Array(Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""))
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

  def queendrawer(par: Array[Any],game:boarddrawer): Unit = {
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))
    game.updategrid(8, false, par(0).asInstanceOf[Array[Array[String]]], colors)

  }

  def quuenController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    var container = par(0).asInstanceOf[Array[Array[String]]]
    var turn = par(1).asInstanceOf[Boolean]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4)
    //game logic
    var update = check_do(r1, c1, container)
    if (update == 2) {
      container(r1)(c1) = "♛"
    } else if (update == 1) {
      container(r1)(c1) = ""
    }
    par(0) = container
    par(1) = turn
    return par
  }

  def check_do(x: Int, y: Int, container: Array[Array[String]]): Int = {
    if (container(x)(y) == "♛") {
      return 1
    }
    if (check_x_axis(x, y, container) && check_y_axis(x, y, container) && check_diagonal(x, y, container) && check_reverse_diagonal(x, y, container)) {
      return 2;
    }
    0
  }

  def check_x_axis(x: Int, y: Int, container: Array[Array[String]]): Boolean = {
    for (i <- x - 10 until x + 10) {
      if (!(i < 0 || i > 7)) {
        if (container(i)(y) == "♛") {
          println("Not valid")
          return false
        }
      }
    }
    true
  }

  def check_y_axis(x: Int, y: Int, container: Array[Array[String]]): Boolean = {
    for (i <- y - 10 until y + 10) {
      if (!(i < 0 || i > 7)) {
        if (container(x)(i) == "♛") {
          println("Not valid")
          return false
        }
      }
    }
    true
  }

  def check_diagonal(x: Int, y: Int, container: Array[Array[String]]): Boolean = {
    for (i <- -12 until 12) {
      val nx = x + i
      val ny = y + i
      if (!(nx < 0 || nx > 7 || ny < 0 || ny > 7)) {
        if (container(nx)(ny) == "♛") {
          println("Not valid")
          return false
        }
      }
    }
    true
  }

  def check_reverse_diagonal(x: Int, y: Int, container: Array[Array[String]]): Boolean = {
    for (i <- -12 until 12) {
      val nx = x - i
      val ny = y + i
      if (!(nx < 0 || nx > 7 || ny < 0 || ny > 7)) {
        if (container(nx)(ny) == "♛") {
          println("Not valid")
          return false
        }
      }
    }
    true
  }
}