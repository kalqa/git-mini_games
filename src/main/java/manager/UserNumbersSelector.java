package manager;

import api.InputReceiver;
import service.InputReceiverScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static configuration.GameConfiguration.*;
import static configuration.MessagesConfiguration.*;

public class UserNumbersSelector {

    InputReceiver inputReceiver = new InputReceiverScanner();

    public UserNumbersSelector() {
    }

    public List<Integer> selectingNumbersByUser() {
        List<Integer> selectedUserNumbers = selectingNumbersByUserAndCheckingInputError();
        sortNumbers(selectedUserNumbers);
        return selectedUserNumbers;
    }

    List<Integer> selectingNumbersByUserAndCheckingInputError() {
        List<Integer> selectedUserNumbers = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            System.out.println(WRITE_NUMBER + (i + 1) + ":");
            int typedNumber = inputReceiver.nextInt();
            boolean addSelectedNumber = true;

            if (isTypedNumberSelectedBefore(typedNumber, selectedUserNumbers) || isTypedNumberIsOutOfRange(typedNumber)) {
                addSelectedNumber = false;
                i--;
            }
            if (addSelectedNumber) {
                selectedUserNumbers.add(typedNumber);
            }
        }
        return selectedUserNumbers;
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

    private void sortNumbers(List<Integer> unsortedList) {
        Collections.sort(unsortedList);
    }
}
