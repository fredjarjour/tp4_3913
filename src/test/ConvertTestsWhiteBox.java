package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ConvertTestsWhiteBox {
    // We cover these arcs:
    // shortNameCurrency2 == null (1)
    // shortNameCurrency2 != null
    //      currency1 not in currencies (2)
    //      currency1 in currencies (3) -- NORMAL BEHAVIOUR
    @Test
    void MainWindowShortNameCurrency2Null() {
        Double result = MainWindow.convert("US Dollar", "Zimbabwe dollar", Currency.init(), 1d);
        Assertions.assertEquals(-1d, result);
    }

    @Test
    void MainWindowCurrency1NotInCurrencies() {
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
    void MainWindowNormalBehaviour() {
        ArrayList<Currency> currencies = Currency.init();

        Currency curr1 = currencies.get(0);
        Currency curr2 = currencies.get(1);

        Double actualResult = MainWindow.convert(curr1.getName(), curr2.getName(), currencies, 1d);

        Double exchangeRate = curr1.getExchangeValues().getOrDefault(curr2.getShortName(), -1d);
        Double expectedResult = Math.round(exchangeRate * 100d) / 100d;

        Assertions.assertEquals(expectedResult, actualResult);
    }


}
