package minigames;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static minigames.GameConfiguration.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class SelectUserNumbersTests {

    @Test
    void should_check_NOT_null_resultList() {
        //given
        SelectUserNumbers selectUserNumbers = Mockito.mock(SelectUserNumbers.class);
        //when
        List<Integer> resultList = selectUserNumbers.selectingNumbersByUser();
        System.out.println(resultList.size());
        //expected
        assertNotNull(resultList);
    }

    @Test
    public void should_Return_of_user_numbers_list_of_size_6() {
        //given
        SelectUserNumbers selectUserNumbers = Mockito.mock(SelectUserNumbers.class);
        List<Integer> selectedUserNumbers = new ArrayList<>();
        given(selectUserNumbers.selectingNumbersByUser()).willReturn(Arrays.asList(1, 2, 3, 4, 5, 6));
        //when
        List<Integer> resultList = selectUserNumbers.selectingNumbersByUser();
        int resultSize = resultList.size();
        //expected
        assertEquals(resultSize, 6);
    }

    @Test
    void typed_in_range_numbers_and_not_repeated_Return_numbers_list() {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();

        InputReceiver inputReceiverMock = mock(InputReceiver.class);
        selectUserNumbers.inputReceiver = inputReceiverMock;
        given(selectUserNumbers.inputReceiver.nextInt()).willReturn(1,2, 3, 4, 5, 6);

        //when
        List<Integer> result =  selectUserNumbers.selectingNumbersByUserAndCheckingInputError();

        //expected
        assertThat(result, is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void when_typed_repeated_number_Return_NOT_doubled_numbers_list() {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();

        InputReceiver inputReceiverMock = mock(InputReceiver.class);
        selectUserNumbers.inputReceiver = inputReceiverMock;
        given(selectUserNumbers.inputReceiver.nextInt()).willReturn(90,91, 91, 92, 93, 94, 95);

        //when
        List<Integer> result =  selectUserNumbers.selectingNumbersByUserAndCheckingInputError();

        //expected
        assertThat(result, is(Arrays.asList(90, 91, 92, 93, 94, 95)));
    }

    @Test
    void when_typed_out_of_range_number_Return_numbers_list_which_not_contains_this_number() {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();

        InputReceiver inputReceiverMock = mock(InputReceiver.class);
        selectUserNumbers.inputReceiver = inputReceiverMock;
        given(selectUserNumbers.inputReceiver.nextInt()).willReturn(5, 15, 150, 25, 35, 45, 55);

        //when
        List<Integer> result =  selectUserNumbers.selectingNumbersByUserAndCheckingInputError();

        //expected
        assertThat(result, is(Arrays.asList(5, 15, 25, 35, 45, 55)));
    }

    @Test
    void when_typed_out_of_range_or_doubled_number_Return_numbers_list_which_not_contains_this_number() {
        //given
        SelectUserNumbers selectUserNumbers = new SelectUserNumbers();

        InputReceiver inputReceiverMock = mock(InputReceiver.class);
        selectUserNumbers.inputReceiver = inputReceiverMock;
        given(selectUserNumbers.inputReceiver.nextInt()).willReturn(11, 11, -5, 22, 33, 33, 205, 44, 44, 55, 66);

        //when
        List<Integer> result =  selectUserNumbers.selectingNumbersByUserAndCheckingInputError();

        //expected
        assertThat(result, is(Arrays.asList(11, 22, 33, 44, 55, 66)));
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