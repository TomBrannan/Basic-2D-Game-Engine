package game.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Particle - represents an individual particle object for the Particle Engine.
 * @author Tom
 */
public class Particle {
    
    public BufferedImage image;
    public Point2D.Double position;
    public Point2D.Double velocity;
    public float angle;
    public float angularVelocity;
    public float size;
    public int ttl; //frames to be alive for (time to live)
    public Color color;

    public Particle(BufferedImage image, Point2D.Double position, Point2D.Double velocity, float angle, float angularVelocity, float size, int ttl, Color color) {
        this.image = image;
        this.position = position;
        this.velocity = velocity;
        this.angle = angle;
        this.angularVelocity = angularVelocity;
        this.size = size;
        this.ttl = ttl;
        this.color = color;
    }
    
    public void update()
    {
        ttl--;
        position.x += velocity.x;
        position.y += velocity.y;
        angle += angularVelocity;
    }
    
    public void draw(Graphics2D g2)
    {
        g2.drawImage(image, (int)position.x, (int)position.y, null);
    }
    
}
