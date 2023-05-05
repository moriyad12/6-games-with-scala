package org.example

import javax.swing.border.Border
import java.awt._


class RoundedBorder private[example](var radius: Int) extends Border {
  override def getBorderInsets(c: Component) = new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius)

  override def isBorderOpaque = true

  override def paintBorder(c: Component, g: Graphics, x: Int, y: Int, width: Int, height: Int): Unit = {
    g.drawRoundRect(x, y, width - 1, height - 1, radius, radius)
  }
}