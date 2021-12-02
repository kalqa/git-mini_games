package manager;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static configuration.MessagesConfiguration.LOST_INFORMATION;
import static configuration.MessagesConfiguration.WIN_INFORMATION;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultCheckerTests {

    @Test
    void checkResult__Returns_win_message__When_selected_and_drawn_numbers_are_equal() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //  when
        String message = resultChecker.checkResult(selectedNumbers, drawnNumbers);

        //  then
        assertEquals(WIN_INFORMATION, message);
    }

    @Test
    void checkResult__Returns_lose_message__When_selected_and_drawn_numbers_are_not_equal() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        //  when
        String message = resultChecker.checkResult(selectedNumbers, drawnNumbers);

        //  then
        assertEquals(LOST_INFORMATION, message);
    }
}