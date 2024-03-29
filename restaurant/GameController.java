package restaurant;

import restaurant.message.*;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**
 * Controller of the Game
 */
public class GameController {
    BlockingQueue<Message> queue;
    private GameView view;
    private GameModel model;
    private ArrayList<Valve> valves = new ArrayList<>();

    /**
     * The Game Controller that builds the restaurant
     * @param queue To initialize the controller in the game state
     * @param model To add the model logic to the controller
     * @param view  To add the view to the controller
     */
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
        valves.add(new SellFoodValve());
    }

    /**
     * Instantiate the mainloop that runs the game
     */
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

    /**
     * Valves used in MainMenuFrame. For "Play" and "Leaderboard" buttons
     */
    private class StartGameValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != StartGameMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to change view from MainMenuFrame to GameStartFrame
            // updateToGameStart is a view function that switches frames (Needs to be implemented)

            view.updateToGameStart();
            return ValveResponse.EXECUTED;
        }
    }

    /**
     *  Valves used in GameStartFrame. For "Start Game" and "Gacha" buttons
     */
    private class PlayGameValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != PlayGameMessage.class) {
                return ValveResponse.MISS;
            }

            view.updateMoney(model.user.getBalance());
            // Valve response to change view from GameStartFrame to RestaurantFrame
            // updateToRestaurantFrame is a view function that switches frames (Needs to be implemented)
            view.restaurantScreen.updatePlayerFood(model.user.getFood());
            //gets the initial customer
            view.restaurantScreen.updateCustomer(model.getCustomer());
            view.updateGameDisplay(model.getCustomer().getOrder().getPictureLocation());

            view.updateToRestaurantFrame();
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * StartGachaValve method
     * Valves used in GachaFrame
     */
    private class StartGachaValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != StartGachaMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to change view from GameStartFrame to GachaFrame
            // updateToGachaFrame is a view function that switches frames (Needs to be implemented)
            view.updateMoney(model.user.getBalance());
            view.rollStatus(model.user.getBalance());
            view.updateToGachaFrame();
            view.updateGachaMoney(model.user.getBalance());
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * SingleRollValve method
     * Valves used in GachaFrame. For "Roll 1" and "Back" buttons
     */
    private class SingleRollValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != SingleRollMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to roll for a single food

            SingleRollMessage msg = (SingleRollMessage) message;
            Food foodRolled = msg.getFoodRolled();
            String foodFilePath = foodRolled.getPictureLocation();
            //display rolled food in display box
            for(int i =0; i < model.user.getFood().size(); i++) {
                if (model.user.getFood().get(i).equals(foodRolled)) {
                    model.setPicture(foodFilePath);
                    view.updateGachaDisplay(model.getDisplayFood());
                }
            }
            model.setPicture(foodFilePath);
            view.updateGachaDisplay(model.getDisplayFood());
            view.rollStatus(model.user.getBalance());
            if (model.user.getBalance() >= 100) {
                model.user.subtractFromGachaRoll();
                model.user.addFood(foodRolled);
            }
            view.updateGachaMoney(model.user.getBalance());
            view.rollStatus(model.user.getBalance());
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve to return back to the manage screen
     */
    private class BackToManageValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != BackToManageMessage.class) {
                return ValveResponse.MISS;
            }

            // Valve response to go back to GameStartFrame from GachaFrame

            view.returnToGameStart();
            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve to sell food in the minigame
     */
    private class SellFoodValve implements Valve {
        public ValveResponse execute(Message message) {
            if (message.getClass() != SellFoodMessage.class) {
                return ValveResponse.MISS;
            }

            SellFoodMessage msg = (SellFoodMessage) message;
            Food soldFood = msg.getSoldFood();
            if (soldFood.equals(model.getCustomer().getOrder())) {
                //add money upon correct selection
                model.user.addMoney(soldFood.getPrice());
                view.updateMoney(model.user.getBalance());

                //creates new customer
                model.makeCustomer();
                view.restaurantScreen.updateCustomer(model.getCustomer());
                    //System.out.println(model.getCustomer());
                view.updateGameDisplay(model.getCustomer().getOrder().getPictureLocation());
            }
            else{
                model.makeCustomer();
                view.restaurantScreen.updateCustomer(model.getCustomer());
                    //System.out.println(model.getCustomer());
                view.updateGameDisplay(model.getCustomer().getOrder().getPictureLocation());
            }

            return ValveResponse.EXECUTED;
        }
    }

    /**
     * Valve Interface to work on the execute
     */
    private interface Valve {
        ValveResponse execute(Message message);
    }
}
