import java.awt.image.BufferedImage;

public class Image {
    private final int width;
    private final int height;
    private final int[] pixels;

    public Image(BufferedImage image) {
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixels = image.getRGB(0, 0, this.width, this.height, null, 0, this.width);
    }

    public Image(int width, int height,  int[] pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }

}