package engine.swing;

import engine.Game;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Represents a simple Game using java.awt, intended for use in Swing
 * applications. This class extends the base Game class and adds graphical
 * capability using BufferedImage and Graphics2D objects.
 *
 * @author Tom
 */
public abstract class SwingGame extends Game {

    protected final BufferedImage image;
    protected final Graphics2D g2;
    protected Color backgroundColor = new Color(120, 170, 240);

    /**
     * Constructor: Initializes necessary information about this game.
     *
     * @param width The default width of the game's drawing area.
     * @param height The default height of the game's drawing area.
     * @param resizable Whether or not this game allows for resizing.
     */
    public SwingGame(int width, int height, boolean resizable) {
        super(width, height, resizable);
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2 = image.createGraphics();
    }

    /**
     * Constructor: Initializes necessary information about this game, and
     * allows for setting a title.
     *
     * @param title The title of the game.
     * @param width The default width of the game's drawing area.
     * @param height The default height of the game's drawing area.
     * @param resizable Whether or not this game allows for resizing.
     */
    public SwingGame(String title, int width, int height, boolean resizable) {
        super(title, width, height, resizable);
        this.width = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2 = image.createGraphics();
    }

    /**
     * Overriding of the clearScene method: simply paints over the entire scene
     * with a solid color (the background color).
     */
    @Override
    public void clearScene() {
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, width, height);
    }

    /**
     * @return The image (current frame) of the Game.
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Overriding of the shutdown() function: releases the Graphics2D object.
     * Future implementations of this class should call this before doing their
     * own shutdown logic. May need to change some stuff to enforce this.
     */
    @Override
    public void shutdown() {
        g2.dispose();
    }

}
