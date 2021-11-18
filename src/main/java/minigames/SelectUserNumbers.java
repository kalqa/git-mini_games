package minigames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static minigames.GameConfiguration.*;
import static minigames.GameConfiguration.HIGHEST_NUMBER;

public class SelectUserNumbers {

    List<Integer> selectedUserNumbers = new ArrayList<>();
    InputReceiver inputReceiver = new InputReceiverScanner();

    public SelectUserNumbers() {
    }

    List<Integer> selectingNumbersByUser() {
        selectedUserNumbers = selectingNumbersByUserAndCheckingInputError();
        sortNumbers(selectedUserNumbers);
        return selectedUserNumbers;
    }

    private List<Integer> selectingNumbersByUserAndCheckingInputError() {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            System.out.println("Podaj " + (i + 1) + " liczbę");
            int typedNumber = inputReceiver.nextInt();

            boolean ifAddSelectedNumber = true;
            for (int number : selectedUserNumbers) {
                if (number == typedNumber) {
                    System.out.println("Wytypowałeś już tę liczbę wcześniej");
                    System.out.println("Spróbuj jeszcze raz");
                    i--;
                    ifAddSelectedNumber = false;
                    break;
                }
            }
            if (ifTypedNumberIsOutOfRange(typedNumber, LOWEST_NUMBER, HIGHEST_NUMBER)) {
                System.out.println("Wytypowałeś liczbę spoza zakresu " + LOWEST_NUMBER + "-" + HIGHEST_NUMBER);
                System.out.println("Spróbuj jeszcze raz");
                ifAddSelectedNumber = false;
                i--;
            }

            if (ifAddSelectedNumber) {
                selectedUserNumbers.add(i, typedNumber);
            }
        }
        return selectedUserNumbers;
    }

    private boolean ifTypedNumberIsOutOfRange(int typedNumber, int LOWEST_NUMBER, int HIGHEST_NUMBER) {
        if (typedNumber < LOWEST_NUMBER) {
            return true;
        } else if (typedNumber > HIGHEST_NUMBER) {
            return true;
        } else {
            return false;
        }
    }

    private void sortNumbers(List<Integer> unsortedList) {
        Collections.sort(unsortedList);
    }
}
