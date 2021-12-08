package service;

import manager.DrawNumbersManager;
import manager.ResultChecker;
import manager.Introduction;
import manager.ResultPrinter;
import manager.UserNumbersSelector;

import java.util.Set;

public class GameService {

    Introduction introduction = new Introduction();
    UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
    DrawNumbersManager drawNumbers = new DrawNumbersManager();
    ResultChecker resultChecker = new ResultChecker();
    ResultPrinter resultPrinter = new ResultPrinter();

    public void operateGame() {
        introduction.welcomeAndWaitForUserToStart();
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();
        Set<Integer> drawnNumbers = drawNumbers.drawNumbers();
        String gameResult = resultChecker.checkResult(selectedUserNumbers, drawnNumbers);
        resultPrinter.printResult(gameResult, selectedUserNumbers, drawnNumbers);
    }
}
