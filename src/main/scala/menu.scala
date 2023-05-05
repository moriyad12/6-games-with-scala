package org.example

import org.example.RoundedBorder
import javax.swing._
import java.awt._
import java.awt.event._


class menu() extends JFrame with MouseListener with MouseMotionListener {
  val boardSize = new Dimension(800, 800)
  var layeredPane = new JLayeredPane
  var name=""
  getContentPane.add(layeredPane)
  layeredPane.setPreferredSize(boardSize)
  layeredPane.addMouseListener(this)
  layeredPane.addMouseMotionListener(this)
  var Baoard = new JPanel
  layeredPane.add(Baoard, JLayeredPane.DEFAULT_LAYER)
  Baoard.setLayout(new GridLayout(6, 1))
  Baoard.setPreferredSize(boardSize)
  Baoard.setBounds(0, 0, boardSize.width, boardSize.height)
  val addBtn = new JButton("Tic-Tac-Toe")
  addBtn.setFont(new Font("", Font.PLAIN, 40))
  addBtn.setBounds(1, 1, 30, 25)
  addBtn.setBackground(Color.gray)
  addBtn.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      name="tic"

    }
  })
  Baoard.add(addBtn)
  val addBtn1 = new JButton("Connect-4")
  addBtn1.setFont(new Font("", Font.PLAIN, 40))
  addBtn1.setBounds(1, 1, 30, 25)
  addBtn1.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
     name="connect"
    }
  })
  addBtn1.setBackground(Color.gray)
  Baoard.add(addBtn1)
  val addBtn2 = new JButton("Sudoku")
  addBtn2.setFont(new Font("", Font.PLAIN, 40))
  addBtn2.setBounds(1, 1, 30, 25)
  addBtn2.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
     name="sudko"
    }
  })
  addBtn2.setBackground(Color.gray)
  Baoard.add(addBtn2)
  val addBtn3 = new JButton("Checkers")
  addBtn3.setFont(new Font("", Font.PLAIN, 40))
  addBtn3.setBounds(1, 1, 30, 25)
  addBtn3.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
     name="checkers"
    }
  })
  addBtn3.setBackground(Color.gray)
  Baoard.add(addBtn3)
  val addBtn4 = new JButton("8-Queens")
  addBtn4.setFont(new Font("", Font.PLAIN, 40))
  addBtn4.setBounds(1, 1, 30, 25)
  addBtn4.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
     name="queen"
    }
  })
  addBtn4.setBackground(Color.gray)
  Baoard.add(addBtn4)
  val addBtn5 = new JButton("chess")
  addBtn5.setFont(new Font("", Font.PLAIN, 40))
  addBtn5.setBounds(1, 1, 30, 25)
  addBtn5.addActionListener(new ActionListener() {
    override def actionPerformed(e: ActionEvent): Unit = {
      name="chess"
    }
  })
  addBtn5.setBackground(Color.gray)
  Baoard.add(addBtn5)
  def gamename(): String ={

   return name;
  }

  def creategame( par :Array[Any]): boarddrawer = {
    val frame = new boarddrawer(par(0), par(1).asInstanceOf[Boolean],par(2).asInstanceOf[Array[Array[String]]],par(3).asInstanceOf[Array[Array[String]]])
    frame.pack()
    frame.setResizable(true)
    frame.setLocationRelativeTo(null)
    frame.setVisible(true)
    return frame;
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