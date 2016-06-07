package game.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

/**
 * AnimationEngine - handles animation logic for game objects.
 * Currently unfinished.
 * @author Tom
 */
public class AnimationEngine {
    
    LinkedList<Animation> animations;
    int currentAnimation;
    int currentFrame;
    Animation loadedAnimation;
    
    public AnimationEngine(File upperDirectory, int delay)
    {
        this.animations = getAnimations(upperDirectory, delay);
        if(this.animations == null || this.animations.isEmpty())
        {
            this.currentFrame = -1;
            this.currentAnimation = -1;
            this.loadedAnimation = null;
            System.out.println("Huh?");
        }
        else
        {
            this.currentFrame = 0;
            this.currentAnimation = 0;
            this.loadedAnimation = animations.get(0);
        }
    }
    
    public BufferedImage getNextFrame()
    {
        BufferedImage b = loadedAnimation.getFrames()[currentFrame % loadedAnimation.numFrames];
        currentFrame++;
        return b;
    }
    
    public static LinkedList<Animation> getAnimations(File upperDirectory, int delay)
    {
        LinkedList<Animation> animations = new LinkedList<>();
        File[] lowerDirectories = upperDirectory.listFiles();
        for(File dir : lowerDirectories)
        {
            animations.add(new Animation(dir, delay));
        }
        return animations;
    }
}
