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
        valves.add(new StartGachaValve());
        valves.add(new SingleRollValve());
        valves.add(new BackToManageValve());
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

    // Valves used in MainMenuFrame. For "Play" and "Leaderboard" buttons

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

    // Leaderboard valve to be implemented


    // Valves used in GameStartFrame. For "Start Game" and "Gacha" buttons

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

    private class StartGachaValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != StartGachaMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to change view from GameStartFrame to GachaFrame
            // updateToGachaFrame is a view function that switches frames (Needs to be implemented)

            //GameView.updateToGachaFrame();
            return ValveResponse.EXECUTED;
        }
    }

    // Valves used in GachaFrame. For "Roll 1", "Roll 10" (may implement later), and "Back" buttons

    private class SingleRollValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != SingleRollMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to roll for a single food

            //GameModel.rollOnce();
            return ValveResponse.EXECUTED;
        }
    }

    private class BackToManageValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != BackToManageMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to go back to GameStartFrame from GachaFrame

            //GameView.updateToGameStart();
            return ValveResponse.EXECUTED;
        }
    }



    private interface Valve {
        ValveResponse execute(Message message);
    }
}
