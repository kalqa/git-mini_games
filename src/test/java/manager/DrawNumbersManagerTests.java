package manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
        List<Integer> resultList = drawNumbers.drawingNumbers();

        //  then
        assertNotNull(resultList);
    }

    @Test
    void drawingNumbers__Size_of_returned_list_is_6__When_draws_numbers() {
        //  given
        DrawNumbersManager drawNumbers = new DrawNumbersManager();
        //  when
        List<Integer> resultList = drawNumbers.drawingNumbers();
        int resultSize = resultList.size();

        //  then
        assertEquals(resultSize, 6);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void drawingNumbers__Numbers_returned_in_list_are_in_range__When_draws_numbers(int index) {
        //  given
        DrawNumbersManager drawNumbers = new DrawNumbersManager();
        //  when
        List<Integer> resultList = drawNumbers.drawNumbers();
        int drawnNumber = resultList.get(index);
        boolean isInRange = preparedMethodForTest__isNumberInRange(drawnNumber);

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
