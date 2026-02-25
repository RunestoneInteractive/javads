import java.awt.image.BufferedImage
import javax.swing.JFrame
import javax.swing.WindowConstants

fun simpleQuant(img: BufferedImage) {
    for (row in 0..<img.height) {
        for (col in 0..<img.width) {
            val argb = img.getRGB(col, row)
            var r = (argb shr 16) and 0xff
            var g = (argb shr 8) and 0xff
            var b = argb and 0xff
            r = r / 36 * 36
            g = g / 42 * 42
            b = b / 42 * 42
            img.setRGB(col, row, (r shl 16 or (g shl 8) or b))
        }
    }
}

fun main() {
    print("File name: ")
    val filename = readln()
    val f = JFrame("Simple Quantize")
    f.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
    val img = ImageComponent(filename)
    simpleQuant(img.image)
    f.add(img)
    f.pack()
    f.isVisible = true
}