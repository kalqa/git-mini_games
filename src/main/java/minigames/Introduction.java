package minigames;

import static minigames.Messages.GAME_ENTERED;
import static minigames.Messages.INTRODUCTION;

public class Introduction {

    InputReceiver inputReceiverScanner = new InputReceiverScanner();

    boolean welcomeAndWaitForUserToStart() {
        System.out.println(INTRODUCTION);
        inputReceiverScanner.nextLine();
        System.out.println(GAME_ENTERED);
        return true;
    }
}
