package org.example

import java.awt._
import java.awt.event._
import javax.swing._
import java.lang.Integer.parseInt


class boarddrawer(val size2: Any, val iscircle: Boolean, val container: Array[Array[String]], val color: Array[Array[String]]) extends JFrame with MouseListener with MouseMotionListener {
  this.click = 0
  val size1 :Int =size2.asInstanceOf[Int]
  private[example] var r1 = 0
  private[example] var c1 = 0
  private[example] var r2 = 0
  private[example] var c2 = 0
  private[example] var content = "0"
  private[example] var click = 0
  val boardSize = new Dimension(80 * size1, 80 * size1 + 30)
  var layeredPane = new JLayeredPane
  getContentPane.add(layeredPane)
  layeredPane.setPreferredSize(boardSize)
  layeredPane.addMouseListener(this)
  layeredPane.addMouseMotionListener(this)
  val text = new JPanel
  var Baoard = new JPanel
  val textField = new JTextField("0")
  textField.addKeyListener(new KeyAdapter() {
    override def keyReleased(event: KeyEvent): Unit = {
      content = textField.getText
    }
  })
  text.add(textField)
  layeredPane.add(text, JLayeredPane.DRAG_LAYER)
  layeredPane.add(Baoard, JLayeredPane.DEFAULT_LAYER)
  text.setLayout(new GridLayout(1, 1))
  text.setPreferredSize(boardSize)
  text.setBounds(0, 0, boardSize.width, 30)
  Baoard.setLayout(new GridLayout(size1, size1))
  Baoard.setPreferredSize(new Dimension(80 * size1, 80 * size1))
  Baoard.setBounds(0, 30, boardSize.width, boardSize.height - 30)
  for (i <- 0 until size1 * size1) {
    if (!iscircle) {
      val addBtn = new JButton(container(i / size1)(i % size1))
      addBtn.setFont(new Font("", Font.PLAIN, 40))
      addBtn.setBounds(1, 1, 30, 25)
      addBtn.setBackground(chosecolor(color(i / size1)(i % size1)))
      val finalI = i
      addBtn.addActionListener(new ActionListener() {
        override def actionPerformed(e: ActionEvent): Unit = {
          handle(finalI)
        }
      })
      Baoard.add(addBtn)
    }
    else {
      val addBtn = new JButton
      addBtn.setBounds(1, 1, 30, 25)
      addBtn.setBorder(new RoundedBorder(100))
      addBtn.setBackground(chosecolor(color(i / size1)(i % size1)))
      val finalI = i
      addBtn.addActionListener(new ActionListener() {
        override def actionPerformed(e: ActionEvent): Unit = {
          handle(finalI)
        }
      })
      Baoard.add(addBtn)
    }
  }


  def input: Array[Int] = {
    val input = Array(r1, c1, r2, c2, content.toInt)
    input
  }


  def handle(i: Int): Unit = {
    if (click==0) {
      r1 = i / size1
      c1 = i % size1
      click = 1
    }
    else {
      r2 = i / size1
      c2 = i % size1
      click = 2
    }
  }
  def inputReady(): Int={
  return click
  }
  def chosecolor(c: String): Color = if (c eq "white") Color.white
  else if (c eq "gray") Color.gray
  else if (c eq "red") Color.RED
  else Color.blue

  def drawer(par: Array[Any]): Unit = {
    updategrid(par(0), par(1).asInstanceOf[Boolean], par(2).asInstanceOf[Array[Array[String]]], par(3).asInstanceOf[Array[Array[String]]])
  click=0
  }
    def updategrid(size3: Any, iscircle: Boolean, container: Array[Array[String]], color: Array[Array[String]]): Unit = {
      val size :Int =size3.asInstanceOf[Int]
    for (i <- 0 until size * size) {
      if (!iscircle) {
        val addBtn = Baoard.getComponent(i).asInstanceOf[JButton]
        addBtn.setText(container(i / size)(i % size))
        addBtn.setFont(new Font("", Font.PLAIN, 40))
        addBtn.setBounds(1, 1, 30, 25)
        addBtn.setBackground(chosecolor(color(i / size)(i % size)))
      }
      else {
        val addBtn = Baoard.getComponent(i).asInstanceOf[JButton]
        addBtn.setBackground(chosecolor(color(i / size)(i % size)))

      }
    }
  }

  override def mousePressed(e: MouseEvent): Unit = {
  }

  override def mouseDragged(me: MouseEvent): Unit = {
  }

  override def mouseReleased(e: MouseEvent): Unit = {
  }

  override def mouseClicked(e: MouseEvent): Unit = {
  }

  override def mouseMoved(e: MouseEvent): Unit = {
  }

  override def mouseEntered(e: MouseEvent): Unit = {
  }

  override def mouseExited(e: MouseEvent): Unit = {
  }
}
     