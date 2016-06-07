
package gameimpl;

import engine.swing.SwingGame;
import engine.swing.SwingGameEngine;

/**
 * Runner class
 * @author Tom
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        SwingGame p = new MyGame(800, 500, true);
        p.setTitle("Game");
        playGame(p);
    }
    
    public static synchronized void playGame(SwingGame game) throws InterruptedException
    {
        SwingGameEngine engine = new SwingGameEngine(game, 5, 0.5);
        engine.start();
    }
    
}
