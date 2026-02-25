
import java.awt.image.BufferedImage

fun octreeQuant(img: BufferedImage) {
    val w = img.width
    val h = img.height

    val ot: Octree = Octree()
    for (row in 0..<h) {
        for (col in 0..<w) {
            val argb = img.getRGB(col, row)
            val r = (argb shr 16) and 0xff
            val g = (argb shr 8) and 0xff
            val b = argb and 0xff
            ot.insert(r, g, b)
        }
    }

    ot.reduce(256)

    for (row in 0..<h) {
        for (col in 0..<w) {
            val argb = img.getRGB(col, row)
            val r = (argb shr 16) and 0xff
            val g = (argb shr 8) and 0xff
            val b = argb and 0xff

            val newRgb = ot.find(r, g, b)!!

            img.setRGB(
                col, row, (newRgb.red shl 16 or (
                        newRgb.green shl 8) or newRgb.blue)
            )
        }
    }
}
