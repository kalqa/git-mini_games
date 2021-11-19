package minigames;

import java.util.List;

public class GameService {

    Introduction introduction = new Introduction();
    SelectUserNumbers selectNumbers = new SelectUserNumbers();
    DrawNumbers drawNumbers = new DrawNumbers();
    GameResult gameResult = new GameResult();

    public void operateGame() {
        introduction.welcomeAndWaitForUserToStart();
        List<Integer> selectedUserNumbers = selectNumbers.selectingNumbersByUser();
        List<Integer> drawnNumbers = drawNumbers.drawingNumbers();
        gameResult.checkResultAndPrintMessage(selectedUserNumbers, drawnNumbers);
    }
}
