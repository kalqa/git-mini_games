package configuration;

import org.junit.jupiter.api.Test;

import static configuration.GameConfiguration.AMOUNT_OF_NUMBERS;
import static configuration.GameConfiguration.HIGHEST_NUMBER;
import static configuration.GameConfiguration.LOWEST_NUMBER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

class GameConfigurationTest {

    @Test
    void numbers_range_should_contains_at_least_configured_amount_of_numbers__When_numbers_configuration_is_determined() {
        assertThat((HIGHEST_NUMBER-LOWEST_NUMBER), greaterThanOrEqualTo(AMOUNT_OF_NUMBERS));
    }
}