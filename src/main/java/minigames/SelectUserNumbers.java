package minigames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static minigames.GameConfiguration.*;
import static minigames.Messages.*;

public class SelectUserNumbers {

    InputReceiver inputReceiver = new InputReceiverScanner();
    List<Integer> selectedUserNumbers = new ArrayList<>();

    public SelectUserNumbers() {
    }

    List<Integer> selectingNumbersByUser() {
        selectingNumbersByUserAndCheckingInputError();
        sortNumbers(selectedUserNumbers);
        return selectedUserNumbers;
    }

    List<Integer> selectingNumbersByUserAndCheckingInputError() {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            System.out.println(WRITE_NUMBER + (i + 1) + ":");
            int typedNumber = inputReceiver.nextInt();
            boolean ifAddSelectedNumber = true;

            if (ifTypedNumberSelectedBefore(typedNumber) || ifTypedNumberIsOutOfRange(typedNumber, LOWEST_NUMBER, HIGHEST_NUMBER)) {
                ifAddSelectedNumber = false;
                i--;
            }
            if (ifAddSelectedNumber) {
                selectedUserNumbers.add(i, typedNumber);
            }
        }
        return selectedUserNumbers;
    }

    boolean ifTypedNumberSelectedBefore(int typedNumber) {
        for (int number : selectedUserNumbers) {
            if (number == typedNumber) {
                System.out.println(NUMBER_SELECTED_BEFORE);
                return true;
            }
        }
        return false;
    }

    boolean ifTypedNumberIsOutOfRange(int typedNumber, int LOWEST_NUMBER, int HIGHEST_NUMBER) {
        if (typedNumber < LOWEST_NUMBER || typedNumber > HIGHEST_NUMBER) {
            System.out.println(NUMBER_SELECTED_OUT_OF_RANGE + LOWEST_NUMBER + "-" + HIGHEST_NUMBER + TRY_AGAIN);
            return true;
        }
        return false;
    }

    void sortNumbers(List<Integer> unsortedList) {
        Collections.sort(unsortedList);
    }
}
