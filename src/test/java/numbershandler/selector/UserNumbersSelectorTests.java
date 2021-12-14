package numbershandler.selector;

import api.InputReceiver;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeSet;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.GameConfiguration.HIGHEST_NUMBER;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class UserNumbersSelectorTests {

    final int LN = LOWEST_NUMBER;
    final int HN = HIGHEST_NUMBER;

    @Tag("czy ma sens? Metoda selectingNumbersByUser() musi zwrócić listę, ale czy ja tutaj nie sprawdzam poprawnego działania biblioteki Mockito?")
    @Test
    void selectingNumbersByUser__Returns_not_null_set__When_UserNumbersSelector_is_mocked() {
        //  given
        UserNumbersSelector userNumbersSelector = mock(UserNumbersSelector.class);

        //  when
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();

        //  then
        assertNotNull(selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUser__Returns_proper_size_collection_of_user_numbers__When_amount_of_numbers_configuration_is_set() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn((LN - 2), (LN - 1), (LN + 1), (HN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6), (LN + 7));

        //  when
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();
        int sizeOfCollection = selectedUserNumbers.size();

        //  then
        assertEquals(sizeOfCollection, AMOUNT_OF_NUMBERS);
    }

    @Test
    void selectingNumbersByUser__Returns_correct_selected_user_numbers_collection__When_typed_numbers_are_in_range_and_not_repeated() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6));
        Set<Integer> expectedSelectedUserNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));

        //  when
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUser__Returns_correct_selected_user_numbers_collection__When_typed_number_is_repeated() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn((LN + 1), (LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6));
        Set<Integer> expectedSelectedUserNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));

        //  when
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUser__Returns_correct_selected_user_numbers_collection__When_typed_number_is_out_range() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn((LN + 1), (HN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN - 1), (LN + 6));
        Set<Integer> expectedSelectedUserNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));

        //  when
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUser__Returns_correct_selected_user_numbers_collection__When_typed_series_of_numbers_are_repeated_and_out_of_range() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn((LN - 5), (LN - 1), (LN + 1), (LN + 2), (LN + 3), (HN + 1), (LN + 4), (LN + 5), (LN + 1), (LN + 6));
        Set<Integer> expectedSelectedUserNumbers = new TreeSet<>(Arrays.asList((LN + 1), (LN + 2), (LN + 3), (LN + 4), (LN + 5), (LN + 6)));

        //  when
        Set<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Tag("czy ma sens? Tutaj sprawdzam tylko działanie biblioteki Mockito co nie ma sensu. " +
            "Ale nie wiem w jaki sposób zasymulować wpisanie przez gracza niedozwolonego znaku np. \", . : ! ?\" w metodzie i przez to rzucenie wyjątku. " +
            "Mockito nie pozwala na zwrócenie czegoś innego niż int przez metodę inputReceiver.nextInt()")
    @Test
    void inputReceiver_nextInt__Throws_exception__When_throws_exception() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willThrow(InputMismatchException.class);

        //  when
        //  then
        assertThrows(InputMismatchException.class, () -> userNumbersSelector.inputReceiver.nextInt());
    }
}