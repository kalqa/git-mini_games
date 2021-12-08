package manager;

import api.InputReceiver;
import service.InputReceiverScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

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

    public List<Integer> selectingNumbersByUser() {
        List<Integer> selectedUserNumbers = selectingNumbersByUserAndCheckingInputError();
        Collections.sort(selectedUserNumbers);
        return selectedUserNumbers;
    }

    List<Integer> selectingNumbersByUserAndCheckingInputError() {
        List<Integer> selectedUserNumbers = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            System.out.println(WRITE_NUMBER + (i + 1) + ":");

            InputResult inputResult = takeUserInput();
            if (inputResult.inputError) {
                i--;
            }
            else {
                if (isTypedNumberSelectedBefore(inputResult.typedNumber, selectedUserNumbers) || isTypedNumberIsOutOfRange(inputResult.typedNumber)) {
                    i--;
                }
                else {
                    selectedUserNumbers.add(inputResult.typedNumber);
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
            System.out.println(INPUT_ERROR);
            inputError = true;
        } finally {
            inputReceiver.enterButton();
        }
        return new InputResult(inputError, typedNumber);
    }


    private boolean isTypedNumberSelectedBefore(int typedNumber, List<Integer> selectedUserNumbers) {
        for (int number : selectedUserNumbers) {
            if (number == typedNumber) {
                System.out.println(NUMBER_SELECTED_BEFORE);
                return true;
            }
        }
        return false;
    }

    private boolean isTypedNumberIsOutOfRange(int typedNumber) {
        if (typedNumber < LOWEST_NUMBER || typedNumber > HIGHEST_NUMBER) {
            System.out.println(NUMBER_SELECTED_OUT_OF_RANGE + LOWEST_NUMBER + "-" + HIGHEST_NUMBER + TRY_AGAIN);
            return true;
        }
        return false;
    }
}
