package printer;

import api.Printable;

public class MessagesPrinter implements Printable {

    @Override
    public void sendMessageToUser(String text) {
        System.out.println(text);
    }
}
