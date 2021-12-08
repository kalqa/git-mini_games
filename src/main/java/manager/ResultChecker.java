package manager;

import java.util.Set;

import static configuration.MessagesConfiguration.LOST_INFORMATION;
import static configuration.MessagesConfiguration.WIN_INFORMATION;

public class ResultChecker {

    public String checkResult(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        String message;
        boolean isWin = isDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        if (!isWin) {
            message = LOST_INFORMATION;
        } else {
            message = WIN_INFORMATION;
        }
        return message;
    }

    private boolean isDrawnNumbersEqualsSelectedUserNumbers(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        return selectedUserNumbers.equals(drawnNumbers);
    }
}