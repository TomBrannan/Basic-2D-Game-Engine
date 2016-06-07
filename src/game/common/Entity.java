package game.common;

import java.awt.geom.Point2D;
import java.util.LinkedList;

/**
 * Represents a player, enemy, or NPC in the game.
 * Currently unfinished.
 * 
 * @author Tom
 */
public class Entity {
    
    enum Direction { UP, DOWN, LEFT, RIGHT };
    
    LinkedList<Animation> animations;
    Animation currentAnimation;
    Animation stillUp,  stillDown,  stillLeft,  stillRight;
    Animation walkUp,   walkDown,   walkLeft,   walkRight;
    Animation hurtUp,   hurtDown,   hurtLeft,   hurtRight;
    Animation attackUp, attackDown, attackLeft, attackRight;
    
    int frameCount = 0;
    float scale;
    Point2D.Double position;
    Direction direction;
    float speed;
    

}
