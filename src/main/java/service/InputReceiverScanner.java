package service;

import api.InputReceiver;

import java.util.Scanner;

public class InputReceiverScanner implements InputReceiver {

    Scanner scanner = new Scanner(System.in);
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
