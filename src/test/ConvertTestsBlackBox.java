package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class ConvertTestsBlackBox {
    @Test 
    void MainWindowConvertIntegers() { //Test if the Main Window conversion gives the correct result with integer numbers
        Double[] amounts = new Double[] {0d, 1000d, 1_000_000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void MainWindowConvertDecimals() { //Test if the Main Window conversion gives the correct result with decimal numbers
        Double[] amounts = new Double[] {0.01, Math.PI, 999_999.99};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void MainWindowConvertNegatives() { //Test if the Main Window conversion gives the correct result with negative numbers
        Double[] amounts = new Double[] {-0.01, -1d, -1000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void MainWindowConvertTooBig() { //Test if the Main Window conversion gives the correct result with numbers that are too big
        Double[] amounts = new Double[] {1_000_000.01d, 1_000_001d, 1_000_000_000d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertIntegers() { //Test if the Currency conversion gives the correct result with integer numbers
        Double[] amounts = new Double[] {0d, 1000d, 1_000_000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertDecimals() { //Test if the Currency conversion gives the correct result with decimal numbers
        Double[] amounts = new Double[] {0.01, Math.PI, 999_999.99};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertNegatives() { //Test if the Currency conversion gives the correct result with negative numbers
        Double[] amounts = new Double[] {-0.01, -1d, -1000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyConvertTooBig() { //Test if the Currency conversion gives the correct result with numbers that are too big
        Double[] amounts = new Double[] {1_000_000.01d, 1_000_001d, 1_000_000_000d};

        Double[] actualResults = Helpers.calculateCurrencyConversions(amounts);
        Double[] expectedResults = new Double[actualResults.length];
        Arrays.fill(expectedResults, -1d); // We expect the program to return -1 on error

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }
}
