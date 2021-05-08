package restaurant;

import java.util.concurrent.BlockingQueue;

public class GameController {
    BlockingQueue<Message> queue;
    private GameView view;
    private GameModel model;

    public GameController (BlockingQueue<Message> queue, GameModel model, GameView view)
    {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop() {
        while(view.isDisplayable())
        {
            Message message = null;
            try {
                message = queue.take();
            }catch (InterruptedException e){
                //do nothing
            }



        }
    }

    /*
    private interface Valve {
        public ValveResponse execute(Message message);
    }*/
}
