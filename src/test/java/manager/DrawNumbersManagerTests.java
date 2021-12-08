package manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import static configuration.GameConfiguration.HIGHEST_NUMBER;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DrawNumbersManagerTests {

    @Test
    void drawingNumbers__Returns_not_null_list__When_draws_numbers() {
        //  given
        DrawNumbersManager drawNumbers = new DrawNumbersManager();
        //  when
        Set<Integer> resultList = drawNumbers.drawNumbers();

        //  then
        assertNotNull(resultList);
    }

    @Test
    void drawingNumbers__Size_of_returned_list_is_6__When_draws_numbers() {
        //  given
        DrawNumbersManager drawNumbers = new DrawNumbersManager();
        //  when
        Set<Integer> resultList = drawNumbers.drawNumbers();
        int resultSize = resultList.size();

        //  then
        assertEquals(resultSize, 6);
    }

  @Test
    void drawingNumbers__Lowest_number_in_set_is_in_range__When_draws_numbers() {
        //  given
        DrawNumbersManager drawNumbers = new DrawNumbersManager();
        //  when
        Set<Integer> drawnNumbers = drawNumbers.drawNumbers();

        Integer lowestNumber = Collections.min(drawnNumbers);
        boolean isInRange = preparedMethodForTest__isNumberInRange(lowestNumber);

        //  then
        assertTrue(isInRange);
    }

    @Test
    void drawingNumbers__Highest_number_in_set_is_in_range__When_draws_numbers() {
        //  given
        DrawNumbersManager drawNumbers = new DrawNumbersManager();
        //  when
        Set<Integer> drawnNumbers = drawNumbers.drawNumbers();

        Integer highestNumber = Collections.max(drawnNumbers);
        boolean isInRange = preparedMethodForTest__isNumberInRange(highestNumber);

        //  then
        assertTrue(isInRange);
    }

    private boolean preparedMethodForTest__isNumberInRange(int drawnNumber) {
        if (drawnNumber >= LOWEST_NUMBER && drawnNumber <= HIGHEST_NUMBER) {
            return true;
        }
        return false;
    }
}
