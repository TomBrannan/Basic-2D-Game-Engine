package engine.swing;

import engine.Input;
import engine.GameLoop;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 * Represents a simple 2D game engine which uses javax.swing components.
 *
 * @author Tom
 */
public class SwingGameEngine extends GameLoop {

    private final SwingGame game;
    private final JFrame frame;
    private final GamePanel panel;
    private final Input input;

    /**
     * Constructor. Creates and displays a JFrame containing a GamePanel.
     * Initializes the frame and panel with appropriate key and mouse listeners.
     *
     * @param game The game that is being played.
     * @param maxSkippedFrames The maximum allowed frames to skip before forcing
     * a draw.
     * @param maxTimeDiff The maximum allowed time difference between frames, in
     * seconds.
     */
    public SwingGameEngine(SwingGame game, int maxSkippedFrames, double maxTimeDiff) {
        super(maxSkippedFrames, maxTimeDiff);
        this.game = game;

        input = new Input();
        frame = new JFrame();
        panel = new GamePanel(game);

        //Need to handle at some point: add listeners for when window is moved
        //and so on, otherwise the keys get messed up.  Currently can be 
        //reset by minimizing/maximizing the window.
        frame.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                input.getKeyboard().releaseAllKeys();
                input.getMouse().releaseAllButtons();
            }
        });

        frame.addKeyListener(input.getKeyboardManager());

        panel.addMouseListener(input.getMouseManager());
        panel.addMouseMotionListener(input.getMouseManager());
        panel.addMouseWheelListener(input.getMouseManager());

        frame.setSize(game.getWidth(), game.getHeight());
        frame.setResizable(game.isResizable());
        frame.setTitle(game.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Overriding of the startup method: calls the game's startup method.
     */
    @Override
    public void startup() {
        game.startup();
    }

    /**
     * Overriding of the shutdown method: calls the game's shutdown method.
     */
    @Override
    public void shutdown() {
        game.shutdown();
    }

    /**
     * Overriding of the update method: calls the game's update method, passing
     * along a copy of the input (current state of the keyboard and mouse)
     */
    @Override
    public void update() {
        game.update(input);
    }

    /**
     * Overriding of the draw method: draws the scene of the game and repaints.
     */
    @Override
    public void draw() {
        game.drawScene();
        frame.repaint();
    }

}
