package minigames;

import java.util.List;

import static minigames.GameConfiguration.AMOUNT_OF_NUMBERS;

public class GameResult {

    boolean comparingNumbersAndShowWinOrLose(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {

        printDrawnNumbers();
        printSelectedUserNumbers();


        return true;

        return false;
    }

    private winOrLose
    compareDrawnAndSelectedUserNumbers();

    private boolean compareDrawnAndSelectedUserNumbers(List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (selectedUserNumbers.get(i) != drawnNumbers.get(i)) {
                //System.out.println("Pudło. Niestety, nie trafiłeś w wylosowane liczby");
                return false;
            } else if (ifLastSelectedUserNumberEqualsDrawnNumber(i, AMOUNT_OF_NUMBERS, selectedUserNumbers, drawnNumbers)) {
                //System.out.println("Wygrałeś. Trafiłeś/aś we wszystkie wylosowane liczby");
                return true;
            }
        }
    }

    private boolean ifLastSelectedUserNumberEqualsDrawnNumber(int i, int amountOfNumbers, List<Integer> selectedUserNumbers, List<Integer> drawnNumbers) {
        if (i == (amountOfNumbers - 1)) {
            if (selectedUserNumbers.get(i) == drawnNumbers.get(i)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void printDrawnNumbers() {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (drawnNumbers.get(i) < 10) {
                System.out.print("0" + drawnNumbers.get(i) + " ");
            } else {
                System.out.print(drawnNumbers.get(i) + " ");
            }
        }
        System.out.println("- to wylosowane liczby");
    }

    private void printSelectedUserNumbers() {
        for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {
            if (selectedUserNumbers.get(i) < 10) {
                System.out.print("0" + selectedUserNumbers.get(i) + " ");
            } else {
                System.out.print(selectedUserNumbers.get(i) + " ");
            }
        }
        System.out.println("- to Twoje wytypowane liczby");
    }
}
