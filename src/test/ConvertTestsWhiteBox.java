package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ConvertTestsWhiteBox {
    @Test
    void MainWindowNormalBehaviour() { //Test if the Main Window conversion gives the correct result
        ArrayList<Currency> currencies = Currency.init();

        Currency curr1 = currencies.get(0);
        Currency curr2 = currencies.get(1);

        Double actualResult = MainWindow.convert(curr1.getName(), curr2.getName(), currencies, 1d);

        Double exchangeRate = curr1.getExchangeValues().getOrDefault(curr2.getShortName(), -1d);
        Double expectedResult = Math.round(exchangeRate * 100d) / 100d;

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void MainWindowShortNameCurrency2Null() { //Test if the Main Window conversion gives the correct result
        Double result = MainWindow.convert("US Dollar", "Zimbabwe dollar", Currency.init(), 1d);
        Assertions.assertEquals(-1d, result);
    }

    @Test
    void MainWindowCurrency1NotInCurrencies() { //Test if the Main Window conversion gives the correct result with a currency that is not in the list
        ArrayList<Currency> currencies = Currency.init();

        // Remove USD from the currencies
        currencies.remove(0);
        for (Currency currency: currencies) {
            currency.getExchangeValues().remove("USD");
        }

        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 1d);
        Assertions.assertEquals(-1d, result);
    }

    @Test
    void MainWindowCurrenciesEmpty() { //Test if Main Window conversion gives the correct result with an empty list of currencies
        ArrayList<Currency> currencies = new ArrayList<>();

        Double result = MainWindow.convert("US Dollar", "Euro", currencies, 1d);
        Assertions.assertEquals(-1d, result);
    }

    @Test
    void MainWindowAllCombinations() { //Test if the Main Window conversion gives the correct result for all combinations of currencies
        Double[] amounts = new Double[] {1d};

        Double[] actualResults = Helpers.calculateMainWindowConversions(amounts);
        Double[] expectedResults = Helpers.calculateActualConversions(amounts);

        Assertions.assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    void CurrencyNormalBehaviour() {  //Test if the Currency conversion gives the correct result
        ArrayList<Currency> currencies = Currency.init();
        Currency curr1 = currencies.get(0);
        Currency curr2 = currencies.get(1);
        Double amount = 1d;

        //Get exchange rate (-1 if absent)
        Double exchangeRate = curr1.getExchangeValues().getOrDefault(curr2.getShortName(), -1d);

        // Use the currency convert to calculate
        Double actualResult = Currency.convert(amount, exchangeRate);

        Double expectedResult = Math.round(amount * exchangeRate * 100d) / 100d;

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
