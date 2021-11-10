package minigames;

public class Main {

    public static void main(String[] args) {
        DrawNumbers drawNumbers = new DrawNumbers("Lotek",
                "Gracz typuje 6 liczb, następuje losowanie 6 liczb i sprawdzenie czy gracz trafił.",
                new InputScannerReceiver());
        drawNumbers.operateGame();
    }
}



