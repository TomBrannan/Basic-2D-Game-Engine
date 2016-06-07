package engine;

/**
 * Represents an abstract game loop mechanism.
 *
 * @author Tom
 */
public abstract class GameLoop extends Thread{

    private boolean runFlag = false;
    private final int maxSkippedFrames;
    private final double maxTimeDiff;

    public GameLoop(int maxSkippedFrames, double maxTimeDiff) {
        this.maxSkippedFrames = maxSkippedFrames;
        this.maxTimeDiff = maxTimeDiff;
    }

    /**
     * Begin the game loop
     */
    @Override
    public void run() {
        runFlag = true;

        startup();
        // convert the time to seconds
        double nextTime = (double) System.nanoTime() / 1000000000.0;
        int skippedFrames = 0;

        //The main game loop.  Runs until flag is set to false.
        while (runFlag) {
            // convert the time to seconds
            double currTime = (double) System.nanoTime() / 1000000000.0;
            if (currTime >= nextTime) {
                // assign the time for the next update
                nextTime += (1.0 / 50 /*desiredFPS*/);
                update();
                if ((currTime < nextTime) || (skippedFrames > maxSkippedFrames)) {
                    draw();
                    skippedFrames = 0;
                } else {
                    skippedFrames++;
                }
            } else {
                // calculate the time to sleep
                int sleepTime = (int) ((nextTime - currTime));
                
                if (sleepTime > 0) {
                    // System.out.println("sleeping for " + sleepTime);
                    // sleep until the next update
                    
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        }
        shutdown();
    }

    /**
     * Stops the game if it's currently running. This will trigger the shutdown
     * sequence. To start the game again (soft reset), run() must be called.
     */
    public final void end() {
        if (runFlag) {
            runFlag = false;
        }
    }

    /**
     * The startup sequence. This happens once before the game begins running.
     * Put any necessary initialization code (Database connections, etc.) here.
     */
    public abstract void startup();

    /**
     * The shutdown sequence. Free up any connections and tidy stuff up here.
     */
    public abstract void shutdown();

    /**
     * The game's logic update function. This is where the game will test for
     * any number of conditions and update entities accordingly (collision,
     * player position, win states, etc.)
     */
    public abstract void update();

    /**
     * The drawing mechanism: all drawing will be done here, for example,
     * drawing a player on the screen whose position was determined in the
     * update method. This method will be called at most once for each call to
     * the update method.
     */
    public abstract void draw();
}
