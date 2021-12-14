package resulter;

import printer.MessagesPrinter;

import java.util.Set;

import static configuration.MessagesConfiguration.PRINTED_DRAWN_NUMBERS;
import static configuration.MessagesConfiguration.PRINTED_SELECTED_USER_NUMBERS;

public class ResultPrinter {

    private final MessagesPrinter messagesPrinter = new MessagesPrinter();

    public ResultPrinter() {
    }

    public void printResult(ResultChecker.ResultMessage resultMessage, Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        messagesPrinter.sendMessageToUser(resultMessage.getResultMessage());
        messagesPrinter.sendMessageToUser(drawnNumbers + " " + PRINTED_DRAWN_NUMBERS);
        messagesPrinter.sendMessageToUser(selectedUserNumbers + " " + PRINTED_SELECTED_USER_NUMBERS);
    }
}
