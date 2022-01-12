package result;

import api.Printable;

import java.util.Set;

import static configuration.MessagesConfiguration.PRINTED_DRAWN_NUMBERS;
import static configuration.MessagesConfiguration.PRINTED_SELECTED_USER_NUMBERS;

public class ResultPrinter {

    private final Printable printable;

    public ResultPrinter(Printable printable) {
        this.printable = printable;
    }

    public void printResult(ResultChecker.ResultMessage resultMessage, Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        printable.sendMessageToUser(resultMessage.getResultMessage());
        printable.sendMessageToUser(drawnNumbers + " " + PRINTED_DRAWN_NUMBERS);
        printable.sendMessageToUser(selectedUserNumbers + " " + PRINTED_SELECTED_USER_NUMBERS);
    }
}
