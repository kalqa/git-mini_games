package minigames;

import java.util.List;

public class GameService {

    InputReceiver inputReceiverScanner = new InputReceiverScanner();
    SelectUserNumbers selectNumbers = new SelectUserNumbers();
    DrawNumbers drawNumbers = new DrawNumbers();
    GameResult gameResult = new GameResult();

    public void operateGame() {
        welcomeAndWaitForUserToStart();
        List<Integer> selectedUserNumbers = selectNumbers.selectingNumbersByUser();
        List<Integer> drawnNumbers = drawNumbers.drawingNumbers();
        boolean winOrLost = gameResult.checkResultAndPrintMessage(selectedUserNumbers, drawnNumbers);
    }

    private boolean welcomeAndWaitForUserToStart() {
        System.out.println("Witaj w grze Lotek.");
        System.out.println("Wpisz kolejno 6 wytypowanych przez Ciebie liczb pomiędzy 1-99");
        System.out.println("Każdą wytypowaną liczbę zatwierdź ENTERem.");
        System.out.println("Wciśnij ENTER aby rozpocząć grę");
        inputReceiverScanner.nextLine();
        System.out.println("Powodzenia :)");
        return true;
    }
}
