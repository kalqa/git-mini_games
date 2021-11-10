package minigames;

import java.util.concurrent.atomic.AtomicInteger;

public class InputReceiverTestMock implements InputReceiver {

    AtomicInteger state = new AtomicInteger(1);

    @Override
    public void nextLine() {
        System.out.println("to jest nextline z testowej implementacji");
    }

    @Override
    public int nextInt() {
        return state.getAndIncrement();
    }
}
