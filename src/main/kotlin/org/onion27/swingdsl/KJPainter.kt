package org.onion27.swingdsl

import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.text.AttributedCharacterIterator

class KJPainter {
    private val graphics: Graphics
    constructor(painter: Graphics) {
        graphics = painter
    }
    fun rect(r: KJGeneralShape.() -> Unit) {
        var rect = KJGeneralShape()
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
    fun oval(r: KJGeneralShape.() -> Unit) {
        var rect = KJGeneralShape()
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
    fun arc(block: KJArc.() -> Unit) {
        var arc = KJArc()
        arc.block()
        if (arc.shouldFill) {
            graphics.color = arc.fillColor
            graphics.fillArc(arc.x, arc.y, arc.width, arc.height, arc.start, arc.degree)
            graphics.color = arc.strokeColor
            graphics.drawArc(arc.x, arc.y, arc.width, arc.height, arc.start, arc.degree)
        } else {
            graphics.color = arc.strokeColor
            graphics.drawArc(arc.x, arc.y, arc.width, arc.height, arc.start, arc.degree)
        }
    }
    fun text(content: String, x: Int = 0, y: Int = 0, color: Color = Color.BLACK) {
        graphics.color = color
        graphics.drawString(content, x, y)
    }
    fun text(content: AttributedCharacterIterator, x: Int = 0, y: Int = 0, color: Color = Color.BLACK) {
        graphics.color = color
        graphics.drawString(content, x, y)
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