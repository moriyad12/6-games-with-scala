import org.example.boarddrawer

object chess {

  def chessdrawer(par: Array[Any],game:boarddrawer): Unit = {
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white"))
   game.updategrid(8, false, par(0).asInstanceOf[Array[Array[String]]], colors)

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

  def initChess(): Array[Any] = {
    val container = Array(Array("♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"), Array("♟", "♟", "♟", "♟", "♟", "♟", "♟", "♟"), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", ""), Array("♙", "♙", "♙", "♙", "♙", "♙", "♙", "♙"), Array("♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖"))
    val color = Array(
      Array("b", "b", "b", "b", "b", "b", "b", "b"),
      Array("b", "b", "b", "b", "b", "b", "b", "b"),
      Array("", "", "", "", "", "", "", ""),
      Array("", "", "", "", "", "", "", ""),
      Array("", "", "", "", "", "", "", ""),
      Array("", "", "", "", "", "", "", ""),
      Array("w", "w", "w", "w", "w", "w", "w", "w"),
      Array("w", "w", "w", "w", "w", "w", "w", "w"))

    var par = new Array[Any](3)
    par(0) = container
    par(1) = true
    par(2) = color
    return par
  }


  def chessController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    var container = par(0).asInstanceOf[Array[Array[String]]]
    var turn = par(1).asInstanceOf[Boolean]
    var color = par(2).asInstanceOf[Array[Array[String]]]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4)
    //game logic
    var TempPar = new Array[Any](3)
    var Temp = true;
    if (container(r1)(c1) == "") {
      Temp = false;
      println("Not valid")
    }
    else if ((turn == true && color(r1)(c1) != "b") || (turn == true && color(r1)(c1) == "b" && color(r2)(c2) == "b")) {
      Temp = false;
      println("Not valid")
    } else if ((turn == false && color(r1)(c1) != "w") || (turn == false && color(r1)(c1) == "w" && color(r2)(c2) == "w")) {
      Temp = false;
      println("Not valid")
    } else if (container(r1)(c1) == "♝" || container(r1)(c1) == "♗") {
      TempPar = checkValidBishop(r1, c1, r2, c2, container, color, turn);
    }
    else if (container(r1)(c1) == "♞" || container(r1)(c1) == "♘") {
      TempPar = checkValidKnight(r1, c1, r2, c2, container, color, turn);
    } else if (container(r1)(c1) == "♚" || container(r1)(c1) == "♔") {
      TempPar = checkValidKing(r1, c1, r2, c2, container, color, turn);
    } else if (container(r1)(c1) == "♜" || container(r1)(c1) == "♖") {
      TempPar = checkValidRock(r1, c1, r2, c2, container, color, turn);
    } else if (container(r1)(c1) == "♟" || container(r1)(c1) == "♙") {
      TempPar = checkValidPawn(r1, c1, r2, c2, container, color, turn);
    } else {
      TempPar = checkValidQueen(r1, c1, r2, c2, container, color, turn);
    }


    if (Temp) {
      par(0) = TempPar(1)
      par(1) = TempPar(3)
      par(2) = TempPar(2)
    } else {
      par(0) = container
      par(1) = turn
      par(2) = color
    }


    return par
  }

