package minigames;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTests {

    @Test
    public void test_numbers_EQUALS() {
        //given
        GameResult gameResult = new GameResult();
        List<Integer> selectedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> drawnNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        //when
        boolean result = gameResult.ifDrawnNumbersEqualsSelectedUserNumbers(selectedNumbers, drawnNumbers);
        //expected
        assertTrue(result);
    }

    @Test
    public void test_numbers_NOT_EQUALS() {
        //given
        GameResult gameResult = new GameResult();
        List<Integer> selectedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> drawnNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        //when
        boolean result = gameResult.ifDrawnNumbersEqualsSelectedUserNumbers(selectedNumbers, drawnNumbers);
        //expected
        assertFalse(result);
    }
}