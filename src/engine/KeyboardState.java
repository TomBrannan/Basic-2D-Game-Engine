package engine;

/**
 * Represents the current state of a keyboard. Contains an array of booleans
 * used to represent which keys are currently pressed (true) and which are not
 * (false). The index into the array is given by the java.awt.event.KeyEvent
 * class (the KeyEvent's keyCode).
 *
 * @author Tom
 */
public class KeyboardState {

    private boolean[] keys = new boolean[1000];
    private char lastKeyTyped = 0;
    
    /**
     * Sets the last key that was typed.
     * @param lastKeyTyped The last key that was typed.
     */
    public void setLastKeyTyped(char lastKeyTyped) {
        this.lastKeyTyped = lastKeyTyped;
    }
    
    /**
     * Gets the last key that was typed.
     * @return The last key that was typed.
     */
    public char getLastKeyTyped() {
        return lastKeyTyped;
    }

    /**
     * Given a keyCode, sets that key to be pressed in the array.
     *
     * @param keyCode The index for the key to be pressed.
     */
    public void pressKey(int keyCode) {
        keys[keyCode] = true;
    }

    /**
     * Given a keyCode, sets that key to be released in the array.
     *
     * @param keyCode The index for the key to be released.
     */
    public void releaseKey(int keyCode) {
        keys[keyCode] = false;
    }

    /**
     * Given a keyCode, returns true if that key is currently pressed down.
     *
     * @param keyCode The index of the key.
     * @return True if the key is pressed down, false if it's not.
     */
    public boolean isKeyDown(int keyCode) {
        return keys[keyCode];
    }

    /**
     * Given a keyCode, returns true if that key is currently released.
     *
     * @param keyCode The index of the key.
     * @return True if the key is released, false if it's pressed down.
     */
    public boolean isKeyUp(int keyCode) {
        return !keys[keyCode];
    }

    /**
     * Overloaded method. Given a character, returns true if the key which that
     * character represents is currently pressed down.
     *
     * @param keyChar The character representing a key (e.g. 'A' for the A key)
     * @return True if the key is pressed down, false otherwise.
     */
    public boolean isKeyDown(char keyChar) {
        keyChar = ("" + keyChar).toUpperCase().charAt(0);
        return keys[(int) keyChar];
    }

    /**
     * Overloaded method. Given a character, returns true if the key which that
     * character represents is currently released (not pressed down).
     *
     * @param keyChar The character representing a key (e.g. 'A' for the A key)
     * @return True if the key is released, false if it's pressed down.
     */
    public boolean isKeyUp(char keyChar) {
        keyChar = ("" + keyChar).toUpperCase().charAt(0);
        return !keys[(int) keyChar];
    }

    /**
     * Releases all keys in case the frame loses focus upon a keyUp event.
     */
    public void releaseAllKeys() {
        keys = new boolean[1000];
    }
    
    public boolean[] getKeys()
    {
        return keys;
    }
}
