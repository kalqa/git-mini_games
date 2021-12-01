package minigames;

import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class InputReceiverScannerTests {

    @Test
    void should_return_positive_int() {
        //given
        InputReceiver inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(5);
        //when
        int result = inputReceiverScanner.nextInt();
        //expected
        assertEquals(result, 5);
    }

    @Test
    void should_return_negative_int() {
        //given
        InputReceiver inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(-14);
        //when
        int result = inputReceiverScanner.nextInt();
        //expected
        assertEquals(result, -14);
    }

    @Test
    void should_return_true() {
        //given
        InputReceiver inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.enterButton()).willReturn(true);
        //when
        boolean result = inputReceiverScanner.enterButton();
        //expected
        assertTrue(result);
    }
}
