package manager;

import api.InputReceiver;
import service.InputReceiverScanner;

import static configuration.MessagesConfiguration.GAME_ENTERED;
import static configuration.MessagesConfiguration.INTRODUCTION;

public class Introduction {

    private final InputReceiver inputReceiverScanner = new InputReceiverScanner();

    public void welcomeAndWaitForUserToStart() {
        System.out.println(INTRODUCTION);
        inputReceiverScanner.enterButton();
        System.out.println(GAME_ENTERED);
    }
}
