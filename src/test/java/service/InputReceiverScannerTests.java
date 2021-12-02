package service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@Tag("Stwierdziłem na podstawie książki \"Złe testy, dobre testy\", że te testy są bezsensowne, " +
        "ponieważ sprawdzają tak naprawdę prawidłowe działanie biblioteki Mockito. Czy dobrze myślę?")
class InputReceiverScannerTests {

    @Disabled
    @Test
    void should_return_positive_int() {
        //  given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(5);
        //  when
        int typedInt = inputReceiverScanner.nextInt();

        //  then
        assertEquals(typedInt, 5);
    }

    @Disabled
    @Test
    void should_return_negative_int() {
        //  given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(-14);
        //  when
        int typedInt = inputReceiverScanner.nextInt();

        //  then
        assertEquals(typedInt, -14);
    }

    @Disabled
    @Test
    void should_return_true() {
        //  given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.enterButton()).willReturn(true);
        //  when
        boolean isButtonPressed = inputReceiverScanner.enterButton();

        //  then
        assertTrue(isButtonPressed);
    }
}
