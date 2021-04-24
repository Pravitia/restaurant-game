package restaurant;

import java.util.ArrayList;

public class Leaderboard {
    ArrayList<Player> ranking;

    public double getMoneyMade()
    {
        double total = 0;
        for(int i = 0; i < ranking.size(); i++) {
            total += ranking.get(i).getMoneyMade();
        }
        return total;
    }
}
