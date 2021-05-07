package restaurant;

import java.util.concurrent.BlockingQueue;

public class GameController {
    BlockingQueue<Message> queue;

    public GameController (BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public void mainLoop() {

    }

    private interface Valve {
        public ValveResponse execute(Message message);
    }
}
