package manager;

import java.util.List;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.MessagesConfiguration.LOST_INFORMATION;
import static configuration.MessagesConfiguration.WIN_INFORMATION;

public class ResultChecker {

    public static class GameResult {

        List<Integer> selectedUserNumbers;
        List<Integer> drawnNumbers;
        boolean isWin;

        public GameResult(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers, boolean isWin) {
            this.selectedUserNumbers = selectedUserNumbers;
            this.drawnNumbers = drawnNumbers;
            this.isWin = isWin;
        }
    }

    public GameResult checkResult(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {
        boolean isWin = isDrawnNumbersEqualsSelectedUserNumbers(selectedUserNumbers, drawnNumbers);
        return new GameResult(selectedUserNumbers, drawnNumbers, isWin);
    }

    private boolean isDrawnNumbersEqualsSelectedUserNumbers(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {
        boolean equals = false;
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (!selectedUserNumbers.get(i).equals(drawnNumbers.get(i))) {
                equals = false;
                break;
            } else {
                equals = true;
            }
        }
        return equals;
    }
}