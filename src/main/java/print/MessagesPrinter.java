package print;

import api.Printable;

public class MessagesPrinter implements Printable {

    public MessagesPrinter() {
    }

    @Override
    public void sendMessageToUser(String text) {
        System.out.println(text);
    }
}
