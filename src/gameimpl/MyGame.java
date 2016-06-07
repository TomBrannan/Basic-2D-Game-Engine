
package gameimpl;

import engine.swing.SwingGame;
import engine.Input;
import game.common.ParticleEngine;
import game.common.Sprite;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * An example SwingGame implementation.  
 * @author Tom
 */
public class MyGame extends SwingGame {

    private Ball ball;
    private BufferedImage backgroundImage;
    private int velocity = 3;
    private String str = "";
    private boolean dragging = false;
    private ParticleEngine pEngine;

    public MyGame(int width, int height, boolean resizable) {
        super(width, height, resizable);
        this.backgroundColor = Color.BLUE;
    }

    public MyGame(String title, int width, int height, boolean resizable) {
        super(title, width, height, resizable);
    }

    @Override
    public void drawScene() {
        clearScene();
        g2.drawImage(backgroundImage, 0, 0, null);
        ball.draw(0, g2);
        pEngine.draw(g2);
    }

    public void updateKeyTyped(Input input) {
        char lastKey = input.getKeyboard().getLastKeyTyped();
        if (lastKey == 0) {
            return;
        }
        if (lastKey == KeyEvent.VK_ENTER) {
            str += "\n";
        } else if (lastKey == KeyEvent.VK_BACK_SPACE && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        } else {
            str += lastKey;
        }
        input.getKeyboard().setLastKeyTyped((char) 0);
    }

    @Override
    public void update(Input input) {
        ball.update(0, new Rectangle(0, 0, width, height));
        pEngine.update();
        pEngine.emitterLocation.x = input.getMouse().getPosition().x;
        pEngine.emitterLocation.y = input.getMouse().getPosition().y;
    }

    //Implement as needed
    @Override
    public void startup() {

        File ballFile = new File("resources/pictures/sprites/ball.png");
        File backgroundFile = new File("resources/pictures/sprites/background.png");
        try {
            BufferedImage ballImage = ImageIO.read(ballFile);
            backgroundImage = ImageIO.read(backgroundFile);
            ball = new Ball(ballImage, new Point2D.Double(30, 50), 0.1f, new Point2D.Double(0, 0), new Point2D.Double(2.3, -1.3), 1.0f, 50, true);
            List<BufferedImage> particleImages = new ArrayList<>();
            particleImages.add(Sprite.resize(ballImage, 20, 20));
        this.pEngine = new ParticleEngine(new Point2D.Double(300, 300), particleImages);

        } catch (IOException ex) {
            Logger.getLogger(MyGame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void shutdown() {
    }

}
