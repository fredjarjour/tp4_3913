package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class ConvertTests {
    @Test
    void MainWindowConvertIntegers() {
        Double[] amounts = new Double[] {0d, 1d, 1000d, 1_000_000d};

        Double[][] actualAndExpectedArrays = Helpers.actualAndExpectedMainWindowConversions(amounts);
        Double[] actualResults = actualAndExpectedArrays[0];
        Double[] expectedResults = actualAndExpectedArrays[1];

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void MainWindowConvertDecimals() {
        Double[] amounts = new Double[] {0.5, Math.sqrt(2), Math.PI, 99.99, 1000.001};

        Double[][] actualAndExpectedArrays = Helpers.actualAndExpectedMainWindowConversions(amounts);
        Double[] actualResults = actualAndExpectedArrays[0];
        Double[] expectedResults = actualAndExpectedArrays[1];

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void MainWindowConvertNegatives() {
        Double[] amounts = new Double[] {-0.5, -100d, -1_000_001d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void MainWindowConvertTooBig() {
        Double[] amounts = new Double[] {1_000_000.01d, 1_000_001d, 1_000_000_000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void CurrencyConvertIntegers() {
        Double[] amounts = new Double[] {0d, 1d, 1000d, 1_000_000d};

        Double[][] actualAndExpectedArrays = Helpers.actualAndExpectedCurrencyConversions(amounts);
        Double[] actualResults = actualAndExpectedArrays[0];
        Double[] expectedResults = actualAndExpectedArrays[1];

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void CurrencyConvertDecimals() {
        Double[] amounts = new Double[] {0.5, Math.sqrt(2), Math.PI, 99.99, 1000.001};

        Double[][] actualAndExpectedArrays = Helpers.actualAndExpectedCurrencyConversions(amounts);
        Double[] actualResults = actualAndExpectedArrays[0];
        Double[] expectedResults = actualAndExpectedArrays[1];

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void CurrencyConvertNegatives() {
        Double[] amounts = new Double[] {-0.5, -100d, -1_000_001d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }

    @Test
    void CurrencyConvertTooBig() {
        Double[] amounts = new Double[] {1_000_000.01d, 1_000_001d, 1_000_000_000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(actualResults, expectedResults);
    }
}
