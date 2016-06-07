package engine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * Handles the use of a mouse for input to the game. The MouseManager class acts
 * as a MouseListener while also providing functionality for retaining the state
 * of the mouse since the last game update.
 *
 * @author Tom
 */
public class MouseManager extends MouseAdapter {

    MouseState mouse; //The current state of the mouse

    /**
     * Default constructor: initializes the mouse's state.
     */
    public MouseManager() {
        this.mouse = new MouseState();
    }

    /**
     * Overriding of the mouseDragged event: simply updates the position.
     *
     * @param e The MouseEvent containing information about the drag (but we
     * only care about the position)
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        mouse.setPosition(e.getPoint());
    }

    /**
     * Overriding of the mouseClicked event: sets the last click to this spot.
     *
     * @param e The MouseEvent containing information about this click.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        mouse.setLastClick(new MouseClick(e.getPoint(), MouseState.Buttons.values()[e.getButton() - 1], e.getWhen(), e.getModifiersEx()));
    }

    /**
     * Overriding of the mousePressed event: detects when the left, middle, or
     * right mouse buttons are pressed down, and relays that information to the
     * MouseState.
     *
     * @param e The MouseEvent containing information about this press.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                mouse.pressButton(MouseState.Buttons.LEFT);
                break;
            case MouseEvent.BUTTON3:
                mouse.pressButton(MouseState.Buttons.RIGHT);
                break;
            case MouseEvent.BUTTON2:
                mouse.pressButton(MouseState.Buttons.MIDDLE);
                break;
            case MouseEvent.NOBUTTON: //Should never happen...
                mouse.pressButton(MouseState.Buttons.NONE);
                break;
        }
    }

    /**
     * Overriding of the mouseReleased event: detects when the left, middle, or
     * right mouse buttons are released (after having been pressed down), and
     * relays that information to the MouseState.
     *
     * @param e The MouseEvent containing information about this release.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                mouse.releaseButton(MouseState.Buttons.LEFT);
                break;
            case MouseEvent.BUTTON3:
                mouse.releaseButton(MouseState.Buttons.RIGHT);
                break;
            case MouseEvent.BUTTON2:
                mouse.releaseButton(MouseState.Buttons.MIDDLE);
                break;
            case MouseEvent.NOBUTTON: //Should never happen...
                mouse.releaseButton(MouseState.Buttons.NONE);
                break;
        }
    }

    /**
     * Overriding of the mouseMoved event: detects when the mouse is moved and
     * updates the position of the MouseState object.
     *
     * @param e The MouseEvent containing information about the mouse's
     * movement.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouse.setPosition(e.getPoint());
    }

    /**
     * Overriding of the mouseWheelMoved event: detects when the mouse wheel is
     * scrolled up or down. If it's scrolled up (away), the direction is set to
     * be 1. If it's scrolled down, the direction is set to -1. This Information
     * is then passed on to the MouseState object.
     *
     * The intended use of this method is to have the Game class interpret the
     * scroll direction, process it, then set it back to 0 (the field of the
     * Input object)
     *
     * @param e The MouseWheelEvent containing information about the scroll.
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int direction = 0;
        if (e.getWheelRotation() > 0) {
            direction = -1;
        }
        if (e.getWheelRotation() < 0) {
            direction = 1;
        }
        mouse.setScrollDirection(direction);
    }

    /**
     * Gets the current state of the mouse.
     *
     * @return The current state of the mouse.
     */
    public MouseState getMouse() {
        return mouse;
    }

}
