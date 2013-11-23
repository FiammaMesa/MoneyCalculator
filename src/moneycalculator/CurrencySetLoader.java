package moneycalculator;

public class CurrencySetLoader {

    public CurrencySetLoader() {
    }

    public void load(){
        CurrencySet set= CurrencySet.getInstance();
        set.add(new Currency ("USD", "Dollar Americano", "$"));
        set.add(new Currency ("EUR", "Euro", "€"));
        set.add(new Currency ("CAD", "Dollar Canadiense", "C$"));
        set.add(new Currency ("GBP", "Libra esterlina", "£"));
    }
}
