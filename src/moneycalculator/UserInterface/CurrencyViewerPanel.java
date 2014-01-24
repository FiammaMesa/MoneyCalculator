package moneycalculator.UserInterface;

import moneycalculator.Model.Currency;
import MoneyCalculator.UserInterface.CurrencyViewer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CurrencyViewerPanel extends JPanel implements CurrencyViewer {

    private JLabel label;
    
    public void show (Currency currency){
        label.setText(currency.toString());
    }
    
    public void createComponents(){
        this.add(createCurrencyDisplay());
    }

    private JLabel createCurrencyDisplay() {
        label = new JLabel();
        return label;
    }
}
