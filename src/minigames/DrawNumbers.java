package minigames;

import java.util.*;

public class DrawNumbers implements GameInterface {

    private final String name;
    private final String description;
    private final int amountOfNumbers = 6;
    private final int lowestNumber = 1;
    private final int highestNumber = 99;
    List<Integer> drawnNumbers = new ArrayList<>();
    List<Integer> selectedUserNumbers = new ArrayList<>();
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
            boolean addDrawnNumber = true;

            for (int number : drawnNumbers) {
                if (number == randomNumber) {
                    i--;
                    addDrawnNumber = false;
                    break;
                }
            }

            if (addDrawnNumber) {
                drawnNumbers.add(i, randomNumber);
            }
        }
        for (int number : drawnNumbers) {
            System.out.println(number);
        }
    }

    public void sortDrawnNumbers() {
        Collections.sort(drawnNumbers);
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
            boolean addSelectedNumber = true;

            for (int number : selectedUserNumbers) {
                if (number == typedNumber) {
                    System.out.println("Wytypowałeś już tę liczbę wcześniej");
                    System.out.println("Spróbuj jeszcze raz");
                    i--;
                    addSelectedNumber = false;
                    break;
                }
            }

            if (typedNumber < lowestNumber || typedNumber > highestNumber) {
                System.out.println("Wytypowałeś liczbę spoza zakresu " + lowestNumber + "-" + highestNumber);
                System.out.println("Spróbuj jeszcze raz");
                addSelectedNumber = false;
                i--;
            }
            if (addSelectedNumber) {
                selectedUserNumbers.add(i, typedNumber);
            }
        }
    }

    private void sortSelectedUserNumbers() {
        Collections.sort(selectedUserNumbers);
    }

    @Override
    public void endGame() {
        compareDrawnAndSelectedUserNumbers();
        printDrawnNumbers();
        printSelectedUserNumbers();
    }

    private void compareDrawnAndSelectedUserNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (selectedUserNumbers.get(i) != drawnNumbers.get(i)) {
                System.out.println("Pudło. Niestety, nie trafiłeś w wylosowane liczby");
                break;
            } else if (i == (amountOfNumbers - 1) && selectedUserNumbers.get(i) == drawnNumbers.get(i)) {
                System.out.println("Wygrałeś. Trafiłeś/aś we wszystkie wylosowane liczby");
            }
        }
    }

    private void printDrawnNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (drawnNumbers.get(i) < 10) {
                System.out.print("0" + drawnNumbers.get(i) + " ");
            } else {
                System.out.print(drawnNumbers.get(i) + " ");
            }
        }
        System.out.println("- to wylosowane liczby");
    }

    private void printSelectedUserNumbers() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (selectedUserNumbers.get(i) < 10) {
                System.out.print("0" + selectedUserNumbers.get(i) + " ");
            } else {
                System.out.print(selectedUserNumbers.get(i) + " ");
            }
        }
        System.out.println("- to Twoje wytypowane liczby");
    }
}



