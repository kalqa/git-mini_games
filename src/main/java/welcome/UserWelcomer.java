package welcome;

import api.InputReceiver;
import print.MessagesPrinter;

import static configuration.MessagesConfiguration.GAME_ENTERED;
import static configuration.MessagesConfiguration.INTRODUCTION;

public class UserWelcomer {

    private final InputReceiver inputReceiverScanner;
    private final MessagesPrinter messagesPrinter;

    public UserWelcomer(InputReceiver inputReceiverScanner, MessagesPrinter messagesPrinter) {
        this.inputReceiverScanner = inputReceiverScanner;
        this.messagesPrinter = messagesPrinter;
    }

    public void welcomeAndWaitForUserToStart() {
        messagesPrinter.sendMessageToUser(INTRODUCTION);
        inputReceiverScanner.enterButton();
        messagesPrinter.sendMessageToUser(GAME_ENTERED);
    }
}
