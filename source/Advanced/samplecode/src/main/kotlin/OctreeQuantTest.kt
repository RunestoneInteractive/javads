import javax.swing.JFrame
import javax.swing.WindowConstants

fun main() {
    print("File name: ")
    val filename = readln()
    val f0 = JFrame("Original")
    f0.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
    val img0 = ImageComponent(filename)
    f0.add(img0)
    f0.pack()
    f0.isVisible = true

    val f1 = JFrame("Simple Quantize")
    f1.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
    val img1 = ImageComponent(filename)
    simpleQuant(img1.image)
    f1.add(img1)
    f1.pack()
    f1.isVisible = true

    val f2 = JFrame("Octree Quantize")
    f2.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE
    val img2 = ImageComponent(filename)
    octreeQuant(img2.image)
    f2.add(img2)
    f2.pack()
    f2.isVisible = true
}
