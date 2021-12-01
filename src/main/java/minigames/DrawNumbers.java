package minigames;

import java.util.*;

import static minigames.GameConfiguration.*;

public class DrawNumbers {

    List<Integer> drawnNumbers = new ArrayList<>();

    public DrawNumbers() {
    }

    List<Integer> drawingNumbers() {
        drawNumbers();
        sortNumbers(drawnNumbers);
        return drawnNumbers;
    }

    List<Integer> drawNumbers() {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            int randomNumber = (int) (Math.random() * RANDOM_NUMBER_BOUND);
            boolean ifAddDrawnNumber = true;

            if (ifActualRandomNumberWasDrawnBefore(randomNumber)) {
                ifAddDrawnNumber = false;
                i--;
            }
            if (ifAddDrawnNumber) {
                drawnNumbers.add(i, randomNumber);
            }
        }
        return drawnNumbers;
    }

    private boolean ifActualRandomNumberWasDrawnBefore(int randomNumber) {
        for (int number : drawnNumbers) {
            if (number == randomNumber) {
                return true;
            }
        }
        return false;
    }

    private void sortNumbers(List<Integer> unsortedList) {
        Collections.sort(unsortedList);
    }
}



