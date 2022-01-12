package input;

import api.InputReceiver;

import java.util.Scanner;

public class InputReceiverScanner implements InputReceiver {

    private final Scanner scanner = new Scanner(System.in);

    public InputReceiverScanner() {
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public boolean enterButton() {
        scanner.nextLine();
        return true;
    }
}
