package minigames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static minigames.GameConfiguration.AMOUNT_OF_NUMBERS;
import static minigames.GameConfiguration.RANDOM_NUMBER_BOUND;

public class DrawNumbers {

    List<Integer> drawnNumbers = new ArrayList<>();

    public DrawNumbers() {
    }

    List<Integer> drawingNumbers() {
        drawnNumbers = drawNumbers();
        sortNumbers(drawnNumbers);
        return drawnNumbers;
    }

    private List<Integer> drawNumbers() {
        List<Integer> drawnNumbers = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            int randomNumber = (int) (Math.random() * RANDOM_NUMBER_BOUND);
            boolean ifAddDrawnNumber = true;
            for (int number : drawnNumbers) {
                if (number == randomNumber) {
                    i--;
                    ifAddDrawnNumber = false;
                    break;
                }
            }
            if (ifAddDrawnNumber) {
                drawnNumbers.add(i, randomNumber);
            }
        }
        return drawnNumbers;
    }

    private void sortNumbers(List<Integer> unsortedList) {
        Collections.sort(unsortedList);
    }
}



