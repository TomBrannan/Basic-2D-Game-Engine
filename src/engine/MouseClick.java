package engine;

import java.awt.Point;
import java.awt.event.InputEvent;

/**
 * Represents a single click of the mouse. Doesn't handle alt+MIDDLE though :P
 * Might screw up on non-Windows operating systems.
 *
 * @author Tom
 */
public class MouseClick {

    private final Point point;
    private final MouseState.Buttons button;
    private final long time;
    private final int modifiers;

    /**
     * Constructor: creates a MouseClick object given a point, button,
     * timestamp, and modifier keys (Alt, Ctrl, Shift) that were held down.
     *
     * @param point The location of the mouse click, relative to the container.
     * @param button The mouse button (left, middle, or right) that was clicked.
     * @param time Unix time in milliseconds since 1970.
     * @param modifiers A mask used to record which modifier keys were held.
     */
    public MouseClick(Point point, MouseState.Buttons button, long time, int modifiers) {
        this.point = point;
        this.button = button;
        this.time = time;
        this.modifiers = modifiers;
    }

    /**
     * Gets the location of the mouse when it was clicked, relative to the
     * container.
     *
     * @return The mouse's position when it was clicked.
     */
    public Point getPoint() {
        return point;
    }

    /**
     * Gets the button that was pressed for this click (left, middle, or right).
     *
     * @return The button that was pressed (left, middle, or right).
     */
    public MouseState.Buttons getButton() {
        return button;
    }

    /**
     * Gets the UNIX timestamp in ms since January 1st, 1970, of this click.
     *
     * @return Milliseconds since Jan 1 1970 (this click's timestamp)
     */
    public long getTime() {
        return time;
    }

    /**
     * @return True if Shift was held down when the click occurred.
     */
    public boolean wasShiftDown() {
        return (modifiers & InputEvent.SHIFT_DOWN_MASK) != 0;
    }

    /**
     * @return True if Control was held down when the click occurred.
     */
    public boolean wasCtrlDown() {
        return (modifiers & InputEvent.CTRL_DOWN_MASK) != 0;
    }

    /**
     * @return True if Alt was held down when the click occurred. Does not work
     * for the MIDDLE mouse button. Might fix it later.
     */
    public boolean wasAltDown() {
        return (modifiers & InputEvent.ALT_DOWN_MASK) != 0;
    }
}
