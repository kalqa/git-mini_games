package service;

import numbers.draw.NumbersDrawer;
import print.MessagesPrinter;
import result.ResultChecker;
import input.InputReceiverScanner;
import welcome.UserWelcomer;
import result.ResultPrinter;
import numbers.select.UserNumbersSelector;

import java.util.Set;

public class GameService {

    UserWelcomer userWelcomer = new UserWelcomer(new InputReceiverScanner(), new MessagesPrinter());
    UserNumbersSelector userNumbersSelector = new UserNumbersSelector(new InputReceiverScanner(), new MessagesPrinter());
    NumbersDrawer drawNumbers = new NumbersDrawer();
    ResultChecker resultChecker = new ResultChecker();
    ResultPrinter resultPrinter = new ResultPrinter(new MessagesPrinter());

    public void operateGame() {
        userWelcomer.welcomeAndWaitForUserToStart();
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();
        Set<Integer> drawnNumbers = drawNumbers.drawNumbers();
        ResultChecker.ResultMessage resultMessage = resultChecker.checkResult(selectedUserNumbers, drawnNumbers);
        resultPrinter.printResult(resultMessage, selectedUserNumbers, drawnNumbers);
    }
}
