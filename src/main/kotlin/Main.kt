import org.onion27.swingdsl.KJPaintView
import org.onion27.swingdsl.KJPainter
import java.awt.Color
import javax.swing.JFrame

fun main(args: Array<String>) {
    // Testing Codes here
    val mf = JFrame()
    val painter = KJPaintView()
    mf.add(painter)
    painter.draw {
        rect {
            x = 3
            y = 3
            width = 200
            height = 200
            shouldFill = true
            fillColor = Color.BLUE
        }
        raw2D {
            drawString("Hello World", 100, 100)
        }
        text(
            "Hello World in RED",
            x = 200,
            y = 100
        )
        arc {
            x = 0
            y = 0
            height = 100
            width = 100
            fillColor = Color.CYAN
            shouldFill = true
            strokeColor = fillColor
        }
    }
    mf.isVisible = true
}