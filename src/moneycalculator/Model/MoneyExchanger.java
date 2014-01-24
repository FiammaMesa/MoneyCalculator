package moneycalculator.Model;

public class MoneyExchanger {

    public Money exchange (Money money, ExchangeRate exchangeRate){
        return new Money(money.getAmount().multiply(money.getAmount(), exchangeRate.getRate()), exchangeRate.getTo()); //prodria ser from?
    }
}
