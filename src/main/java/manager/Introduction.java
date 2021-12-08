package manager;

import api.InputReceiver;
import service.MessagesPrinter;
import service.InputReceiverScanner;

import static configuration.MessagesConfiguration.GAME_ENTERED;
import static configuration.MessagesConfiguration.INTRODUCTION;

public class Introduction {

    private final InputReceiver inputReceiverScanner = new InputReceiverScanner();
    private final MessagesPrinter messagesPrinter = new MessagesPrinter();

    public Introduction() {
    }

    public void welcomeAndWaitForUserToStart() {
        messagesPrinter.sendMessageToUser(INTRODUCTION);
        inputReceiverScanner.enterButton();
        messagesPrinter.sendMessageToUser(GAME_ENTERED);
    }
}
