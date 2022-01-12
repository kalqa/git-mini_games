package numbers.select;

import api.InputReceiver;
import api.Printable;

import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeSet;

import static configuration.GameConfiguration.*;
import static configuration.MessagesConfiguration.*;

public class UserNumbersSelector {

    InputReceiver inputReceiver;
    private final Printable printable;

    public UserNumbersSelector(InputReceiver inputReceiver, Printable printable) {
        this.inputReceiver = inputReceiver;
        this.printable = printable;
    }

    static class InputResult {
        private final boolean inputError;
        private final int typedNumber;

        public InputResult(boolean inputError, int typedNumber) {
            this.inputError = inputError;
            this.typedNumber = typedNumber;
        }
    }

    public Set<Integer> selectingNumbersByUser() {
        Set<Integer> selectedUserNumbers = new TreeSet<>();
        int actualInputNumber = 1;

        while (selectedUserNumbers.size() < AMOUNT_OF_NUMBERS) {
            printable.sendMessageToUser(WRITE_NUMBER + actualInputNumber + ":");
            InputResult inputResult = takeUserInput();

            if (inputResult.inputError) {
                printable.sendMessageToUser(INPUT_ERROR);
            } else {
                if (isTypedNumberIsOutOfRange(inputResult.typedNumber)) {
                    printable.sendMessageToUser(NUMBER_SELECTED_OUT_OF_RANGE + LOWEST_NUMBER + "-" + HIGHEST_NUMBER + TRY_AGAIN);
                } else {
                    selectedUserNumbers.add(inputResult.typedNumber);
                    if (selectedUserNumbers.size() < actualInputNumber) {
                        printable.sendMessageToUser(NUMBER_SELECTED_BEFORE);
                    } else {
                        actualInputNumber++;
                    }
                }
            }
        }
        return selectedUserNumbers;
    }

    private InputResult takeUserInput() {
        boolean inputError = false;
        int typedNumber = 0;
        try {
            typedNumber = inputReceiver.nextInt();
        } catch (InputMismatchException e) {
            inputError = true;
        } finally {
            inputReceiver.enterButton();
        }
        return new InputResult(inputError, typedNumber);
    }


    private boolean isTypedNumberSelectedBefore(int typedNumber, Set<Integer> selectedUserNumbers) {
        for (int number : selectedUserNumbers) {
            if (number == typedNumber) {
                return true;
            }
        }
        return false;
    }

    private boolean isTypedNumberIsOutOfRange(int typedNumber) {
        return typedNumber < LOWEST_NUMBER || typedNumber > HIGHEST_NUMBER;
    }
}
