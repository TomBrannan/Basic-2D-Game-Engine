package game.common;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Animation - defines an animation, including state, for a given game object.
 * Currently unfinished.
 * @author Tom
 */
public class Animation {

    int numFrames; //The total number of frames of animation
    int delay; //Number of game updates between each frame
    BufferedImage[] frames; //Each frame (image) of the Animation
    String name; //The name of this animation (folder name)
    
    public Animation(File directory, int delay)
    {
        this.delay = delay;
        this.name = directory.getName();
        System.out.println(name);
        this.frames = loadAnimation(directory);
        this.numFrames = frames.length;
    }
    
    public BufferedImage[] getFrames()
    {
        return frames;
    }
    
    public int getNumFrames()
    {
        return numFrames;
    }
    
    public int getDelay()
    {
        return delay;
    }

    public static BufferedImage[] loadAnimation(File directory) {
        
        File[] files = directory.listFiles();
        BufferedImage[] frames = new BufferedImage[files.length];
        for(int i = 0; i < frames.length; i++)
        {
            
            try {
                frames[i] = ImageIO.read(files[i]);
            } catch (IOException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return frames;
    }
}
