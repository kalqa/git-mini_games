package manager;

import java.util.List;
import java.util.Set;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.MessagesConfiguration.LOST_INFORMATION;
import static configuration.MessagesConfiguration.WIN_INFORMATION;

public class ResultChecker {

    public String checkResult(List<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        String message;
        boolean isWin = isDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        if (!isWin) {
            message = LOST_INFORMATION;
        } else {
            message = WIN_INFORMATION;
        }
        return message;
    }

    private boolean isDrawnNumbersEqualsSelectedUserNumbers(List<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        //boolean equals = false;
        if (selectedUserNumbers.equals(drawnNumbers)) {
            //equals = true;
            return true;
        } else {
            //equals = true;
            return false;
        }

        /* for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (!selectedUserNumbers.get(i).equals(drawnNumbers.get(i))) {
                equals = false;
                break;
            } else {
                equals = true;
            }
        }*/
        //return equals;
    }
}