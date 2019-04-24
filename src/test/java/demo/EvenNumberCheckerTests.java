package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvenNumberCheckerTests {

    private EvenNumberChecker evenNumberChecker;

    @BeforeEach
    public void setUp() {
        evenNumberChecker = new EvenNumberChecker();
    }

    @ParameterizedTest(name = "Number {0} should be even")
    @ValueSource(ints = {0, 2, 4, 6, 8})
    public void isEven(Integer number) {
        assertEquals(true, evenNumberChecker.isEven(number));
    }

    @ParameterizedTest(name = "Number {0} should not be even")
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void isNotEven(Integer number) {
        assertEquals(false, evenNumberChecker.isEven(number));
    }

}
