package org.onion27.swingdsl

import java.awt.Graphics
import javax.swing.JPanel

class KJPaintView : JPanel() {
    private var onEveryPaint: KJPainter.() -> Unit = {}

    override fun paint(g: Graphics?) {
        KJPainter(g ?: return).onEveryPaint()
    }

    fun draw(block: KJPainter.() -> Unit) {
        onEveryPaint = block
    }
}