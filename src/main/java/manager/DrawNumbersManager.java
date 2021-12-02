package manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static configuration.GameConfiguration.RANDOM_NUMBER_BOUND;

public class DrawNumbersManager {

    public DrawNumbersManager() {
    }

    public List<Integer> drawingNumbers() {
        List<Integer> drawnNumbers = drawNumbers();
        sortNumbers(drawnNumbers);
        return drawnNumbers;
    }

    List<Integer> drawNumbers() {
        List<Integer> drawnNumbers = new ArrayList<>();
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
        return drawnNumbers;
    }

    private boolean isActualRandomNumberWasDrawnBefore(int randomNumber, List<Integer> drawnNumbers) {
        for (Integer number : drawnNumbers) {
            if (number.equals(randomNumber)) {
                return true;
            }
        }
        return false;
    }

    private void sortNumbers (List < Integer > unsortedList) {
        Collections.sort(unsortedList);
    }
}



