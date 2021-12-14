package welcomer;

import api.InputReceiver;
import printer.MessagesPrinter;
import scanner.InputReceiverScanner;

import static configuration.MessagesConfiguration.GAME_ENTERED;
import static configuration.MessagesConfiguration.INTRODUCTION;

public class UserWelcomer {

    private final InputReceiver inputReceiverScanner = new InputReceiverScanner();
    private final MessagesPrinter messagesPrinter = new MessagesPrinter();

    public UserWelcomer() {
    }

    public void welcomeAndWaitForUserToStart() {
        messagesPrinter.sendMessageToUser(INTRODUCTION);
        inputReceiverScanner.enterButton();
        messagesPrinter.sendMessageToUser(GAME_ENTERED);
    }
}
