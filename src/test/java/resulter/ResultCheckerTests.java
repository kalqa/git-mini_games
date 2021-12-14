package resulter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static configuration.GameConfiguration.LOWEST_NUMBER;
import static configuration.MessagesConfiguration.LOSE_INFORMATION;
import static configuration.MessagesConfiguration.WIN_INFORMATION;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultCheckerTests {

    final int LN = LOWEST_NUMBER;

    @Test
    void checkResult__Returns_win_message__When_selected_and_drawn_numbers_are_equal() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        Set<Integer> selectedNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));
        Set<Integer> drawnNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));
        //  when
        ResultChecker.ResultMessage resultMessage = resultChecker.checkResult(selectedNumbers, drawnNumbers);

        //  then
        assertEquals(WIN_INFORMATION, resultMessage.getResultMessage());
    }

    @Test
    void checkResult__Returns_lose_message__When_selected_and_drawn_numbers_are_not_equal() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        Set<Integer> selectedNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));
        Set<Integer> drawnNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 7)));
        //  when
        ResultChecker.ResultMessage resultMessage = resultChecker.checkResult(selectedNumbers, drawnNumbers);

        //  then
        assertEquals(LOSE_INFORMATION, resultMessage.getResultMessage());
    }
}