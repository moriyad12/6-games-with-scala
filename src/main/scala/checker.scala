import org.example.boarddrawer

object checker {

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
    def initChecker(): Array[Any] = {
      val container = Array(Array("", "♝", "", "♝", "", "♝", "", "♝", ""), Array("♝", "", "♝", "", "♝", "", "♝", "", "♝"), Array("", "♝", "", "♝", "", "♝", "", "♝", ""), Array("", "", "", "", "", "", "", "", ""), Array("", "", "", "", "", "", "", "", ""), Array("♟", "", "♟", "", "♟", "", "♟", "", "♟"), Array("", "♟", "", "♟", "", "♟", "", "♟", ""), Array("♟", "", "♟", "", "♟", "", "♟", "", "♟"))
      var par = new Array[Any](3)
      par(0) = container
      par(1) = true
      par(2) = true
      return par
    }

    def checkValid1(x: Int, y: Int, container: Array[Array[String]], turn: Boolean): Boolean = {
      if (x < 0 || x > 7 || y < 0 || y > 7) {
        return false
      }
      if (turn) {
        return container(x)(y) == "♟"
      }
      else {
        return container(x)(y) == "♝"
      }
    }


    def getValidMoves(x: Int, y: Int, board: Array[Array[String]], turn: Boolean, can: Boolean): Array[(Int, Int)] = {
      var arr = Array[(Int, Int)]()
      val n = board.length
      val m = board(0).length
      val dx = Array(1, 1)
      val dy = Array(-1, 1)
      var up = -1
      if (!turn) up = up * (-1)
      var inx = 0;
      while (inx < 2) {
        var nx = x + up
        var ny = y + dy(inx)
        val fx = x + up * 2
        val fy = y + dy(inx) * 2
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          val pos = board(nx)(ny)
          if (pos != "") {
            if (pos != board(x)(y)) {
              if (!(fx < 0 || fx > 7 || fy < 0 || fy > 7)) {
                if (board(fx)(fy) == "") {
                  arr = arr :+ (fx, fy)
                }
              }
            }
          }
          else if (can)
            arr = arr :+ (nx, ny)
        }
        inx += 1;
      }
      return arr
    }

    def check_valid2(xx: Int, yy: Int, container: Array[Array[String]], array: Array[(Int, Int)], turn: Boolean): Boolean = {
      val sz = array.length
      var inx = 0;
      while (inx < sz) {
        if (xx == array(inx)._1 && yy == array(inx)._2) return true
        inx += 1
      }
      return false
    }

    def do_it(x1: Int, y1: Int, x2: Int, y2: Int, container: Array[Array[String]], turn: Boolean, can: Boolean): (Boolean, Boolean) = {
      var mutableturn = turn
      var mutablecan = can
      if (Math.abs(x1 - x2) == 1) {
        mutableturn = mutableturn ^ true
      }
      else {
        val md1 = (x2 - x1) / 2 + x1
        val md2 = (y2 - y1) / 2 + y1
        container(md1)(md2) = ""
        mutablecan = false
        val zzz = getValidMoves(x2, y2, container, mutableturn, mutablecan).length
        //      println("one", x2, y2, zzz)
        if (zzz == 0) {
          //        println("two")
          mutableturn = mutableturn ^ true
          mutablecan = true
        }
      }
      container(x2)(y2) = container(x1)(y1)
      container(x1)(y1) = ""
      return (mutableturn, mutablecan)
    }


    def checkerController(par: Array[Any], Input: Array[Int]): Array[Any] = {
      var container = par(0).asInstanceOf[Array[Array[String]]]
      var turn = par(1).asInstanceOf[Boolean]
      var can = par(2).asInstanceOf[Boolean]
      val r1 = Input(0)
      val c1 = Input(1)
      val r2 = Input(2)
      val c2 = Input(3)
      val value = Input(4)
      //game
      //logic

      if (!checkValid1(r1, c1, container, turn)) {
        println("Not valid  First  ")
        return par
      }
      val pairs = getValidMoves(r1, c1, container, turn, can)
      if (!check_valid2(r2, c2, container, pairs, turn)) {
        println("Not valid second  ")
        return par
      }
      var z = do_it(r1, c1, r2, c2, container, turn, can)
      turn = z._1
      can = z._2
      par(0) = container
      par(1) = turn
      par(2) = can
      return par
    }

  }
