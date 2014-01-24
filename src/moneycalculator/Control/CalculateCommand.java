package moneycalculator.Control;

import moneycalculator.Model.Money;
import moneycalculator.Model.Number;
import MoneyCalculator.UserInterface.CurrencyDialog;
import MoneyCalculator.UserInterface.MoneyDialog;
import moneycalculator.Model.ExchangeRateSet;
import moneycalculator.UserInterface.MoneyViewer;

public class CalculateCommand extends Command{
    
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
            moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }

    public Number getExchangeRate(){
        ExchangeRateSet rates = ExchangeRateSet.getInstance();
        return rates.getRateFromSet(moneyDialog.getMoney().getCurrency(), currencyDialog.getCurrency());//MIRAR!
    }
    
    private Number calculateAmount(){
        return Number.multiply(getExchangeRate(), moneyDialog.getMoney().getAmount());
    }

}
