package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Handles the use of a keyboard for input to the game. The KeyboardManager
 * class acts as a KeyListener while also providing functionality for retaining
 * the state of all keys on the keyboard since the last game update.
 *
 * @author Tom
 */
public class KeyboardManager extends KeyAdapter {

    private final KeyboardState keyboard; //The current state of the keyboard

    /**
     * Default constructor: initializes the keyboard state.
     */
    public KeyboardManager() {
        this.keyboard = new KeyboardState();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        this.keyboard.setLastKeyTyped(e.getKeyChar());
    }

    /**
     * Overriding of the keyPressed event: sends the key to the keyboard state
     *
     * @param e The KeyEvent object: information about which key was pressed.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((int)e.getKeyChar());
        keyboard.pressKey(e.getKeyCode());
    }

    /**
     * Overriding of the keyReleased event: sends the key to the keyboard state
     *
     * @param e The KeyEvent object: information about which key was released.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keyboard.releaseKey(e.getKeyCode());
    }

    /**
     * Gets the current state of the keyboard.
     *
     * @return The current state of the keyboard.
     */
    public KeyboardState getKeyboard() {
        return keyboard;
    }

}
