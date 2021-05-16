package restaurant;

import restaurant.message.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main Class to run the game
 */
public class Main {
    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        GameModel model = new GameModel();
        GameView view = new GameView(queue);
        GameController controller = new GameController(queue, model, view);
        controller.mainLoop();
    }

}
