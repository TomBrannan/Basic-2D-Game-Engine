package engine;

import java.util.Random;

/**
 * Represents a basic game. All games have width, height, and may or may not be
 * resized. Almost all games use random number generation, so a generator is
 * given to all games.
 *
 * To create a Game, extend this class and provide graphical functionality.
 *
 * @author Tom
 */
public abstract class Game {

    protected int width, height;  //The width and height of this game
    protected boolean resizable;  //Whether it can be resized
    protected final Random rand;  //The random number generator
    protected String title; //The title of this game

    /**
     * Abstract constructor: initializes basic information about the Game.
     *
     * @param title The title of the game.
     * @param width The width of the game's display resolution, in pixels.
     * @param height The height of the game's display resolution, in pixels.
     * @param resizable True if this game allows the display to be resized,
     * false if not.
     */
    public Game(String title, int width, int height, boolean resizable) {
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        this.title = title;
        rand = new Random();
    }

    /**
     * Abstract constructor: initializes basic information about the Game.
     *
     * @param width The width of the game's display resolution, in pixels.
     * @param height The height of the game's display resolution, in pixels.
     * @param resizable True if this game allows the display to be resized,
     * false if not.
     */
    public Game(int width, int height, boolean resizable) {
        this.width = width;
        this.height = height;
        this.resizable = resizable;
        rand = new Random();
    }

    /**
     * Iterates the game forward by one frame. All logic (collision, position,
     * etc) happens in this method. The input passed is used for interpreting
     * user input.
     *
     * @param input The state of the mouse and keyboard at this instant in time.
     */
    public abstract void update(Input input);

    /**
     * Initialize all necessary resources (Database connections, file reading,
     * etc) here. Stuff in startup should be independent of the Game object
     * being created The abstract GameLoop will always call this method once,
     * before updates start.
     */
    public abstract void startup();

    /**
     * Destroy or free up any resources here. (Close streams and connections,
     * etc.) The abstract GameLoop will always call this method once, when the
     * stop() method is called.
     */
    public abstract void shutdown();

    /**
     * Render the current graphics of your game here (for example, by drawing to
     * a BufferedImage) This method will be called by the abstract GameLoop at
     * most once per update().
     */
    public abstract void drawScene();

    /**
     * Clear the current graphics of your game here. This will redraw your
     * graphics to prepare for game entities to be drawn. Usually this just
     * means painting a background image or color. This method should be called
     * once at the beginning of each drawScene() call.
     */
    public abstract void clearScene();

    /**
     * Get the title of this game (e.g. "Space Invaders")
     *
     * @return The game's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of this game (e.g. "Asteroids")
     *
     * @param title The desired title for this game.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the width of this game.
     *
     * @return The width of this game.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets this Game's width.
     *
     * @param width The desired width for this Game.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Get the height of this Game.
     *
     * @return The height of this Game.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of this Game.
     *
     * @param height The desired height for this Game.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Returns whether or not this Game may be resized.
     *
     * @return true if this Game can be resized, false otherwise.
     */
    public boolean isResizable() {
        return resizable;
    }

    /**
     * Sets the Game's resizability.
     *
     * @param resizable true if the Game should be able to resize, false
     * otherwise.
     */
    public void setResizable(boolean resizable) {
        this.resizable = resizable;
    }

}
