package manager;

import java.util.Set;

import static configuration.MessagesConfiguration.PRINTED_DRAWN_NUMBERS;
import static configuration.MessagesConfiguration.PRINTED_SELECTED_USER_NUMBERS;

public class ResultPrinter {

    public ResultPrinter() {
    }

    public void printResult(String gameResult, Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        printWinOrLoseMessage(gameResult);
        printDrawnNumbers(drawnNumbers);
        printSelectedUserNumbers(selectedUserNumbers);
    }

    private void printWinOrLoseMessage(String message) {
            System.out.println(message);
    }

    private void printDrawnNumbers(Set<Integer> drawnNumbers) {
        System.out.println(drawnNumbers + " " + PRINTED_DRAWN_NUMBERS);
    }

    private void printSelectedUserNumbers(Set<Integer> selectedUserNumbers) {
        System.out.println(selectedUserNumbers + " " + PRINTED_SELECTED_USER_NUMBERS);
    }
}
