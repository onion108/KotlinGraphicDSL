package org.onion27.swingdsl

import java.awt.*
import java.text.AttributedCharacterIterator

class KJPainter(painter: Graphics) {
    private val graphics: Graphics = painter
    var origin: Point = Point(0, 0)
    var baseColor: Color = Color.RED
    fun rect(r: KJGeneralShape.() -> Unit) {
        var rect = KJGeneralShape()
        rect.fillColor = baseColor
        rect.strokeColor = baseColor
        rect.r()
        if(rect.shouldFill) {
            graphics.color = rect.fillColor
            graphics.fillRect(rect.x + origin.x, rect.y + origin.y, rect.width, rect.height)
            graphics.color = rect.strokeColor
            graphics.drawRect(rect.x + origin.x, rect.y + origin.y, rect.width, rect.height)
        } else {
            graphics.color = rect.strokeColor
            graphics.drawRect(rect.x + origin.x, rect.y + origin.y, rect.width, rect.height)
        }
    }
    fun oval(r: KJGeneralShape.() -> Unit) {
        var rect = KJGeneralShape()
        rect.fillColor = baseColor
        rect.strokeColor = baseColor
        rect.r()
        if(rect.shouldFill) {
            graphics.color = rect.fillColor
            graphics.fillOval(rect.x + origin.x, rect.y + origin.y, rect.width, rect.height)
            graphics.color = rect.strokeColor
            graphics.drawOval(rect.x + origin.x, rect.y + origin.y, rect.width, rect.height)
        } else {
            graphics.color = rect.strokeColor
            graphics.drawOval(rect.x + origin.x, rect.y + origin.y, rect.width, rect.height)
        }
    }
    fun arc(block: KJArc.() -> Unit) {
        var arc = KJArc()
        arc.fillColor = baseColor
        arc.strokeColor = baseColor
        arc.block()
        if (arc.shouldFill) {
            graphics.color = arc.fillColor
            graphics.fillArc(arc.x + origin.x, arc.y + origin.y, arc.width, arc.height, arc.start, arc.degree)
            graphics.color = arc.strokeColor
            graphics.drawArc(arc.x + origin.x, arc.y + origin.y, arc.width, arc.height, arc.start, arc.degree)
        } else {
            graphics.color = arc.strokeColor
            graphics.drawArc(arc.x + origin.x, arc.y + origin.y, arc.width, arc.height, arc.start, arc.degree)
        }
    }
    fun text(content: String, x: Int = 0 + origin.x, y: Int = 0 + origin.y, color: Color = Color.BLACK) {
        graphics.color = color
        graphics.drawString(content, x + origin.x, y + origin.y)
    }
    fun text(content: AttributedCharacterIterator, x: Int = 0, y: Int = 0, color: Color = Color.BLACK) {
        graphics.color = color
        graphics.drawString(content, x + origin.x, y + origin.y)
    }
    fun text(args: KJTextPaintData.() -> Unit) {
        var data = KJTextPaintData()
        data.args()
        if(data.attributedContent == null) {
            text(
                data.content,
                x = data.x,
                y = data.y,
                color = data.color
            )
        } else {
            text(
                data.attributedContent!!,
                x = data.x,
                y = data.y,
                color = data.color
            )
        }
    }
    fun rawCode(code: Graphics.(KJPainter) -> Unit) {
        graphics.code(this)
    }
    fun raw2D(code: Graphics2D.(KJPainter) -> Unit) {
        if(graphics is Graphics2D) {
            graphics.code(this)
        } else {
            println("[WARNING] Cannot cast to java.awt.Graphics2D")
        }
    }
    fun group(x: Int = 0, y: Int = 0, primaryColor: Color = baseColor, painter: KJPainter.() -> Unit) {
        val anotherPainter = KJPainter(graphics)
        anotherPainter.origin = Point(x, y)
        anotherPainter.baseColor = primaryColor
        anotherPainter.painter()
    }
}