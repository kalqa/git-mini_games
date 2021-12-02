package manager;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResultCheckerTests {

    @Test
    void checkResult__Returns_not_null__When_selected_and_drawn_numbers_are_checking() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //  when
        ResultChecker.GameResult gameResult = resultChecker.checkResult(selectedNumbers, drawnNumbers);

        //  then
        assertNotNull(gameResult);
    }

    @Test
    void checkResult__Returns_win_result__When_selected_and_drawn_numbers_are_equal() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //  when
        ResultChecker.GameResult gameResult = resultChecker.checkResult(selectedNumbers, drawnNumbers);
        boolean isWin = gameResult.isWin;

        //  then
        assertTrue(isWin);
    }

    @Test
    void checkResult__Returns_lose_result__When_selected_and_drawn_numbers_are_not_equal() {
        //  given
        ResultChecker resultChecker = new ResultChecker();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        //  when
        ResultChecker.GameResult gameResult = resultChecker.checkResult(selectedNumbers, drawnNumbers);
        boolean isWin = gameResult.isWin;

        //  then
        assertFalse(isWin);
    }
}