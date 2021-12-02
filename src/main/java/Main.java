import service.GameService;

import static configuration.GameConfiguration.LOWEST_NUMBER;
import static configuration.GameConfiguration.RANDOM_NUMBER_BOUND;

public class Main {

    public static void main(String[] args) {
        GameService game = new GameService();
        game.operateGame();
    }
}



