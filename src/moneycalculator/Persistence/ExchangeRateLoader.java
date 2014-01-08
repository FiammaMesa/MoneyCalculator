package moneycalculator.Persistence;

import Model.MoneyCalculator.Number;
import Model.MoneyCalculator.Currency;
import Model.MoneyCalculator.ExchangeRate;
import java.util.Date;

public class ExchangeRateLoader {
    
    public ExchangeRate load (Date date, Currency from, Currency to){
        return new ExchangeRate(date, from, to, new Number(5));
    }
}
