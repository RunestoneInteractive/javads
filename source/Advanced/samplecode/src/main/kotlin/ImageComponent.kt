import java.awt.Dimension
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JComponent

class ImageComponent(filename: String) : JComponent() {
    var image: BufferedImage = ImageIO.read(File(filename))

    override fun paint(g: Graphics) {
        g.drawImage(image, 0, 0, null)
    }

    override fun getPreferredSize(): Dimension {
        return Dimension(
            image.getWidth(null),
            image.getHeight(null)
        )
    }
}