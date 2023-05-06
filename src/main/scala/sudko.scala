import scala.util.Random

object sudko {
  def initSudko(): Array[Any] = {
    val size = 9
    val iscircle = false
    val canremove = Array.ofDim[Boolean](9, 9)
    val container=generate(canremove)
    val colors = Array(Array("white", "gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray", "white"), Array("gray", "white", "gray", "white", "gray", "white", "gray", "white", "gray"), Array("white", "gray", "white", "gray", "white", "gray", "white", "gray", "white"))
    var par = new Array[Any](6)
    par(0) = size
    par(1) = iscircle
    par(2) = container
    par(3) = colors
    par(4) = true
    par(5)=canremove
    return par
  }
  def sudkoController(par: Array[Any], Input: Array[Int]): Array[Any] = {
    var container = par(2).asInstanceOf[Array[Array[String]]]
    var colors = par(3).asInstanceOf[Array[Array[String]]]
    var turn = par(4).asInstanceOf[Boolean]
    val r1 = Input(0)
    val c1 = Input(1)
    val r2 = Input(2)
    val c2 = Input(3)
    val value = Input(4).toString
    val canremove=par(5).asInstanceOf[Array[Array[Boolean]]]
    //game logic
    if(Input(4)==0)
      { if(canremove(r1)(c1))
      container(r1)(c1)=""
      else println("Not valid")}
    else if(Input(4)>9)
      println("Not valid")
    else if(Input(4)<0)
      println("Not valid")
    else if(container(r1)(c1)!="")
      println("Not valid")
    else if(!Row(r1, value,container))
      println("Not valid")
    else if (!Col(c1, value,container))
      println("Not valid")
    else if(!Box(r1 - r1 % 3, c1 - c1 % 3, value,container))
    println("Not valid")
    else container(r1)(c1)=value
    par(2) = container
    par(3) = colors
    par(4)=turn
    return par
  }

  def Box(rowStart: Int, colStart: Int, num: String,mat:Array[Array[String]]): Boolean = {
    var i = 0
    while ( {
      i < 3
    }) {
      var j = 0
      while ( {
        j < 3
      }) {
        if (mat(rowStart + i)(colStart + j) == num) return false
        j += 1
      }
      i += 1
    }
    true
  }

  def Row(i: Int, num: String,mat:Array[Array[String]]): Boolean = {
    var j = 0
    while ( {
      j < 9
    }) {
      if (mat(i)(j) == num) return false
      j += 1
    }
    true
  }

  // check in the row for existence
  def Col(j: Int, num: String,mat:Array[Array[String]]): Boolean = {
    var i = 0
    while ( {
      i < 9
    }) {
      if (mat(i)(j) == num) return false
      i += 1
    }
    true
  }
  def generate(canremove:Array[Array[Boolean]]) : Array[Array[String]]={
    val board = Array.ofDim[Int](9, 9)
    fillDiagonalBoxes(board)
    fillRemainingCells(board, 0, 3)
    return removeKDigits(board.map(_.map(_.toString)),canremove)
  }
  def removeKDigits(m:Array[Array[String]],canremove:Array[Array[Boolean]]): Array[Array[String]] = {
    var count = 40
   var mat=m
    while (count != 0) {
      // extract coordinates i and j
      val i = scala.util.Random.nextInt(9)
      val j = scala.util.Random.nextInt(9)
      if (mat(i)(j) !="") {
        count -= 1
        mat(i)(j) =""
        canremove(i)(j)=true
      }}
      return mat
    }
  def fillDiagonalBoxes(board: Array[Array[Int]]): Unit = {
    for (i <- 0 until 9 by 3) {
      fillBox(board, i, i)
    }
  }

  def fillBox(board: Array[Array[Int]], row: Int, col: Int): Unit = {
    val lst: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nums = Random.shuffle(lst)
    var index = 0
    for (i <- row until row + 3) {
      for (j <- col until col + 3) {
        board(i)(j) = nums(index)
        index += 1
      }
    }
  }

  def fillRemainingCells(board: Array[Array[Int]], r: Int, c: Int): Boolean = {
    var row = r
    var col = c
    if (col >= 9 && row < 8) {
      return fillRemainingCells(board, row + 1, 0)
    }
    if (row >= 9) {
      return true
    }
    if (row < 3) {
      if (col < 3) {
        col = 3
      }
    } else if (row < 6) {
      if (col == (row / 3) * 3) {
        col += 3
      }
    } else {
      if (col == 6) {
        col = 0
        row += 1
        if (row >= 9) {
          return true
        }
      }
    }
    for (i <- 1 to 9) {
      if (isSafe(board, row, col, i)) {
        board(row)(col) = i
        if (fillRemainingCells(board, row, col + 1)) {
          return true
        }
        board(row)(col) = 0
      }
    }
    false
  }

  def isSafe(board: Array[Array[Int]], row: Int, col: Int, num: Int): Boolean = {
    for (i <- 0 until 9) {
      if (board(row)(i) == num || board(i)(col) == num) {
        return false
      }
    }
    val boxRow = row - row % 3
    val boxCol = col - col % 3
    for (i <- boxRow until boxRow + 3) {
      for (j <- boxCol until boxCol + 3) {
        if (board(i)(j) == num) {
          return false
        }
      }
    }
    true
  }


}
