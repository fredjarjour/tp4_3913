package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class ConvertTestsBlackBox {
    @Test
    void MainWindowConvertIntegers() {
        Double[] amounts = new Double[] {0d, 1000d, 1_000_000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void MainWindowConvertDecimals() {
        Double[] amounts = new Double[] {0.01, Math.PI, 999_999.99};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void MainWindowConvertNegatives() {
        Double[] amounts = new Double[] {-0.01, -1d, -1000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void MainWindowConvertTooBig() {
        Double[] amounts = new Double[] {1_000_000.01d, 1_000_001d, 1_000_000_000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertIntegers() {
        Double[] amounts = new Double[] {0d, 1000d, 1_000_000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertDecimals() {
        Double[] amounts = new Double[] {0.01, Math.PI, 999_999.99};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertNegatives() {
        Double[] amounts = new Double[] {-0.01, -1d, -1000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertTooBig() {
        Double[] amounts = new Double[] {1_000_000.01d, 1_000_001d, 1_000_000_000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }
}
