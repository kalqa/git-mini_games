package manager;

import java.util.Set;

import static configuration.MessagesConfiguration.LOST_INFORMATION;
import static configuration.MessagesConfiguration.WIN_INFORMATION;

public class ResultChecker {

    public ResultChecker() {
    }

    public static class ResultMessage {
        private final String resultMessage;

        public ResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        public String getResultMessage() {
            return resultMessage;
        }
    }

    public ResultMessage checkResult(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        boolean isWin = isDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        if (!isWin) {
            return new ResultMessage(LOST_INFORMATION);
        } else {
            return new ResultMessage(WIN_INFORMATION);
        }
    }

    private boolean isDrawnNumbersEqualsSelectedUserNumbers(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        return selectedUserNumbers.equals(drawnNumbers);
    }
}