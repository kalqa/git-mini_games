package minigames;

import org.junit.jupiter.api.Test;
import java.util.List;

import static minigames.GameConfiguration.HIGHEST_NUMBER;
import static minigames.GameConfiguration.LOWEST_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

class DrawNumbersTests {

    @Test
    void should_check_NOT_null_resultList() {
        //given
        DrawNumbers drawNumbers = new DrawNumbers();
        //when
        List<Integer> resultList = drawNumbers.drawingNumbers();
        //expected
        assertNotNull(resultList);
    }

    @Test
    void should_return_size_of_drawnNumbersList() {
        //given
        DrawNumbers drawNumbers = new DrawNumbers();
        //when
        List<Integer> resultList = drawNumbers.drawingNumbers();
        int resultSize = resultList.size();
        //expected
        assertEquals(resultSize, 6);
    }

    @Test
    void should_drawnNumber_be_always_IN_range() {
        //given
        DrawNumbers drawNumbers = new DrawNumbers();
        //when
        List<Integer> resultList = drawNumbers.drawNumbers();
        int drawnNumber = resultList.get(3);
        boolean result = isInRange(drawnNumber);
        //expected
        assertTrue(result);
    }

    // czy w testach jest metoda ktora powinna byc w logice biznesowej?
    private boolean isInRange(int drawnNumber) {
        return (drawnNumber >= LOWEST_NUMBER) && (drawnNumber <= HIGHEST_NUMBER);
    }
}
