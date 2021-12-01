package minigames;

import java.util.List;
import minigames.GameResult.Result;

public class GameService {
    // globalny stan
    Introduction introduction = new Introduction();
    SelectUserNumbers selectNumbers = new SelectUserNumbers();
    DrawNumbers drawNumbers = new DrawNumbers();
    GameResult gameResult = new GameResult();

    public void operateGame() {
        introduction.welcomeAndWaitForUserToStart();
        List<Integer> selectedUserNumbers = selectNumbers.selectingNumbersByUser();
        List<Integer> drawnNumbers = drawNumbers.drawingNumbers();
        Result result = gameResult.checkResultAndPrintMessage(selectedUserNumbers, drawnNumbers);

        // print result in new class ex. GamePrinter;

    }
}
