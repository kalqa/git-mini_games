package minigames;

import minigames.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTests {

    @Test
    void test_numbers_EQUALS() {
        //given
        GameResult gameResult = new GameResult();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6); // lista na podstawie innej listy, wystarczy tak jak jest
        List<Integer> drawnNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        //when
        boolean result = gameResult.isDrawnNumbersEqualsSelectedUserNumbers(selectedNumbers, drawnNumbers);
        //expected
        assertTrue(result);
    }

    @Test
    void test_numbers_NOT_EQUALS() {
        //given
        GameResult gameResult = new GameResult();
        List<Integer> selectedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> drawnNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        //when
        boolean result = gameResult.isDrawnNumbersEqualsSelectedUserNumbers(selectedNumbers, drawnNumbers);
        //expected
        assertFalse(result);
    }

    @Test
    void should_return_false_result_when_numbers_are_equals_and_not_in_order() {
        // given
        GameResult gameResult = new GameResult();
        List<Integer> selectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> drawnNumbers = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));

        // when
        boolean numbersComparsionResult = gameResult.isDrawnNumbersEqualsSelectedUserNumbers(selectedNumbers, drawnNumbers);

        // then
        assertFalse(numbersComparsionResult);
    }
}
