package minigames;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static minigames.GameConfiguration.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class SelectUserNumbersTests {

    @Test
    public void should_check_NOT_null_resultList() {
        //given
        SelectUserNumbers selectUserNumbers = Mockito.mock(SelectUserNumbers.class);
        //when
        List<Integer> resultList = selectUserNumbers.selectingNumbersByUser();
        System.out.println(resultList.size());
        //expected
        assertNotNull(resultList);
    }

    @Disabled
    public void should_return_user_numbers_list() {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();
        InputReceiver inputReceiver = new InputReceiverScanner();
        List<Integer> seriesOfTypedNumbers = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 5, 6));
        //for (int i = 0; i < AMOUNT_OF_NUMBERS; i++) {

        given(inputReceiver.nextInt()).willReturn(seriesOfTypedNumbers.get(0));
        selectUserNumbers.selectingNumbersByUserAndCheckingInputError();
        given(inputReceiver.nextInt()).willReturn(seriesOfTypedNumbers.get(1));
        List<Integer> result =  selectUserNumbers.selectingNumbersByUserAndCheckingInputError();

        //when

        //expected
        assertEquals(result, Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void should_return_of_user_numbers_list() {
        //given
        SelectUserNumbers selectUserNumbers = Mockito.mock(SelectUserNumbers.class);
        List<Integer> selectedUserNumbers = new ArrayList<>();
        given(selectUserNumbers.selectingNumbersByUser()).willReturn(preparedMockMethodFor_ReturnListOfUserNumbers());
        //when
        List<Integer> resultList = selectUserNumbers.selectingNumbersByUser();
        int resultSize = resultList.size();
        //expected
        assertEquals(resultSize, 6);
    }

    private List<Integer> preparedMockMethodFor_ReturnListOfUserNumbers() {
        List<Integer> mockSelectedUserNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return mockSelectedUserNumbers;
    }

    @Test
    public void test_number_is_NOT_IN_range_Higher() {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();
        int typedNumber = 100;
        //when
        boolean result = selectUserNumbers.ifTypedNumberIsOutOfRange(typedNumber, LOWEST_NUMBER, HIGHEST_NUMBER);
        //expected
        assertTrue(result);
    }

    @Test
    public void test_number_is_NOT_IN_range_Lower () {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();
        int typedNumber = -2;
        //when
        boolean result = selectUserNumbers.ifTypedNumberIsOutOfRange(typedNumber, LOWEST_NUMBER, HIGHEST_NUMBER);
        //expected
        assertTrue(result);
    }

    @Test
    public void test_number_is_IN_range () {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();
        int typedNumber = 50;
        //when
        boolean result = selectUserNumbers.ifTypedNumberIsOutOfRange(typedNumber, LOWEST_NUMBER, HIGHEST_NUMBER);
        //expected
        assertFalse(result);
    }

    @Test
    public void test_number_WAS_selected_before () {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();
        selectUserNumbers.selectedUserNumbers.add(50);
        int typedNumber = 50;
        //when
        boolean result = selectUserNumbers.ifTypedNumberSelectedBefore(typedNumber);
        //expected
        assertTrue(result);
    }

    @Test
    public void test_number_WAS_NOT_selected_before () {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();
        selectUserNumbers.selectedUserNumbers.add(99);
        int typedNumber = 98;
        //when
        boolean result = selectUserNumbers.ifTypedNumberSelectedBefore(typedNumber);
        //expected
        assertFalse(result);
    }
}