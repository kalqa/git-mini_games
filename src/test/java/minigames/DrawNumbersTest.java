package minigames;

import org.junit.jupiter.api.Test;

public class DrawNumbersTest {

    @Test
    public void shouldStartGame() {
        // given
        String asas = "Lotek";
        String asds = "Gracz typuje 6 liczb, następuje losowanie 6 liczb i sprawdzenie czy gracz trafił.";
        DrawNumbers drawNumbers = new DrawNumbers(asas, asds, new InputReceiverTestMock());

        // when
        drawNumbers.operateGame();

        // then
    }

}
