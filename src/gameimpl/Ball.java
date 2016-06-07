package gameimpl;

import game.common.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Ball - currently just a bouncing ball
 *
 * @author Tom
 */
public class Ball extends Sprite {

    public Ball(BufferedImage image, Point2D.Double position, float scale, Point2D.Double offset, Point2D.Double direction, float speed, int collisionOffset, boolean canCollide) {
        super(image, position, scale, offset, direction, speed, collisionOffset, canCollide);
    }

    @Override
    public void update(long time, Rectangle clientBounds) {
        position.x += speed * direction.x;
        position.y += speed * direction.y;
        Rectangle colRect = getCollisionRect();
        if (colRect.x + colRect.width >= clientBounds.width || colRect.x <= 0) {
            direction.x *= -1;
        }
        if (colRect.y + colRect.height >= clientBounds.height || colRect.y <= 0) {
            direction.y *= -1;
        }

    }

    @Override
    public void draw(long time, Graphics2D g2) {

        Color oldColor = g2.getColor();
        Color debugColor = Color.RED;
        g2.drawImage(drawImage, (int) position.x, (int) position.y, null);
        g2.setColor(oldColor);
    }

    public Point2D.Double getPosition() {
        return position;
    }

}
