package restaurant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class GameController {
    BlockingQueue<Message> queue;
    private GameView view;
    private GameModel model;
    private ArrayList<Valve> valves = new ArrayList<Valve>();

    public GameController (BlockingQueue<Message> queue, GameModel model, GameView view)
    {
        this.queue = queue;
        this.model = model;
        this.view = view;

        // Creates object of each kind of valve
        valves.add(new StartGameValve());
        valves.add(new PlayGameValve());
    }

    public void mainLoop() {
        ValveResponse response = ValveResponse.EXECUTED;
        Message message = null;
        while(response != ValveResponse.FINISH)
        {
            try {
                message = queue.take();
            }catch (InterruptedException e){
                //do nothing
            }

            // Looks for a valve that can process current message
            for (Valve valve : valves) {
                response = valve.execute(message);
                if (response != ValveResponse.MISS) {
                    break;
                }
            }


        }
    }

    private class StartGameValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != StartGameMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to change view from MainMenuFrame to GameStartFrame
            // updateToGameStart is a view function that switches frames (Needs to be implemented)

            //GameView.updateToGameStart();
            return ValveResponse.EXECUTED;
        }
    }

    private class PlayGameValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != PlayGameMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to change view from GameStartFrame to RestaurantFrame
            // updateToRestaurantFrame is a view function that switches frames (Needs to be implemented)

            //GameView.updateToRestaurantFrame();
            return ValveResponse.EXECUTED;
        }
    }



    private interface Valve {
        ValveResponse execute(Message message);
    }
}
