package minigames;

import static minigames.Messages.GAME_ENTERED;
import static minigames.Messages.INTRODUCTION;

public class Introduction {

    InputReceiver inputReceiverScanner = new InputReceiverScanner();

    void welcomeAndWaitForUserToStart() {
        System.out.println(INTRODUCTION);
        inputReceiverScanner.enterButton();
        System.out.println(GAME_ENTERED);
    }
}
