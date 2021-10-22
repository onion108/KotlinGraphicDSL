package org.onion27.swingdsl

import java.awt.Color
import java.text.AttributedCharacterIterator

class KJTextPaintData {
    var x: Int = 0
    var y: Int = 0
    var color: Color = Color.BLACK
    var content: String = "[DEFAULT CONTENT]"
    // If it's not null, we'll use this property instead of content
    var attributedContent: AttributedCharacterIterator? = null
}