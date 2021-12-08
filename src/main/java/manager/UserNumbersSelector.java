package manager;

import api.InputReceiver;
import service.InputReceiverScanner;

import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeSet;

import static configuration.GameConfiguration.*;
import static configuration.MessagesConfiguration.*;

public class UserNumbersSelector {

    static class InputResult {
        private final boolean inputError;
        private final int typedNumber;

        public InputResult(boolean inputError, int typedNumber) {
            this.inputError = inputError;
            this.typedNumber = typedNumber;
        }
    }

    InputReceiver inputReceiver = new InputReceiverScanner();

    public UserNumbersSelector() {
    }

    public Set<Integer> selectingNumbersByUser() {
        Set<Integer> selectedUserNumbers = new TreeSet<>();

        while (selectedUserNumbers.size() < AMOUNT_OF_NUMBERS) {
            int actualInputNumber = 1;
            System.out.println(WRITE_NUMBER + actualInputNumber + ":");
            InputResult inputResult = takeUserInput();

            if (inputResult.inputError) {
                System.out.println(INPUT_ERROR);
            } else {
                if (isTypedNumberIsOutOfRange(inputResult.typedNumber)) {
                    System.out.println(NUMBER_SELECTED_OUT_OF_RANGE + LOWEST_NUMBER + "-" + HIGHEST_NUMBER + TRY_AGAIN);
                } else if (isTypedNumberSelectedBefore(inputResult.typedNumber, selectedUserNumbers)) {
                    System.out.println(NUMBER_SELECTED_BEFORE);
                } else {
                    selectedUserNumbers.add(inputResult.typedNumber);
                    actualInputNumber++;
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
