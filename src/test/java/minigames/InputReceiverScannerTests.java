package minigames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class InputReceiverScannerTests {

    @Test
    public void should_return_int() {
        //given
        InputReceiverScanner inputReceiverScanner = Mockito.mock(InputReceiverScanner.class);
        //when
        when(inputReceiverScanner.nextInt()).thenReturn(preparedMockMethodForReturnInt());
        //expected

    }

    private int preparedMockMethodForReturnInt() {
        return 5;
    }
}
