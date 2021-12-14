package resulter;

import java.util.Set;

import static configuration.MessagesConfiguration.LOSE_INFORMATION;
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

        private static ResultMessage getWinMessage() {
            return new ResultMessage(ResultInformation.WIN.information);
        }

        private static ResultMessage getLoseMessage() {
            return new ResultMessage(ResultInformation.LOSE.information);
        }

        private enum ResultInformation {
            WIN(WIN_INFORMATION),
            LOSE(LOSE_INFORMATION);

            public final String information;

            ResultInformation(String information) {
                this.information = information;
            }
        }
    }

    public ResultMessage checkResult(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        boolean isWin = isDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        if (!isWin) {
            return ResultMessage.getLoseMessage();
        } else {
            return ResultMessage.getWinMessage();
        }
    }

    private boolean isDrawnNumbersEqualsSelectedUserNumbers(Set<Integer> selectedUserNumbers, Set<Integer> drawnNumbers) {
        return selectedUserNumbers.equals(drawnNumbers);
    }
}