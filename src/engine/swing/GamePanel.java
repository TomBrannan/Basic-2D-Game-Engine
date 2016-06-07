package engine.swing;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A JPanel used for drawing SwingGames.
 *
 * @author Tom
 */
public class GamePanel extends JPanel {

    private final SwingGame game; //The game to be displayed

    /**
     * Constructor: initializes the game
     *
     * @param game The game for this panel.
     */
    public GamePanel(SwingGame game) {
        this.game = game;
    }

    /**
     * Overriding of the JPanel paint method. Simply draws the graphics of the
     * game.
     *
     * @param g The graphics object.
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(game.getImage(), 0, 0, this);
    }

    /**
     * Overriding of the JPanel getPreferredSize method. Determines the
     * appropriate size for this panel by asking for the game's size.
     *
     * @return The appropriate size for this panel, according to the game.
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(game.getWidth(), game.getHeight());
    }
}
