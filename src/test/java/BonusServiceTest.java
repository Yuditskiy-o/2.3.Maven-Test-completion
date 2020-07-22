import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @ParameterizedTest (name = "[{index}] {0}")
    @CsvSource(value = {
            "'registered, bonus under limit', 100060, true, 30",
            "'registered, bonus under limit', 100000060, true, 500",
            "'unregistered, bonus under limit', 100060, false, 10",
            "'unregistered, bonus under limit', 100000060, false, 500"
    }, delimiter = ',')
    void shouldCalculateForRegisteredAndUnderLimit(String test, long amount, boolean registered, long expected) {
        BonusService service = new BonusService();
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}