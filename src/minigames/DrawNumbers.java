package minigames;

import java.util.Arrays;
import java.util.Scanner;

public class DrawNumbers implements GameInterface {

    private final String name;
    private final String description;
    private final int amountOfNumbers = 6;
    private final int lowestNumber = 1;
    private final int highestNumber = 99;
    int[] drawnNumbers = new int[amountOfNumbers];
    int[] selectedUserNumbers = new int[amountOfNumbers];
    Scanner scanner = new Scanner(System.in);

    public DrawNumbers(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void operateGame() {
        startGame();
        prepareGame();
        playGame();
        endGame();
    }

    @Override
    public void startGame() {
        System.out.println("Witaj w grze Lotek.");
        System.out.println("Wpisz kolejno 6 wytypowanych przez Ciebie liczb pomiędzy 1-99");
        System.out.println("Każdą wytypowaną liczbę zatwierdź ENTERem.");
        System.out.println("Wciśnij ENTER aby rozpocząć grę");
        scanner.nextLine();
        System.out.println("Powodzenia :)");
    }

    @Override
    public void prepareGame() {
        drawNumbers();
        sortDrawnNumbers();
    }

    public void drawNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            int randomNumber = (int) (Math.random() * 100);
            for (int number : drawnNumbers) {
                if (randomNumber == number) {
                    i--;
                } else {
                    drawnNumbers[i] = randomNumber;
                }
                break;
            }
        }
    }

    public void sortDrawnNumbers() {
        Arrays.sort(drawnNumbers);
    }

    @Override
    public void playGame() {
        selectingNumbersByUserAndCheckingInputError();
        sortSelectedUserNumbers();
    }

    private void selectingNumbersByUserAndCheckingInputError() {
        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.println("Podaj " + (i + 1) + " liczbę");
            int typedNumber = scanner.nextInt();
            boolean addNumber = true;

            for (int j = 0; j < i; j++) {
                if (typedNumber == selectedUserNumbers[j]) {
                    System.out.println("Wytypowałeś już tę liczbę wcześniej");
                    System.out.println("Spróbuj jeszcze raz");
                    i--;
                    addNumber = false;
                    break;
                }
            }

            if (typedNumber < lowestNumber || typedNumber > highestNumber) {
                System.out.println("Wytypowałeś liczbę spoza zakresu " + lowestNumber + "-" + highestNumber);
                System.out.println("Spróbuj jeszcze raz");
                addNumber = false;
                i--;
            }
            if (addNumber) {
                selectedUserNumbers[i] = typedNumber;
            }
        }
    }

    private void sortSelectedUserNumbers() {
        Arrays.sort(selectedUserNumbers);
    }

    @Override
    public void endGame() {
        compareDrawnAndSelectedUserNumbers();
        printDrawnNumbers();
        printSelectedUserNumbers();
    }

    private void compareDrawnAndSelectedUserNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (selectedUserNumbers[i] != drawnNumbers[i]) {
                System.out.println("Pudło. Niestety, nie trafiłeś w wylosowane liczby");
                break;
            } else if (i == (amountOfNumbers - 1) && selectedUserNumbers[i] == drawnNumbers[i]) {
                System.out.println("Wygrałeś. Trafiłeś/aś we wszystkie wylosowane liczby");
            }
        }
    }

    private void printDrawnNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (drawnNumbers[i] < 10) {
                System.out.print("0" + drawnNumbers[i] + " ");
            } else {
                System.out.print(drawnNumbers[i] + " ");
            }
        }
        System.out.println("- to wylosowane liczby");
    }

    private void printSelectedUserNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (selectedUserNumbers[i] < 10) {
                System.out.print("0" + selectedUserNumbers[i] + " ");
            } else {
                System.out.print(selectedUserNumbers[i] + " ");
            }
        }
        System.out.println("- to Twoje wytypowane liczby");
    }
}



