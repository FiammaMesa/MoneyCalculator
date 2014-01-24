package moneycalculator.Model;

import java.util.ArrayList;

public class ExchangeRateSet extends ArrayList<ExchangeRate> {

    private static ExchangeRateSet instances;

    private ExchangeRateSet() {
        super();
    }

    public static ExchangeRateSet getInstance() {
        if (instances == null) {
            instances = new ExchangeRateSet();
        }
        return instances;
    }

    public Number getRateFromSet(Currency currencyFrom, Currency currencyTo) {
//        for (ExchangeRate exchangeRate : this) {
//            if (exchangeRate.getFrom().equals(currencyFrom) && exchangeRate.getTo().equals(currencyTo)) {
//                return exchangeRate.getRate();
//            }
//        }
//        return new Number(0);
        for (ExchangeRate exchangeRate : this) {
            if (exchangeRate.getFrom().getCode().equals(currencyFrom.getCode()) && exchangeRate.getTo().getCode().equals(currencyTo.getCode())) {
                return exchangeRate.getRate();
            }
        }
        return new Number(0);
    }
}
