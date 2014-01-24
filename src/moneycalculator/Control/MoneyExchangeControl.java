package moneycalculator.Control;

import moneycalculator.Model.Currency;
import moneycalculator.Model.Money;
import MoneyCalculator.UserInterface.CurrencyDialog;
import MoneyCalculator.UserInterface.MoneyDialog;
import java.sql.SQLException;
import moneycalculator.Persistence.ExchangeRateLoader;
import moneycalculator.UserInterface.MoneyViewer;

public class MoneyExchangeControl {
    private ExchangeRateLoader exchangeRateLoader;
    private CurrencyDialog currencyDialog;
    private MoneyDialog moneyDialog;
    private MoneyViewer moneyViewer;

    public MoneyExchangeControl(){
    
    }

    public void execute() throws SQLException {
        Money money = readMoney();
        Currency currency = readCurrency();
    }

    private Money readMoney() {
        return moneyDialog.getMoney();
    }

    private Currency readCurrency() {
        return currencyDialog.getCurrency();
    }

}
