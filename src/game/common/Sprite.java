
package game.common;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Represents any object drawn on the screen that is neither background nor animated
 * @author Tom
 */
public abstract class Sprite {
    
    protected BufferedImage srcImage;
    protected BufferedImage drawImage;
    protected Point2D.Double position;
    protected float scale;
    protected Point2D.Double offset;
    protected Point2D.Double direction;
    protected float speed;
    protected int collisionOffset;
    protected boolean canCollide;
    
    public Sprite(BufferedImage srcImage, Point2D.Double position, float scale, Point2D.Double offset, Point2D.Double direction, float speed, int collisionOffset, boolean canCollide)
    {
        this.srcImage = srcImage;
        this.position = position;
        this.scale = scale;
        this.offset = offset;
        this.direction = direction;
        this.speed = speed;
        this.collisionOffset = collisionOffset;
        this.canCollide = canCollide;
        this.drawImage = resize(srcImage, (int)(srcImage.getWidth() * scale), (int)(srcImage.getHeight() * scale));
    }
    
    public abstract void update(long time, Rectangle clientBounds);
    public abstract void draw(long time, Graphics2D g2);
    
    public Rectangle getCollisionRect()
    {
        if(!canCollide) return new Rectangle(0, 0, 0, 0);
        int w = drawImage.getWidth();
        int h = drawImage.getHeight();
        
        float s = 1f;
        if(w >= 2 * h)  //For elongated sprites (i.e. missiles) only use the tip
        {
            h = w;
            return new Rectangle(
            (int)(position.x + (collisionOffset - offset.x) * scale * s),
            (int)(position.y + (collisionOffset - 0) * scale * s),
            (int)((w - collisionOffset * 2) * scale * s),
            (int)((h - collisionOffset * 2) * scale * s));
        }
        return new Rectangle(
        (int)(position.x + (collisionOffset - offset.x) * scale * s),
        (int)(position.y + (collisionOffset - offset.y) * scale * s),
        (int)((w - collisionOffset * 2) * scale * s),
        (int)((h - collisionOffset * 2) * scale * s));
    }
    
    public void setScale(float scale)
    {
        this.scale = scale;
        this.drawImage = resize(drawImage, (int)(drawImage.getWidth() * scale), (int)(drawImage.getHeight() * scale));
    }
    
    public static BufferedImage resize(BufferedImage bi, int newWidth, int newHeight)
    {
        BufferedImage ret = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = ret.createGraphics();
        g.drawImage(bi, 0, 0, newWidth, newHeight, null);
        g.dispose();
        return ret;
    }
}
