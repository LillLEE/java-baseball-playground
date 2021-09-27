
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("WrongInputData Test")
    @ParameterizedTest
    @ValueSource(strings = {" ", "2 + 3 +", "4 4 4 + +", "+ 3 + 3", " 1 2 3 4 5", "+ 3 4"})
    void wrongInputData(String input) {
        assertThrows(IllegalStateException.class,
                () -> calculator.InputData(input));
    }

    @DisplayName("Calculate Test")
    @ParameterizedTest
    @CsvSource(value = {"6 + 2:8", "6 * 2:12", "6 / 2:3", "6 - 2:4"}, delimiter = ':')
    void calculate(String input, Integer expected) {
        Integer result = calculator.InputData(input);
        assertEquals(result,expected);
    }
}