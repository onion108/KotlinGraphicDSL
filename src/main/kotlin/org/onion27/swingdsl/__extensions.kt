package org.onion27.swingdsl

import java.awt.Dimension
import javax.swing.JFrame

fun JFrame.size(s: Dimension) {
    this.size = s
}

fun JFrame.show() {
    this.isVisible = true
}
fun JFrame.hide() {
    this.isVisible = false
}
fun JFrame.op() {
    this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
}
fun JFrame.deop() {
    this.defaultCloseOperation = JFrame.HIDE_ON_CLOSE
}


