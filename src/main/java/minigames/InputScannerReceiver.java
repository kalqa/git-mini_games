package minigames;

import java.util.Scanner;

public class InputScannerReceiver implements InputReceiver {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void nextLine() {
        scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
