package org.onion27.swingdsl

import java.awt.Graphics
import java.awt.Graphics2D

class KJPainter {
    private val graphics: Graphics
    constructor(painter: Graphics) {
        graphics = painter
    }
    fun rect(r: KJRectangle.() -> Unit) {
        var rect = KJRectangle()
        rect.r()
        if(rect.shouldFill) {
            graphics.color = rect.fillColor
            graphics.fillRect(rect.x, rect.y, rect.width, rect.height)
            graphics.color = rect.strokeColor
            graphics.drawRect(rect.x, rect.y, rect.width, rect.height)
        } else {
            graphics.color = rect.strokeColor
            graphics.drawRect(rect.x, rect.y, rect.width, rect.height)
        }
    }
    fun oval(r: KJRectangle.() -> Unit) { // Just too lazy to change "KJRectangle" to "KJOval" [And also it's internal LMAO]
        var rect = KJRectangle()
        rect.r()
        if(rect.shouldFill) {
            graphics.color = rect.fillColor
            graphics.fillOval(rect.x, rect.y, rect.width, rect.height)
            graphics.color = rect.strokeColor
            graphics.drawOval(rect.x, rect.y, rect.width, rect.height)
        } else {
            graphics.color = rect.strokeColor
            graphics.drawOval(rect.x, rect.y, rect.width, rect.height)
        }
    }
    fun rawCode(code: Graphics.() -> Unit) {
        graphics.code()
    }
    fun raw2D(code: Graphics2D.() -> Unit) {
        if(graphics is Graphics2D) {
            graphics.code()
        } else {
            println("[WARNING] Cannot cast to java.awt.Graphics2D")
        }
    }
}