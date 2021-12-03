package manager;

import api.InputReceiver;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import service.InputReceiverScanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import static configuration.GameConfiguration.HIGHEST_NUMBER;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@Tag("Czy wartości testowe liczb wybieranych przez gracza nie powinny być uzależnione od LOWEST_NUMBER i HIGHER NUMBER?." +
        "Bo załóżmy, że zmienimy wartości LOWEST_NUMBER i HIGHER NUMBER np. na 50 i 100 i wtedy praktycznie całe testy w tej klasie lecą na głowę." +
        "Moje proponowane rozwiązanie to testowanie liczb względnych np. LOWEST_NUMBER, LOWEST_NUMBER+1, LOWEST_NUMBER+2, itd.")
class UserNumbersSelectorTests {

    @Tag("czy ma sens? Metoda selectingNumbersByUser() musi zwrócić listę, ale czy ja tutaj nie sprawdzam poprawnego działania biblioteki Mockito?")
    @Test
    void selectingNumbersByUser__Returns_not_null_list__When_UserNumbersSelector_is_mocked() {
        //  given
        UserNumbersSelector userNumbersSelector = mock(UserNumbersSelector.class);
        //  when
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();

        //  then
        assertNotNull(selectedUserNumbers);
    }

    @Tag("czy ma sens? Metoda selectingNumbersByUser() musi zwrócić listę z 6 liczbami, " +
            "ale ta metoda tylko otrzymuje tę listę od metody wewnętrznej selectingNumbersByUserAndCheckingInputError()")
    @Test
    void selectingNumbersByUser__Return_size_of_selected_numbers_by_user_list__When_6_numbers_was_select() {
        //  given
        UserNumbersSelector userNumbersSelector = mock(UserNumbersSelector.class);
        given(userNumbersSelector.selectingNumbersByUser()).willReturn(Arrays.asList(1, 2, 3, 4, 5, 6));
        //  when
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUser();
        int sizeOfList = selectedUserNumbers.size();

        //  then
        assertEquals(sizeOfList, 6);
    }

    @Test
    void selectingNumbersByUserAndCheckingInputError__Returns_correct_selected_numbers_list__When_typed_numbers_are_in_range_and_not_repeated() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn(1,2, 3, 4, 5, 6);

        List<Integer> expectedSelectedUserNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //  when
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUserAndCheckingInputError();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUserAndCheckingInputError__Returns_correct_selected_numbers_list__When_typed_number_is_repeated() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn(90,91, 91, 92, 93, 94, 95);

        List<Integer> expectedSelectedUserNumbers = Arrays.asList(90, 91, 92, 93, 94, 95);
        //  when
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUserAndCheckingInputError();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUserAndCheckingInputError__Returns_correct_selected_numbers_list__When_typed_number_is_out_range() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn(5, 15, 150, 25, 35, 45, 55);

        List<Integer> expectedSelectedUserNumbers = Arrays.asList(5, 15, 25, 35, 45, 55);
        //  when
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUserAndCheckingInputError();

        //  then
        assertEquals(expectedSelectedUserNumbers, selectedUserNumbers);
    }

    @Test
    void selectingNumbersByUserAndCheckingInputError__Returns_correct_selected_numbers_list__When_typed_series_of_numbers_are_repeated_and_out_of_range() {
        //  given
        UserNumbersSelector userNumbersSelector = new UserNumbersSelector();
        userNumbersSelector.inputReceiver = mock(InputReceiver.class);
        given(userNumbersSelector.inputReceiver.nextInt()).willReturn(11, 11, -5, (LOWEST_NUMBER-1), 22, 33, 33, 205, 44, 44, 55, (HIGHEST_NUMBER+1), 66);

        List<Integer> expectedSelectedUserNumbers = Arrays.asList(11, 22, 33, 44, 55, 66);
        //  when
        List<Integer> selectedUserNumbers = userNumbersSelector.selectingNumbersByUserAndCheckingInputError();

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