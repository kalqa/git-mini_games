package minigames;

import java.util.List;

import static minigames.GameConfiguration.AMOUNT_OF_NUMBERS;
import static minigames.Messages.*;

public class GameResult {

    void checkResultAndPrintMessage(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {
        ifDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        printDrawnNumbers(drawnNumbers);
        printSelectedUserNumbers(selectedUserNumbers);
    }

    boolean ifDrawnNumbersEqualsSelectedUserNumbers(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (selectedUserNumbers.get(i) != drawnNumbers.get(i)) {
                System.out.println(LOST_INFORMATION);
                return false;
            } else {
                continue;
            }
        }
        System.out.println(WIN_INFORMATION);
        return true;
    }

    private void printDrawnNumbers(List<Integer> drawnNumbers) {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (drawnNumbers.get(i) < 10) {
                System.out.print("0" + drawnNumbers.get(i) + " ");
            } else {
                System.out.print(drawnNumbers.get(i) + " ");
            }
        }
        System.out.println(PRINTED_DRAWN_NUMBERS);
    }

    private void printSelectedUserNumbers(List<Integer> selectedUserNumbers) {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (selectedUserNumbers.get(i) < 10) {
                System.out.print("0" + selectedUserNumbers.get(i) + " ");
            } else {
                System.out.print(selectedUserNumbers.get(i) + " ");
            }
        }
        System.out.println(PRINTED_SELECTED_USER_NUMBERS);
    }
}
