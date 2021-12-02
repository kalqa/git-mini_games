package manager;

import java.util.List;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.MessagesConfiguration.LOST_INFORMATION;
import static configuration.MessagesConfiguration.PRINTED_DRAWN_NUMBERS;
import static configuration.MessagesConfiguration.PRINTED_SELECTED_USER_NUMBERS;
import static configuration.MessagesConfiguration.WIN_INFORMATION;

public class ResultPrinter {

    public ResultPrinter() {
    }

    public void printResult(String gameResult, List<Integer> drawnNumbers, List<Integer> selectedUserNumbers) {
        printWinOrLoseMessage(gameResult);
        printDrawnNumbers(drawnNumbers);
        printSelectedUserNumbers(selectedUserNumbers);
    }

    private void printWinOrLoseMessage(String message) {
            System.out.println(message);
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
