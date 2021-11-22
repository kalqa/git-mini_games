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
        given(inputReceiverScanner.nextInt()).willReturn(preparedMockMethodForReturnPositiveInt());
        //when
        int result = inputReceiverScanner.nextInt();
        //expected
        assertEquals(result, 5);
    }

    private int preparedMockMethodForReturnPositiveInt() {
        return 5;
    }

    @Test
    public void should_return_negative_int() {
        //given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.nextInt()).willReturn(preparedMockMethodForReturnNegativeInt());
        //when
        int result = inputReceiverScanner.nextInt();
        //expected
        assertEquals(result, -14);
    }

    private int preparedMockMethodForReturnNegativeInt() {
        return -14;
    }

    @Test
    public void should_return_true() {
        //given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        given(inputReceiverScanner.enterButton()).willReturn(preparedMockMethodForReturnTrue());
        //when
        boolean result = inputReceiverScanner.enterButton();
        //expected
        assertEquals(result, true);
    }

    private boolean preparedMockMethodForReturnTrue() {
        return true;
    }
}
