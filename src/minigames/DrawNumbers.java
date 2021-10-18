package minigames;

import java.util.Arrays;
import java.util.Scanner;

public class DrawNumbers extends Game implements GameInterface {

    private final int amountOfNumbers = 6;
    private final int lowestNumber = 1;
    private final int highestNumber = 99;

    int[] correctNumbers = new int[amountOfNumbers];
    int[] typedNumbers = new int[amountOfNumbers];
    Scanner scanner = new Scanner(System.in);

    public DrawNumbers(String name, String description) {
        super(name, description);
    }

    public void operateGame() {
        if (this.startGame()) {
            gamePrepared = this.prepareGame();
        }

        if (gamePrepared) {
            gameToEnd = this.playGame();
        }

        if (gameToEnd) {
            DrawNumbers.this.endGame();
        }
    }

    @Override
    public boolean startGame() {
        System.out.println("Witaj w grze Lotek.");
        System.out.println("Wpisz kolejno 6 wytypowanych przez Ciebie liczb pomiędzy 1-99");
        System.out.println("Każdą wytypowaną liczbę zatwierdź ENTERem.");
        System.out.println("Wciśnij ENTER aby rozpocząć grę");
        scanner.nextLine();
        System.out.println("Powodzenia :)");
        return true;
    }

    @Override
    public boolean prepareGame() {
        //losowanie liczb
        for (int i = 0; i < amountOfNumbers; i++) {
            int randomNumber = (int) (Math.random() * 100);
            for (int number : correctNumbers) {
                if (randomNumber == number) {
                    i--;
                } else {
                    correctNumbers[i] = randomNumber;
                }
                break;
            }
        }

        //sortowanie liczb wylosowanych
        Arrays.sort(correctNumbers);
        for (int number : correctNumbers) {
            System.out.println(number);
        }
        return true;
    }

    @Override
    public boolean playGame() {
        for (int i = 0; i < amountOfNumbers; i++) {
            System.out.println("Podaj " + (i + 1) + " liczbę");
            int typedNumber = scanner.nextInt();
            boolean addNumber = true;

            //sprawdzenie czy nie powtórzono typu
            for (int j = 0; j < i; j++) {
                if (typedNumber == typedNumbers[j]) {
                    System.out.println("Wytypowałeś już te liczbę wcześniej");
                    System.out.println("Spróbuj jeszcze raz");
                    i--;
                    addNumber = false;
                    break;
                }
            }

            //sprawdzenie czy wytypowana liczba jest po za zakresem lub ujemna
            if (typedNumber < lowestNumber || typedNumber > highestNumber) {
                System.out.println("Wytypowałeś liczbę spoza zakresu");
                System.out.println("Spróbuj jeszcze raz");
                addNumber = false;
                i--;
            }
            if (addNumber) {
                typedNumbers[i] = typedNumber;
            }
        }
        //sortowanie liczb wytypowanych
        Arrays.sort(typedNumbers);
        return true;
    }

    @Override
    public void endGame() {
        for (int i = 0; i < amountOfNumbers; i++) {
            if (typedNumbers[i] != correctNumbers[i]) {
                System.out.println("Pudło. Niestety, nie trafiłeś w wylosowane liczby");
                break;
            } else if (i == (amountOfNumbers - 1) && typedNumbers[i] == correctNumbers[i]) {
                System.out.println("Wygrałeś. Trafiłeś/aś we wszystkie wylosowane liczby");
            }
        }

        for (int i = 0; i < amountOfNumbers; i++) {
            if (correctNumbers[i] < 10) {
                System.out.print("0" + correctNumbers[i] + " ");
            } else {
                System.out.print(correctNumbers[i] + " ");
            }
        }
        System.out.println("- to wylosowane liczby");

        for (int i = 0; i < amountOfNumbers; i++) {
            if (typedNumbers[i] < 10) {
                System.out.print("0" + typedNumbers[i] + " ");
            } else {
                System.out.print(typedNumbers[i] + " ");
            }
        }
        System.out.println("- to Twoje wytypowane liczby");
    }
}



