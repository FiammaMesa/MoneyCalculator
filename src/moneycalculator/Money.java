package moneycalculator;

public class Money {
    
    private Number amount;
    private String currency;

    public Money(Number amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Number getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
    
}
