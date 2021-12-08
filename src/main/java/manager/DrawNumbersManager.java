package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static configuration.GameConfiguration.RANDOM_NUMBER_BOUND;

public class DrawNumbersManager {

    public DrawNumbersManager() {
    }

    public Set<Integer> drawingNumbers() {
        Set<Integer> drawnNumbers = drawNumbers();
        //Collections.sort(drawnNumbers);
        return drawnNumbers;
    }

    Set<Integer> drawNumbers() {
        Set<Integer> drawnNumbers = new TreeSet<>();

        while (drawnNumbers.size() < AMOUNT_OF_NUMBERS) {
            int randomNumber = (int) (Math.random() * RANDOM_NUMBER_BOUND) + LOWEST_NUMBER;
            drawnNumbers.add(randomNumber);
            //System.out.print(randomNumber + " ");
        }
       //System.out.println("\n" + drawnNumbers);
        return drawnNumbers;

        /* Set<Integer> drawnNumbers = new TreeSet<>();
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            int randomNumber = (int) (Math.random() * RANDOM_NUMBER_BOUND) + LOWEST_NUMBER;
            boolean addDrawnNumber = true;

            if (isActualRandomNumberWasDrawnBefore(randomNumber, drawnNumbers)) {
                addDrawnNumber = false;
                i--;
            }
            if (addDrawnNumber) {
                drawnNumbers.add(randomNumber);
            }
        }
        return drawnNumbers;*/
    }

    private boolean isActualRandomNumberWasDrawnBefore(int randomNumber, Set<Integer> drawnNumbers) {
        for (Integer number : drawnNumbers) {
            if (number.equals(randomNumber)) {
                return true;
            }
        }
        return false;
    }
}