  def generatePar(container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {
    var par = new Array[Any](4)
    par(1) = container;
    par(2) = color
    par(3) = turn
    return par;
  }


  def changeTurn(turn: Boolean): Boolean = {
    if (turn) {
      return false;
    } else {
      return true;
    }
  }

  def checkValidQueen(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {
    var dx = Array(-1, -1, 1, 1, -1, 1, 0, 0)
    var dy = Array(-1, 1, -1, 1, 0, 0, -1, 1)
    var t = true;
    for (i <- 0 to 7) {
      var px = x1
      var py = y1;
      var t2 = true;
      for (j <- 0 to 7) {
        px += dx(i);
        py += dy(i);
        if (!(px < 0 || px > 7 || py < 0 || py > 7)) {
          if (t && px == x2 && py == y2 && (container(px)(py) == "" || container(x2)(y2) != "♚" && container(x2)(y2) != "♔" && color(x1)(y1) != color(x2)(y2)) && t2) {
            color(x2)(y2) = color(x1)(y1);
            color(x1)(y1) = "";
            container(x2)(y2) = container(x1)(y1);
            container(x1)(y1) = "";
            t = false;
          }
          if (container(px)(py) != "" && (px != x2 || py != y2)) {
            t2 = false;
          }

        }

      }
    }

    if (t) {
      println("Not valid")
    }
    var thisTurn = turn
    if (!t) {
      thisTurn = changeTurn(turn);
    }
    return generatePar(container, color, thisTurn)
  }

  def checkValidBishop(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {
    var dx = Array(-1, -1, 1, 1)
    var dy = Array(-1, 1, -1, 1)
    var t = true;
    for (i <- 0 to 3) {
      var px = x1
      var py = y1;
      var t2 = true;
      for (j <- 0 to 7) {
        px += dx(i);
        py += dy(i);
        if (!(px < 0 || px > 7 || py < 0 || py > 7)) {
          if (t && px == x2 && py == y2 && (container(px)(py) == "" || container(x2)(y2) != "♚" && container(x2)(y2) != "♔" && color(x1)(y1) != color(x2)(y2)) && t2) {
            color(x2)(y2) = color(x1)(y1);
            color(x1)(y1) = "";
            container(x2)(y2) = container(x1)(y1);
            container(x1)(y1) = "";
            t = false;
          }
          if (container(px)(py) != "" && (px != x2 || py != y2)) {
            t2 = false;
          }

        }

      }
    }

    if (t) {
      println("Not valid")
    }
    var thisTurn = turn
    if (!t) {
      thisTurn = changeTurn(turn);
    }
    return generatePar(container, color, thisTurn)
  }

  def checkValidKnight(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {
    var dx = Array(2, 2, -2, -2, 1, 1, -1, -1)
    var dy = Array(1, -1, -1, 1, 2, -2, 2, -2)
    var t = true;
    for (i <- 0 to 7) {
      var px = x1
      var py = y1;
      var t2 = true;
      px += dx(i);
      py += dy(i);
      if (!(px < 0 || px > 7 || py < 0 || py > 7)) {
        if (t && px == x2 && py == y2 && (container(px)(py) == "" || container(x2)(y2) != "♚" && container(x2)(y2) != "♔" && color(x1)(y1) != color(x2)(y2)) && t2) {
          color(x2)(y2) = color(x1)(y1);
          color(x1)(y1) = "";
          container(x2)(y2) = container(x1)(y1);
          container(x1)(y1) = "";
          t = false;
        }
        if (container(px)(py) != "" && (px != x2 || py != y2)) {
          t2 = false;
        }

      }

    }

    if (t) {
      println("Not valid")
    }
    var thisTurn = turn
    if (!t) {
      thisTurn = changeTurn(turn);
    }
    return generatePar(container, color, thisTurn)
  }

  def checkValidRock(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {
    var dx = Array(-1, 1, 0, 0)
    var dy = Array(0, 0, -1, 1)
    var t = true;
    for (i <- 0 to 3) {
      var px = x1
      var py = y1;
      var t2 = true;
      for (j <- 0 to 7) {
        px += dx(i);
        py += dy(i);
        if (!(px < 0 || px > 7 || py < 0 || py > 7)) {
          if (t && px == x2 && py == y2 && (container(px)(py) == "" || container(x2)(y2) != "♚" && container(x2)(y2) != "♔" && color(x1)(y1) != color(x2)(y2)) && t2) {
            color(x2)(y2) = color(x1)(y1);
            color(x1)(y1) = "";
            container(x2)(y2) = container(x1)(y1);
            container(x1)(y1) = "";
            t = false;
          }
          if (container(px)(py) != "" && (px != x2 || py != y2)) {
            t2 = false;
          }

        }

      }
    }

    if (t) {
      println("Not valid")
    }
    var thisTurn = turn
    if (!t) {
      thisTurn = changeTurn(turn);
    }
    return generatePar(container, color, thisTurn)
  }


  def checkValidKing(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {
    var dx = Array(1, 1, 1, 0, 0, -1, -1, -1)
    var dy = Array(1, -1, 0, -1, 1, 0, 1, -1)
    var t = true;
    for (i <- 0 to 3) {
      var px = x1
      var py = y1;
      var t2 = true;
      for (j <- 0 to 7) {
        px += dx(i);
        py += dy(i);
        if (!(px < 0 || px > 7 || py < 0 || py > 7)) {
          if (t && px == x2 && py == y2 && (container(px)(py) == "" || container(x2)(y2) != "♚" && container(x2)(y2) != "♔" && color(x1)(y1) != color(x2)(y2)) && t2) {
            color(x2)(y2) = color(x1)(y1);
            color(x1)(y1) = "";
            container(x2)(y2) = container(x1)(y1);
            container(x1)(y1) = "";
            t = false;
          }
          if (container(px)(py) != "" && (px != x2 || py != y2)) {
            t2 = false;
          }

        }

      }
    }

    if (t) {
      println("Not valid")
    }
    var thisTurn = turn
    if (!t) {
      thisTurn = changeTurn(turn);
    }
    return generatePar(container, color, thisTurn)
  }

  def checkValidPawn(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], color: Array[Array[String]], turn: Boolean): Array[Any] = {

    var t = 1;
    if (color(x1)(y1) == "b" && x1 == 1) {
      if (y1 == y2 && (x1 + 1 == x2 || x1 + 2 == x2)) {

        if (container(x2)(y2) == "" && !(x1 + 2 == x2 && color(x1 + 1)(y2) != "")) {
          t = 0;
        }
      }
    } else if (color(x1)(y1) == "b") {
      if (x1 + 1 == x2 && y1 + 1 == y2 && color(x2)(y2) == "w" && container(x2)(y2) != "♔") {
        if (x2 == 7) {
          t = 2;
        } else {
          t = 0;
        }

      } else if (x1 + 1 == x2 && y1 - 1 == y2 && color(x2)(y2) == "w" && container(x2)(y2) != "♔") {
        if (x2 == 7) {
          t = 2;
        } else {
          t = 0;
        }
      } else if (x1 + 1 == x2 && y1 == y2) {
        if (container(x2)(y2) == "") {
          if (x2 == 7) {
            t = 2;
          } else {
            t = 0;
          }
        }
      }
    } else if (color(x1)(y1) == "w" && x1 == 6) {
      if (y1 == y2 && (x1 - 1 == x2 || x1 - 2 == x2)) {
        if (container(x2)(y2) == "" && !(x1 - 2 == x2 && color(x1 - 1)(y2) != "")) {
          t = 0;
        }
      }
    } else if (color(x1)(y1) == "w") {
      if (x1 - 1 == x2 && y1 + 1 == y2 && color(x2)(y2) == "b" && container(x2)(y2) != "♚") {
        if (x2 == 0) {
          t = 2;
        } else {
          t = 0;
        }

      } else if (x1 - 1 == x2 && y1 - 1 == y2 && color(x2)(y2) == "b" && container(x2)(y2) != "♚") {
        if (x2 == 0) {
          t = 2;
        } else {
          t = 0;
        }
      } else if (x1 - 1 == x2 && y1 == y2) {
        if (container(x2)(y2) == "") {
          if (x2 == 0) {
            t = 2;
          } else {
            t = 0;
          }
        }
      }
    }

    if (t == 1) {
      println("Not valid")
    } else if (t == 0) {
      color(x2)(y2) = color(x1)(y1);
      color(x1)(y1) = ""
      container(x2)(y2) = container(x1)(y1);
      container(x1)(y1) = ""
    } else {
      if (color(x1)(y1) == "w") {
        color(x2)(y2) = color(x1)(y1);
        color(x1)(y1) = ""
        container(x2)(y2) = "♕";
        container(x1)(y1) = ""
      } else {
        color(x2)(y2) = color(x1)(y1);
        color(x1)(y1) = ""
        container(x2)(y2) = "♛";
        container(x1)(y1) = ""
      }
    }
    var thisTurn = turn
    if (t != 1) {
      thisTurn = changeTurn(turn);
    }
    return generatePar(container, color, thisTurn)

  }


}



