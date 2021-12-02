package service;

import manager.DrawNumbersManager;
import manager.ResultChecker;
import manager.Introduction;
import manager.ResultPrinter;
import manager.UserNumbersSelector;

import java.util.List;

public class GameService {

    Introduction introduction = new Introduction();
    UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
    DrawNumbersManager drawNumbers = new DrawNumbersManager();
    ResultChecker resultChecker = new ResultChecker();
    ResultPrinter resultPrinter = new ResultPrinter();

    public void operateGame() {
        introduction.welcomeAndWaitForUserToStart();
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();
        List<Integer> drawnNumbers = drawNumbers.drawingNumbers();
        ResultChecker.GameResult gameResult = resultChecker.checkResult(selectedUserNumbers, drawnNumbers);
        resultPrinter.printResult(gameResult);
    }
}
