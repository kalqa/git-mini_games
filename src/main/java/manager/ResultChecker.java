package manager;

import java.util.Set;

public class ResultChecker {

    public ResultChecker() {
    }

    public static class ResultMessage {
        private final String resultMessage;

        private enum Information {
            WIN_INFORMATION("asdasd"),
            LOST_INFORMATION("asdasdzxc");

            public final String message;

            Information(String message) {
                this.message = message;
            }
        }

        public ResultMessage(String resultMessage) {
            this.resultMessage = resultMessage;
        }

        public String getResultMessage() {
            return resultMessage;
        }

        public static ResultMessage winResultMessage() {
            return new ResultMessage(Information.WIN_INFORMATION.message);
        }

        public static ResultMessage lostResultMessage() {
            return new ResultMessage(Information.LOST_INFORMATION.message);
        }
    }

    public ResultMessage checkResult(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        boolean isWin = isDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        if (!isWin) {
            return ResultMessage.lostResultMessage();
        } else {
            return ResultMessage.winResultMessage();
        }
    }

    private boolean isDrawnNumbersEqualsSelectedUserNumbers(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        return selectedUserNumbers.equals(drawnNumbers);
    }
}
