package game.common;

import engine.swing.graphics.AdditiveComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * ParticleEngine - handles generation and display of particles for a game object.
 * @author Tom
 */
public class ParticleEngine {
    
    private Random rand;
    public Point2D.Double emitterLocation;
    private List<Particle> particles;
    private List<BufferedImage> images;
    public static Composite additiveComposite = new AdditiveComposite();

    public ParticleEngine(Point2D.Double emitterLocation, List<BufferedImage> images) {
        this.rand = new Random();
        this.emitterLocation = emitterLocation;
        this.images = images;
        this.particles = new ArrayList<>();
    }
    
    private Particle generateNewParticle()
    {
        BufferedImage image = images.get(rand.nextInt(images.size()));
        Point2D.Double position = new Point2D.Double(emitterLocation.x, emitterLocation.y);
        Point2D.Double velocity = new Point2D.Double(
          1f * (float)(rand.nextDouble() * 2 - 1),
          1f * (float)(rand.nextDouble() * 2 - 1)
        );
        float angle = 0f;
        float angularVelocity = 0.2f * (float)(rand.nextDouble() * 2 - 1);
        Color color = Color.BLUE;
        float size = 0.09f;
        int ttl = rand.nextInt(150);
        return new Particle(image, position, velocity, angle, angularVelocity, size, ttl, color);
    }
    
    public void update()
    {
        int total = 1; //particles to add each frame
        for(int i = 0; i < total; i++)
        {
            particles.add(generateNewParticle());
        }
        for(int i = 0; i < particles.size(); i++)
        {
            particles.get(i).update();
            if(particles.get(i).ttl <= 0)
            {
                particles.remove(particles.get(i));
                i--;
            }
        }
    }
    
    public void draw(Graphics2D g2)
    {
        Composite oldComp = g2.getComposite();
        g2.setComposite(additiveComposite);
        for(Particle particle : particles)
        {
            particle.draw(g2);
        }
        g2.setComposite(oldComp);
    }

    public Point2D.Double getEmitterLocation() {
        return emitterLocation;
    }

    public void setEmitterLocation(Point2D.Double emitterLocation) {
        this.emitterLocation = emitterLocation;
    }
    
    
    
}
