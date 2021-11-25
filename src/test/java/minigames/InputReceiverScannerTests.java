package minigames;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

class InputReceiverScannerTests {

    @Test
    public void should_return_positive_int() {
        //given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(5);
        //when
        int result = inputReceiverScanner.nextInt();
        //expected
        assertEquals(result, 5);
    }

    @Test
    public void should_return_negative_int() {
        //given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(-14);
        //when
        int result = inputReceiverScanner.nextInt();
        //expected
        assertEquals(result, -14);
    }

    @Test
    public void should_return_true() {
        //given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.enterButton()).willReturn(true);
        //when
        boolean result = inputReceiverScanner.enterButton();
        //expected
        assertEquals(result, true);
    }
}
