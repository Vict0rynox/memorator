package org.victorynox.memorator.domain;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.UUID;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Entity
 *
 * @author victorynox
 * @version 0.1
 */
@Entity
public class Image {

    @Column(insertable = false, updatable = false)
    private URL url;
    /**
     * Unique image identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    /**
     * Image sources
     */
    transient private BufferedImage bufferedImage;

    protected Image() {
    }

    /**
     * Load image by uri
     */
    public Image(URL url) throws IOException {
        this.url = url;
        bufferedImage = ImageIO.read(url);
    }

    /**
     * Create new image
     *
     * @param width  image
     * @param height image
     */
    public Image(int width, int height) {
        bufferedImage = new BufferedImage(width, height, TYPE_INT_ARGB);
    }

    /**
     * @return image width
     */
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    /**
     * @return image height
     */
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    /**
     * Add phrase on image
     *
     * @param point  left top text position
     * @param phrase same test
     */
    public void addPhrase(Point point, Phrase phrase) {
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.BLACK);//Default color is black
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 10));

        graphics2D.drawString(phrase.getPhrase(), point.getX(), point.getY());

        graphics2D.dispose();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id) &&
                Objects.equals(bufferedImage, image.bufferedImage);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, bufferedImage);
    }
}
