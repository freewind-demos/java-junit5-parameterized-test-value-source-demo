package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTests {

    private Counter counter;

    @BeforeEach
    public void setUp() {
        counter = new Counter();
    }

    @ParameterizedTest(name = "Counter should countChars {0}: {1}")
    @CsvSource({
            "Hello, 5",
            "OK, 2"
    })
    public void shouldCountChars(String text, Integer expectedCount) {
        assertEquals(expectedCount, counter.countChars(text));
    }

}
