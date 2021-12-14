package service;

import numbershandler.drawer.NumbersDrawer;
import resulter.ResultChecker;
import welcomer.UserWelcomer;
import resulter.ResultPrinter;
import numbershandler.selector.UserNumbersSelector;

import java.util.Set;

public class GameService {

    UserWelcomer userWelcomer = new UserWelcomer();
    UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
    NumbersDrawer drawNumbers = new NumbersDrawer();
    ResultChecker resultChecker = new ResultChecker();
    ResultPrinter resultPrinter = new ResultPrinter();

    public void operateGame() {
        userWelcomer.welcomeAndWaitForUserToStart();
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();
        Set<Integer> drawnNumbers = drawNumbers.drawNumbers();
        ResultChecker.ResultMessage resultMessage = resultChecker.checkResult(selectedUserNumbers, drawnNumbers);
        resultPrinter.printResult(resultMessage, selectedUserNumbers, drawnNumbers);
    }
}
