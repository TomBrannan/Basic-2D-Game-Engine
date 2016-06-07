package engine;

/**
 * Represents Input flow from the container (i.e. JFrame) to the Game and back.
 * Contains managers for event listening on keyboard and mouse, and contains an
 * instance of a keyboard and mouse state which is constantly updated by these
 * managers. An instance of this class is passed to the Game when the update
 * method is called.
 *
 * @author Tom
 */
public class Input {

    private final KeyboardManager keyboardManager;
    private final MouseManager mouseManager;
    private final KeyboardState keyboard;
    private final MouseState mouse;

    /**
     * Constructor: initializes the event listeners and key/mouse states.
     */
    public Input() {
        this.keyboardManager = new KeyboardManager();
        this.mouseManager = new MouseManager();
        this.keyboard = keyboardManager.getKeyboard();
        this.mouse = mouseManager.getMouse();
    }

    /**
     * @return The manager for the keyboard, which can be used as a listener.
     */
    public KeyboardManager getKeyboardManager() {
        return keyboardManager;
    }

    /**
     * @return The manager for the mouse, which can be used as a listener.
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    /**
     * @return The current state of the keyboard.
     */
    public KeyboardState getKeyboard() {
        return keyboard;
    }

    /**
     * @return The current state of the mouse.
     */
    public MouseState getMouse() {
        return mouse;
    }

}
