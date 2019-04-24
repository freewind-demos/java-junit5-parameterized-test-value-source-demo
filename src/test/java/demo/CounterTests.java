package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTests {

    private Counter counter;

    @BeforeEach
    public void setUp() {
        counter = new Counter();
    }

    @ParameterizedTest(name = "Counter should countChars {0}: {1}")
    @ArgumentsSource(CustomArgumentProvider.class)
    public void shouldCountChars(String text, Integer expectedCount) {
        assertEquals(expectedCount, counter.countChars(text));
    }

    static class CustomArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("Hello", 5),
                    Arguments.of("OK", 2)
            );
        }
    }

}
