package engine;

import java.awt.Point;

/**
 * Represents the current state of the mouse at any instant in time. Contains
 * attributes for the buttons that are currently held down, a boolean for
 * whether or not the mouse is positioned within its container, a Point for the
 * position of the mouse relative to its container, the most recent scroll
 * direction of the scroll wheel, and a MouseClick representing the most recent
 * click of the mouse.
 *
 * @author Tom
 */
public class MouseState {

    public static enum Buttons {

        NONE, LEFT, MIDDLE, RIGHT
    };

    private final boolean[] buttons; //Size 4, for simplicity when parsing BUTTONS.NONE.
    private boolean in;
    private final Point position;
    private int scrollDirection = 0; //0 for nothing, 1 if scrolled up, -1 if down
    private MouseClick lastClick;

    /**
     * Constructor: initializes the lastClick, position, and buttons values.
     */
    public MouseState() {
        buttons = new boolean[4];
        lastClick = new MouseClick(new Point(0, 0), MouseState.Buttons.NONE, 0, 0);
        position = new Point(0, 0);
    }

    /**
     * Updates the lastClick variable to a new MouseClick value.
     *
     * @param mouseClick The new click value.
     */
    public void setLastClick(MouseClick mouseClick) {
        lastClick = mouseClick;
    }

    /**
     * Gets the last click for this mouse state. Contains information about the
     * mouse's position, which button was clicked, the time it was clicked, and
     * which (if any) modifier keys were held down during the click.
     *
     * @return
     */
    public MouseClick getLastClick() {
        return lastClick;
    }

    /**
     * Sets the given button to the pressed state (true).
     *
     * @param button The button that is being pressed.
     */
    public void pressButton(MouseState.Buttons button) {
        buttons[button.ordinal()] = true;
    }

    /**
     * Sets the given button to the released state (false).
     *
     * @param button The button that is being released.
     */
    public void releaseButton(MouseState.Buttons button) {
        buttons[button.ordinal()] = false;
    }

    /**
     * Sets the position of this MouseState.
     *
     * @param point The new position, relative to the container.
     */
    public void setPosition(Point point) {
        this.position.setLocation(point);
    }

    /**
     * Sets whether the mouse is considered to be within the bounds of the
     * container.
     *
     * @param in True if the mouse is considered to be within the bounds of the
     * container; false otherwise.
     */
    public void setIn(boolean in) {
        this.in = in;
    }

    /**
     * Sets the direction of the most recent scroll of the mouse wheel. Should
     * be 1 for up, -1 for down. This value should be intercepted by the game
     * which should then immediately set this back to 0.
     *
     * @param scrollDirection The direction of the scroll: Up = 1, Down = -1.
     */
    public void setScrollDirection(int scrollDirection) {
        this.scrollDirection = scrollDirection;
    }

    /**
     * Gets the direction of the most recent scroll of the mouse wheel.
     *
     * @return 1 if the scroll wheel was most recently scrolled up, -1 if down.
     */
    public int getScrollDirection() {
        return scrollDirection;
    }

    /**
     * Gets the position of the mouse at the current time.
     *
     * @return The mouse's position relative to the container.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Used for determining if the mouse should be considered to be within the
     * bounds of the container.
     *
     * @return True if the mouse is within the bounds of the container, false
     * otherwise.
     */
    public boolean getIn() {
        return in;
    }

    /**
     * Convenience method.
     *
     * @return True if the left mouse button is held down, false if not.
     */
    public boolean isLeftDown() {
        return buttons[1];
    }

    /**
     * Convenience method.
     *
     * @return True if the middle mouse button is held down, false if not.
     */
    public boolean isMiddleDown() {
        return buttons[2];
    }

    /**
     * Convenience method.
     *
     * @return True if the right mouse button is held down, false if not.
     */
    public boolean isRightDown() {
        return buttons[3];
    }

    /**
     * Convenience method.
     *
     * @return True if the left mouse button is released, false if not.
     */
    public boolean isLeftUp() {
        return !buttons[1];
    }

    /**
     * Convenience method.
     *
     * @return True if the middle mouse button is released, false if not.
     */
    public boolean isMiddleUp() {
        return !buttons[2];
    }

    /**
     * Convenience method.
     *
     * @return True if the right mouse button is released, false if not.
     */
    public boolean isRightUp() {
        return !buttons[3];
    }

    /**
     * Forces all mouse buttons to be set to the "released" state. This may be
     * useful for handling conditions where the game loses focus while the mouse
     * state contains buttons in the "pressed" state.
     */
    public void releaseAllButtons() {
        for (Buttons b : Buttons.values()) {
            releaseButton(b);
        }
    }

}
