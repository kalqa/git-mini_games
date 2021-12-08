package manager;

import java.util.Set;
import java.util.TreeSet;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static configuration.GameConfiguration.RANDOM_NUMBER_BOUND;

public class DrawNumbersManager {

    public DrawNumbersManager() {
    }

    public Set<Integer> drawNumbers() {
        Set<Integer> drawnNumbers = new TreeSet<>();

        while (drawnNumbers.size() < AMOUNT_OF_NUMBERS) {
            int randomNumber = (int) (Math.random() * RANDOM_NUMBER_BOUND) + LOWEST_NUMBER;
            drawnNumbers.add(randomNumber);
        }
        return drawnNumbers;
    }
}



