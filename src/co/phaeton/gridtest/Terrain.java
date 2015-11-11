package co.phaeton.gridtest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum Terrain {

    OCEAN ("/res/ocean.png"),
    GRASS ("/res/grass.png");

    BufferedImage image;

    Terrain(String resourceUrl) {
        this.image = loadImage(resourceUrl);
    }

    private BufferedImage loadImage(String url) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

}
