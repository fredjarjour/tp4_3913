package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

import java.util.ArrayList;

public class Helpers {
    static ArrayList<Currency> currencies = Currency.init();

    public static Double[] calculateMainWindowConversions(Double[] amounts) {
        return calculateMainWindowConversions(amounts, currencies);
    }

    public static Double[] calculateMainWindowConversions(Double[] amounts, ArrayList<Currency> currencies) {
        int arraySize = amounts.length * currencies.size() * currencies.size();
        Double[] results = new Double[arraySize];

        int counter = 0;
        for (Double amount: amounts) {
            for (Currency curr1: currencies) {
                for (Currency curr2: currencies) {
                    String name1 = curr1.getName();
                    String name2 = curr2.getName();

                    // Use the main window function to calculate
                    results[counter++] = MainWindow.convert(name1, name2, currencies, amount);
                }
            }
        }

        return results;
    }

    public static Double[] calculateCurrencyConversions(Double[] amounts) {
        return calculateCurrencyConversions(amounts, currencies);
    }

    public static Double[] calculateCurrencyConversions(Double[] amounts, ArrayList<Currency> currencies) {
        int arraySize = amounts.length * currencies.size() * currencies.size();
        Double[] results = new Double[arraySize];

        int counter = 0;
        for (Double amount: amounts) {
            for (Currency curr1: currencies) {
                for (Currency curr2: currencies) {
                    //Get exchange rate (-1 if absent)
                    Double exchangeRate = curr1.getExchangeValues().getOrDefault(curr2.getShortName(), -1d);

                    // Use the currency convert to calculate
                    results[counter++] = Currency.convert(amount, exchangeRate);
                }
            }
        }

        return results;
    }

    public static Double[] calculateActualConversions(Double[] amounts) {
        return calculateActualConversions(amounts, currencies);
    }

    public static Double[] calculateActualConversions(Double[] amounts, ArrayList<Currency> currencies) {
        int arraySize = amounts.length * currencies.size() * currencies.size();
        Double[] results = new Double[arraySize];

        int counter = 0;
        for (Double amount: amounts) {
            for (Currency curr1: currencies) {
                for (Currency curr2: currencies) {
                    //Get exchange rate from the dictionary (-1 if absent)
                    Double exchangeRate = curr1.getExchangeValues().getOrDefault(curr2.getShortName(), -1d);
                    // Calculate ourselves using exchange rate
                    results[counter++] = Math.round(amount * exchangeRate * 100d) / 100d;
                }
            }
        }

        return results;
    }
}
