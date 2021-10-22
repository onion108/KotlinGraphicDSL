import org.onion27.swingdsl.KJPaintView
import org.onion27.swingdsl.KJPainter
import java.awt.Color
import java.awt.Color.RED
import javax.swing.JFrame

fun main(args: Array<String>) {
    // Testing Codes here
    val mf = JFrame()
    val painter = KJPaintView()
    mf.add(painter)
    painter.draw {
        group(x = 0, y = 0) {
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
            text {
                content = "Hello World in RED"
                x = 200
                y = 200
                color = RED
            }
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
        group(x = 10, y = 10, primaryColor = Color.BLACK) {
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
            text {
                content = "Hello World in RED"
                x = 200
                y = 200
                color = RED
            }
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
    }
    mf.isVisible = true
}